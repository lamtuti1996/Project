/**
 * 
 */
package com.azplay.azpotal.azgate.sc.controller;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.azplay.azpotal.azgate.sc.app.Server;
import com.azplay.azpotal.azgate.sc.common.Common;
import com.azplay.azpotal.azgate.sc.common.Constant;
import com.azplay.azpotal.azgate.sc.dao.DataDao;
import com.azplay.azpotal.azgate.sc.db.DatabaseConnector;
import com.azplay.azpotal.azgate.sc.entity.Client;
import com.azplay.azpotal.azgate.sc.entity.RespondClient;
import com.azplay.azpotal.azgate.sc.model.MOReceiver;
import com.azplay.azpotal.azgate.sc.model.MORequest;
import com.google.gson.Gson;

import spark.Request;
import spark.Response;
import spark.Route;

/**
 * @author thang
 *
 */

public class MOController {
	
	private static final Logger log = LoggerFactory.getLogger(MOController.class);
	
	DatabaseConnector dc;
	public MOController() {
		
	}
	
	public MOController(DatabaseConnector dc) {
		this.dc = dc;
	}

	public Route handleRequest = (Request request, Response response) -> {
		
		DataDao dataDao = new DataDao();
		boolean validate = Common.validate(request);
		MORequest moRequest = null;
		String rand = Common.genRand();
		String partnerPassword = Server.serverConfig.getPartnerPass();
		String telcoCodes = Server.serverConfig.getTelcoCodes();
		String partnerId = Server.serverConfig.getPartnerId();
		String shootCode = Server.serverConfig.getShootCode();
		Connection connection = null;
		try {
			 connection = dc.getPooledConnection();
		}catch(Exception e) {
			if (connection != null) {
				connection.close();
			}
			return Constant.STR_Nega_1;
		}
		try {
			if (validate) {
				Date date = new Date();
				Timestamp timestamp = new Timestamp(date.getTime());
				// create object insert db
				if(!Server.serverConfig.getPartnerId().equals(request.queryParams("username"))){
					log.warn("========== Return MO: Sai username =======");
					return Constant.STR_Nega_1;
				}
				MOReceiver moReciever = new MOReceiver(request.queryParams("mo_id"), partnerId,
						request.queryParams("commandCode"), request.queryParams("operator"), timestamp,
						request.queryParams("serviceId"), request.queryParams("sender"), request.queryParams("message"),
						Constant.STATUS_PROCESS);//p
				String[] telcoList = telcoCodes.split(";");
				String telco = moReciever.getTelco().toUpperCase();
				telco = Common.convertTelco(telco);
				Set<String> telcoSet = new HashSet<String>(Arrays.asList(telcoList));
				if (!telcoSet.contains(telco)) {
					log.warn("========== Return MO: Sai Ma Nha Mang =======");
					return Constant.STR_Nega_1;//-1
				}
				moReciever.setTelco(telco);
				if (!shootCode.equals(request.queryParams("serviceId"))) {
					log.warn("========== Return MO: Sai Dau So Tiep Nhan =======");
					return Constant.STR_Nega_1;//-1
				}
				
				// check key
				String keyPartner = request.queryParams("username") + "|" + request.queryParams("mo_id") + "|"
						+ partnerPassword;

				String keyPartnerMD5 = Common.MD5(keyPartner);
				log.info("keyPartnerMD5: ");
				log.info(keyPartnerMD5);
				log.info("key query: ");
				log.info(request.queryParams("key"));
				if (!keyPartnerMD5.equals(request.queryParams("key"))) {
					log.info("========== Return MO: Sai Key Token =======");
					return Constant.STR_Nega_1;//-1
				}

				/*
				 * select object client
				 */
				Client clientData = dataDao.findClientByID(connection, moReciever.getCommandCode());
				
				if (clientData == null) {
					connection.close();
					log.info("========== Return MO: Sai ma dich vu =======");
					return Constant.STR_Nega_1;
				}
				log.info("Selected client MO: "+ clientData.getClientID());
				
				// convert MORequest
				String content = Base64.getEncoder().encodeToString(moReciever.getMoContent().getBytes(StandardCharsets.US_ASCII));
				String key = timestamp + "|" + rand+ "|" + clientData.getClientID() + "|"
						+ clientData.getClientPass() + "|" 
						+ moReciever.getMOId() + "|"
						+ moReciever.getMsisdn() + "|"
						+ moReciever.getSc() + "|" 
						+ content + "|"
						+ moReciever.getTelco();

				String passToken = Common.SHA256(key);
				
				moRequest = new MORequest(moReciever.getMOId(), moReciever.getMsisdn(),
						moReciever.getSc(), content,
						moReciever.getTelco(), timestamp, rand, clientData.getClientID(), passToken);
				/*
				 * insert MOReciever into DB
				 */
				int stateInsert = dataDao.insertMOObj(connection, moReciever, clientData.getClientID());
				log.debug("Inserted: ");
				log.debug(String.valueOf(stateInsert));
				if (Constant.INT_Nega_1 == stateInsert) {
					connection.close();
					log.warn("========== Return MO: MOId da duoc su dung =======");
					return Constant.STR_Nega_1;
				} else if (Constant.INT_Nega_2 == stateInsert) {
					connection.close();
					log.warn("========== Return MO: 10-Loi he thong =======");
					return Constant.STR_Nega_1;
				}
				
				/*
				 * forward to client
				 */
				log.info("======Send MO request=======");
				String resClient = sendPost(clientData.getAZGateMOURL(), moRequest);
				log.info("Receice MO request: ");
				log.info(resClient);
				/*
				 * nhan respond client
				 */
				Gson gson = new Gson();
				RespondClient resClientObj = gson.fromJson(resClient, RespondClient.class);

				if (Constant.STR_1.equals(resClientObj.getStatus())) {
					/*
					 * parse respond client
					 * update status WMT
					 * send respond for partner
					 */
					log.info("======Update Status WMT=======");
					dataDao.updateMOObj(connection, Constant.STATUS_WMT, moRequest.getMOId(), partnerId, moRequest.getClientId());
					connection.close();
					log.info("==========Return MO: Success=======");
					return Constant.STR_0;

				} else {
					// update status E
					// send respond for partner
					log.info("======Update Status E=======");
					dataDao.updateMOObj(connection, Constant.STATUS_ERROR, moRequest.getMOId(), partnerId, moRequest.getClientId());
					connection.close();
					log.warn("==========Return MO: Response send MO is fail =======");
					return Constant.STR_Nega_1;
				}

			} else {
				log.info("========== Return MO: Thieu tham so =======");
				return Constant.STR_Nega_1;
			}
		} catch (Exception e) {
			log.error("Error SYS MO: ", e);
			if (connection != null) {
				connection.rollback();
				connection.close();
			}
			return Constant.STR_Nega_1;
		} 
	};
	
