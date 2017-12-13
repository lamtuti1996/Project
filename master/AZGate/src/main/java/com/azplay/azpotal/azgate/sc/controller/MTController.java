/**
 * 
 */
package com.azplay.azpotal.azgate.sc.controller;

import java.net.URI;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Base64;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.azplay.azpotal.azgate.sc.app.Server;
import com.azplay.azpotal.azgate.sc.common.Common;
import com.azplay.azpotal.azgate.sc.common.Constant;
import com.azplay.azpotal.azgate.sc.dao.DataDao;
import com.azplay.azpotal.azgate.sc.db.DatabaseConnector;
import com.azplay.azpotal.azgate.sc.entity.Client;
import com.azplay.azpotal.azgate.sc.entity.Error;
import com.azplay.azpotal.azgate.sc.entity.RespondSendClient;
import com.azplay.azpotal.azgate.sc.model.DataObject;
import com.azplay.azpotal.azgate.sc.model.MTReceiver;
import com.azplay.azpotal.azgate.sc.model.MTRequest;
import com.azplay.azpotal.azgate.sc.model.MTResponse;

import spark.Request;
import spark.Response;
import spark.Route;

/**
 * @author thang
 *
 */
public class MTController {
	
	DatabaseConnector dc;
	public MTController() {
		
	}
	
	public MTController(DatabaseConnector dc) {
		this.dc = dc;		
	}

	private static final Logger log = LoggerFactory.getLogger(MTController.class);
	
	public Route handleRequest = (Request request, Response response) -> {
		MTReceiver mtReceiver = Common.validateMT(request);
		DataDao dataDao = new DataDao();
		MTRequest mtRequest = new MTRequest();
		RespondSendClient resClient = new RespondSendClient();
		
		log.info("------ Start process MT Request ------- ");
		if (mtReceiver != null) {
			Connection connection = null;
			try {
				 connection = dc.getPooledConnection();
			}catch(Exception e) {
				if (connection != null) {
					connection.close();
				}
				resClient = resClient(Constant.STR_Nega_1,  Constant.ERR_MESS_112, Constant.ERR_CODE_112, null);
				log.error("Error: ", e);
				return resClient;
			}
			try{
				DataObject dataObj = new DataObject();
				
				Client clientData = dataDao.findClientByClientId(connection, mtReceiver.getClientId());
				
				// Check client
				if (clientData == null) {
					connection.commit();
					connection.close();
					log.warn("==========Return: "+Constant.ERR_MESS_100+"=======");
					return resClient(Constant.STR_Nega_1, Constant.ERR_MESS_100, Constant.ERR_CODE_100, null);
				}
				log.info("Select client: ");
				log.info(clientData.getClientID());
				
				/*
				 * check passToken
				 */
				String content = new String(Base64.getDecoder().decode(mtReceiver.getContent()));
				String passToken = Common.getPassTokenMT(mtReceiver, clientData);
				String passTokenSHA = Common.SHA256(passToken);
				log.info("passTokenSHA: ");
				log.info(passTokenSHA.toString());
				log.info("passToken query: ");
				log.info(mtReceiver.getPassToken().toString());
				if (!passTokenSHA.equals(mtReceiver.getPassToken())) {
					connection.close();
					log.warn("==========Return: "+Constant.ERR_MESS_102+"=======");
					return resClient(Constant.STR_Nega_1, Constant.ERR_MESS_102, Constant.ERR_CODE_102, null);
				}
				
				connection.setAutoCommit(false);
				dataObj = dataDao.findMOObj(connection, mtReceiver.getMOId(), Server.serverConfig.getPartnerId(),
						mtReceiver.getClientId());
				
				if (dataObj == null) {
					connection.commit();
					connection.close();
					return resClient(Constant.STR_Nega_1, Constant.ERR_MESS_111, Constant.ERR_CODE_111, null);
				}
				log.debug("Select MO: ");
				log.debug(dataObj.getStatus());
				// Check status MO
				if (!Constant.STATUS_WMT.equals(dataObj.getStatus())) {
					connection.commit();
					connection.close();
					log.warn("==========Return: "+Constant.ERR_MESS_113+"=======");
					return resClient(Constant.STR_Nega_1, Constant.ERR_MESS_113, Constant.ERR_CODE_113, null);
				}
				
				log.info("===============Update Status P============");
				dataDao.updateMTObj(connection, mtReceiver, Constant.STATUS_PROCESS, content);
				connection.commit();
				
				if (content.length() > Constant.INT_160) {
					dataDao.updateMTObj(connection, mtReceiver, Constant.STATUS_ERROR, content);
					connection.commit();
					connection.close();
					log.warn("==========Return: "+Constant.ERR_MESS_103+"=======");
					return resClient(Constant.STR_Nega_1, Constant.ERR_MESS_103, Constant.ERR_CODE_103, null);
				}
				String messageType = "";
				if("1".equals(mtReceiver.getMtType())){
					// truong hop tinh cuoc
					messageType = Constant.STR_1;
				} else if ("0".equals(mtReceiver.getMtType())){
					// truong hop ko tinh cuoc
					messageType = Constant.STR_2;
				} else {
					// mtType fail
					dataDao.updateMTObj(connection, mtReceiver, Constant.STATUS_ERROR, content);
					connection.commit();
					connection.close();
					log.warn("==========Return: "+Constant.ERR_MESS_104+"=======");
					return resClient(Constant.STR_Nega_1, Constant.ERR_MESS_104, Constant.ERR_CODE_104, null);
				}
				log.info("Message type: "+messageType);
				// Convert MTRequest
				mtRequest = convertMTRes(connection, mtReceiver, dataObj, dataDao, clientData.getCommandCode(),
						messageType);
				log.info("Convert MT: ");
				log.info(mtRequest.getMOId());
				/*
				 * send MTRequest
				 *  nhan respones tu partner
				 */
				
				String resPartner = sendPost(Server.serverConfig.getUrlPartner(), mtRequest);
				boolean flgSucces = true;
				log.info("Response MT: ");
				log.info(resPartner);
				// parser respond 
				if(Constant.NOR_STR_MESS_0.equals(resPartner)){
					log.info("==========Return SUCCESS=======");
					resClient = resClient(Constant.STR_1, Constant.STR_EMTY, Constant.STR_EMTY, mtReceiver);
				} else {
					log.warn("==========Return: "+Constant.ERR_MESS_112+"=======");
					resClient = resClient(Constant.STR_Nega_1, Constant.ERR_MESS_112, Constant.ERR_CODE_112, null);
					flgSucces = false;
				}
				
				// update status
				if (flgSucces) {
					log.info("=======Update status Success=====");
					dataDao.updateMTObj(connection, mtReceiver, Constant.STATUS_SUCCESS, content);
				} else {
					// update status la E
					log.info("=======Update status Error=====");
					dataDao.updateMTObj(connection, mtReceiver, Constant.STATUS_ERROR, content);
				}
				connection.commit();
				connection.close();
				return resClient;
			} catch (Exception e) {
				connection.rollback();
				connection.close();
				log.error("==========Return: "+Constant.ERR_MESS_112+"=======");
				resClient = resClient(Constant.STR_Nega_1,  Constant.ERR_MESS_112, Constant.ERR_CODE_112, null);
				log.error("Error MT: ", e);
				return resClient;
			}
		} else {
			log.warn("==========Return: "+Constant.ERR_MESS_101+"=======");
			resClient = resClient(Constant.STR_Nega_1, Constant.ERR_MESS_101, Constant.ERR_CODE_101, null);
			return resClient;
		}
		
	};
	