		// send request to client
		private String sendPost(String url, MORequest moRequest) throws Exception {

			CloseableHttpClient client = HttpClientBuilder.create().build();
			HttpPost post = new HttpPost(url);
			post.setHeader("User-Agent", Constant.USER_AGENT);
			List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
			urlParameters.add(new BasicNameValuePair("moId", moRequest.getMOId()));
			urlParameters.add(new BasicNameValuePair("msisdn", moRequest.getMsisdn()));
			urlParameters.add(new BasicNameValuePair("sc", moRequest.getSc()));
		    urlParameters.add(new BasicNameValuePair("content", moRequest.getContent()));
			urlParameters.add(new BasicNameValuePair("telco", moRequest.getTelco()));
			urlParameters.add(new BasicNameValuePair("timeStamp", moRequest.getTimeStamp().toString()));
			urlParameters.add(new BasicNameValuePair("rand", moRequest.getRand()));
			urlParameters.add(new BasicNameValuePair("clientId", moRequest.getClientId()));
			urlParameters.add(new BasicNameValuePair("passToken", moRequest.getTokenPass()));
			post.setEntity(new UrlEncodedFormEntity(urlParameters));
			CloseableHttpResponse response = client.execute(post);
			log.info("\nSending 'POST' request to URL : " + url);
			log.info("Post parameters : " + post.getEntity());
			log.info("Response Code : " +
	                                    response.getStatusLine().getStatusCode());

			 try {
		            HttpEntity entity = response.getEntity();
		            if (entity != null) {
		                long len = entity.getContentLength();
		                if (len != -1 && len < 2048) {
		                    return EntityUtils.toString(entity);
		                } 
		            }
		        } finally {
		            response.close();
		        }
			 return Constant.STR_EMTY;
		}
}