	private MTRequest convertMTRes(Connection connection, MTReceiver mtReceiver, DataObject dataObj, DataDao dataDao,
			String commandCode, String messageType) {
		MTRequest mtRequest = new MTRequest();
		String userName = Server.serverConfig.getAhpUsername();
		String pass = Server.serverConfig.getAhpPassword();
		String keyResMT = userName + "|" + mtReceiver.getMOId() + "|" + pass;
		String keyResMTMD5 = null;
		String content = new String(Base64.getDecoder().decode(mtReceiver.getContent()));
		try {
			keyResMTMD5 = Common.MD5(keyResMT);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
		
		mtRequest.setMOId(mtReceiver.getMOId());
		mtRequest.setCommandCode(commandCode);
		mtRequest.setMessage(content);
		mtRequest.setMessageIndex(Constant.STR_1);
		mtRequest.setMessageType(messageType);
		mtRequest.setOperator(dataObj.getTelco());
		mtRequest.setReceiver(mtReceiver.getMsisdn());
		mtRequest.setSender(dataObj.getMsisdn());
		mtRequest.setServiceId(mtReceiver.getSc());
		mtRequest.setKey(keyResMTMD5);
		mtRequest.setUserName(userName);
		mtRequest.setContentType(Constant.STR_0);
		mtRequest.setRequestTime(formatter.format(dataObj.getCreateTime()));
		return mtRequest;
	}
	
	// send request to client
	private String sendPost(String url, MTRequest mtRequest) throws Exception {

		URI uri = new URIBuilder()
				.setScheme("http")
				.setHost("service.ahp.vn:6688")
				.setPath("service/ahp/mt6x88")
				.setParameter("mo_id", mtRequest.getMOId())
				.setParameter("serviceId", mtRequest.getServiceId())
				.setParameter("sender", mtRequest.getSender())
				.setParameter("receiver", mtRequest.getReceiver())
				.setParameter("message", mtRequest.getMessage())
				.setParameter("requestTime", mtRequest.getRequestTime())
				.setParameter("operator", Common.reconvertTelco(mtRequest.getOperator()))
				.setParameter("commandCode", mtRequest.getCommandCode())
				.setParameter("contentType", mtRequest.getContentType())
				.setParameter("messageType", mtRequest.getMessageType())
				.setParameter("messageIndex", mtRequest.getMessageIndex())
				.setParameter("userName", mtRequest.getUserName())
				.setParameter("key", mtRequest.getKey())
				.build();
		HttpGet post = new HttpGet(uri);
		post.addHeader("content-type", Constant.USER_AGENT);
		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse response = httpclient.execute(post);

		try {
	            HttpEntity entity = response.getEntity();
	           
	            if (entity != null) {
	            	 String body = EntityUtils.toString(entity);
	                 return body;
	            }
	        } finally {
	        	
	            response.close();
	        }
		 return Constant.STR_EMTY;
	}
		
	private RespondSendClient resClient (String status, String errMes, String errCode, MTReceiver data){
		Error error = new Error();
		MTResponse mtResponse = new MTResponse(data.getMOId(), data.getSc(), data.getMsisdn(), data.getContent(), data.getMtType(), data.getClientId());
		if (Constant.STR_EMTY.equals(errMes) || Constant.STR_EMTY.equals(errCode) || errMes == null
				|| errCode == null) {
			error = null;
		} else {
			error.setCode(errCode);
			error.setMessage(errMes);
		}
		
		RespondSendClient respondSendClient = new RespondSendClient(status, mtResponse, error);
		return respondSendClient;
	}
	
}
