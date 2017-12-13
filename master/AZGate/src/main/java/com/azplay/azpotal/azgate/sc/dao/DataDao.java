package com.azplay.azpotal.azgate.sc.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.azplay.azpotal.azgate.sc.app.Server;
import com.azplay.azpotal.azgate.sc.common.Constant;
import com.azplay.azpotal.azgate.sc.entity.Client;
import com.azplay.azpotal.azgate.sc.entity.OAMDetail;
import com.azplay.azpotal.azgate.sc.entity.OAMGroupByStatus;
import com.azplay.azpotal.azgate.sc.model.DataObject;
import com.azplay.azpotal.azgate.sc.model.MOReceiver;
import com.azplay.azpotal.azgate.sc.model.MTReceiver;
import com.azplay.azpotal.azgate.sc.model.OAMDetailReceiver;
import com.azplay.azpotal.azgate.sc.model.OAMGroupReceiver;

public class DataDao {
	private static final Logger log = LoggerFactory.getLogger(DataDao.class);

	public Client findClientByID(Connection conn, String commandCode){
	  
	  	Client client = null;
	  	String query = "select CLIENTID as clientID,"
        		+ " CLIENT_PASSWORD as clientPass,"
        		+ " AZGATE_MO_URL as azGreatMoUrl,"
        		+ " COMMAND_CODE as commandCode"
        		+ " from CLIENT cl where cl.COMMAND_CODE =?";
	  	try {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, commandCode);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				client = new Client();
				client.setClientID(resultSet.getString("clientID"));
				client.setClientPass(resultSet.getString("clientPass"));
				client.setAZGateMOURL(resultSet.getString("azGreatMoUrl"));
				client.setCommandCode(resultSet.getString("commandCode"));
			} 
			resultSet.close();
			preparedStatement.closeOnCompletion();
		} catch (SQLException e) {
			log.error("Error When Find Client By Command Code: "+ commandCode + " : "+ e);
			Server.hipChatClient.SendHipChatMessage("Error When Find Client By Command Code: "+ commandCode + " : "+ e);
		}
		  return  client;
	  }
  
  // insert Mo request
  public int insertMOObj(Connection conn, MOReceiver receiver, String clientId){
	  String query = "INSERT INTO TRANSACTIONS_SC"
      		+ " (MO_ID, PARTNERID, CLIENTID, TELCO,"
      		+ " CREATETIME, SC, MSISDN,"
      		+ " MO_CONTENT, STATUS)"
      		+ " VALUES"
      		+ " (?, ?, ?,"
      		+ " ?, ?,"
      		+ " ?, ?, ?, ?)";
	  try {
		  	PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, receiver.getMOId());
			preparedStatement.setString(2, receiver.getPartnerId());
			preparedStatement.setString(3, clientId);
			preparedStatement.setString(4, receiver.getTelco());
			preparedStatement.setTimestamp(5, receiver.getTimeStamp());
			preparedStatement.setString(6, receiver.getSc());
			preparedStatement.setString(7, receiver.getMsisdn());
			preparedStatement.setString(8, receiver.getMoContent());
			preparedStatement.setString(9, receiver.getStatus());
			
			preparedStatement.executeUpdate();
			
			preparedStatement.closeOnCompletion();
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			if(Constant.INT_1 == e.getErrorCode()){
				return Constant.INT_Nega_1;
			} else {
				log.error("Error when insert MO obj: "+receiver.getMOId(), e);
				Server.hipChatClient.SendHipChatMessage("Error when insert MO obj: "+receiver.getMOId()+" "+ e);
				return Constant.INT_Nega_2;	
			}
		}
  }
  
	//update Mo after receiver respond from client
	 public void updateMOObj (Connection conn, String status, String moId, String partnerId, String clientId) throws SQLException{
		 String query = "UPDATE TRANSACTIONS_SC"
		         		+ " SET"
		         		+ " STATUS = ?"
		         		+ " WHERE MO_ID = ? AND PARTNERID = ? AND CLIENTID = ?";
		 try {
			 PreparedStatement preparedStatement = conn.prepareStatement(query);
			 preparedStatement.setString(1, status);
			 preparedStatement.setString(2, moId);
			 preparedStatement.setString(3, partnerId);
			 preparedStatement.setString(4, clientId);
			 preparedStatement.executeUpdate();
			 preparedStatement.closeOnCompletion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error("Error when update MO obj: " + moId, e);
			Server.hipChatClient.SendHipChatMessage("Error when update MO obj: " + moId+" "+ e);
			throw e;
		}
	 }
	 
	 // find MOObject
	 public DataObject findMOObj(Connection conn, String moId, String partnerId, String clientId){
		 DataObject moObj = null;
		  	String query = "select MO_ID as moId,"
	        		+ " PARTNERID as partnerId,"
	        		+ " CLIENTID as clientId,"
	        		+ " TELCO as telco,"
	        		+ " CREATETIME as createTime,"
	        		+ " UPDATETIME as updateTime,"
	        		+ " SC as sc,"
	        		+ " MSISDN as msisdn,"
	        		+ " MO_CONTENT as moContetn,"
	        		+ " MT_CONTENT as mtContent,"
	        		+ " STATUS as status"
	        		+ " from TRANSACTIONS_SC tran where tran.MO_ID =?"
	        		+ " AND tran.PARTNERID = ?"
	        		+ " AND tran.CLIENTID = ?"
	        		+ " FOR UPDATE";
		  	try {
				PreparedStatement preparedStatement = conn.prepareStatement(query);
				preparedStatement.setString(1, moId);
				preparedStatement.setString(2, partnerId);
				preparedStatement.setString(3, clientId);
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()){
					moObj = new DataObject();
					moObj.setMOId(resultSet.getString("moId"));
					moObj.setPartnerID(resultSet.getString("partnerId"));
					moObj.setClientID(resultSet.getString("clientId"));
					moObj.setTelco(resultSet.getString("telco"));
					Date createDate = new Date(resultSet.getTimestamp("createTime").getTime());
					Date updateDate = new Date(resultSet.getTimestamp("updateTime").getTime());
					moObj.setCreateTime(createDate);
					moObj.setUpdateTime(updateDate);
					moObj.setSc(resultSet.getString("sc"));
					moObj.setMsisdn(resultSet.getString("msisdn"));
					moObj.setMoContent(resultSet.getString("moContetn"));
					moObj.setMtContent(resultSet.getString("mtContent"));
					moObj.setStatus(resultSet.getString("status"));
					
				} 
				resultSet.close();
				preparedStatement.closeOnCompletion();
			} catch (SQLException e) {
				log.error("Error when find MO obj for update MOId: " + moId, e);
				Server.hipChatClient.SendHipChatMessage("Error when find MO obj for update MOId: " + moId+" "+ e);
			}
		return moObj;
		 
	 }
	 
	 // find client by clientID
	 public Client findClientByClientId(Connection conn, String clientId){
		 Client client = null;
		 String query = "select CLIENTID as clientID,"
	        		+ " CLIENT_PASSWORD as clientPass,"
	        		+ " AZGATE_MO_URL as azGreatMoUrl,"
	        		+ " COMMAND_CODE as commandCode"
	        		+ " from CLIENT cl where cl.CLIENTID =?";
		 PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, clientId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				client = new Client();
				client.setClientID(resultSet.getString("clientID"));
				client.setClientPass(resultSet.getString("clientPass"));
				client.setAZGateMOURL(resultSet.getString("azGreatMoUrl"));
				client.setCommandCode(resultSet.getString("commandCode"));
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			log.error("Error find client by id: "+ clientId, e);
			Server.hipChatClient.SendHipChatMessage("Error find client by id: " + clientId+" "+ e);
		}
			
		return client;
		 
	 }

  // update Mo after receiver MT
  public boolean updateMTObj (Connection conn, MTReceiver mtReceiver, String status, String content) throws SQLException{
	  String query  = "";
	  if(Constant.STATUS_PROCESS.equals(status)){
		  query  = "UPDATE TRANSACTIONS_SC"
          		+ " SET"
          		+ " MT_CONTENT = ?,"
          		+ " STATUS = ?"
          		+ " WHERE MO_ID = ?"
          		+ " AND CLIENTID = ?"
          		+ " AND STATUS = 'WMT'";
	  }
	  if(Constant.STATUS_SUCCESS.equals(status)){
		  query  = "UPDATE TRANSACTIONS_SC"
	          		+ " SET"
	          		+ " MT_CONTENT = ?,"
	          		+ " STATUS = ?"
	          		+ " WHERE MO_ID = ?"
	          		+ " AND CLIENTID = ?"
	          		+ " AND STATUS = 'P'";
	  }
	  if(Constant.STATUS_ERROR.equals(status)){
		  query  = "UPDATE TRANSACTIONS_SC"
	          		+ " SET"
	          		+ " MT_CONTENT = ?,"
	          		+ " STATUS = ?"
	          		+ " WHERE MO_ID = ?"
	          		+ " AND CLIENTID = ?"
	          		+ " AND STATUS = 'P'";
	  }
	  PreparedStatement preparedStatement;
	  try {
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, content);
			preparedStatement.setString(2, status);
			preparedStatement.setString(3, mtReceiver.getMOId());
			preparedStatement.setString(4, mtReceiver.getClientId());
			preparedStatement.executeUpdate();
			preparedStatement.closeOnCompletion();
			return true;
//			preparedStatement.close();
		} catch (SQLException e) {
			log.error("Error when update MT obj: "
					+ mtReceiver.getClientId()
					+ " Status: " + mtReceiver.getStatus()
					, e);
		Server.hipChatClient.SendHipChatMessage("Error when update MT obj: "
				+ mtReceiver.getClientId()
				+ " Status: " + mtReceiver.getStatus()+" "+ e);
			throw e;
		}
  }
  
  public ArrayList<OAMDetail> findTransDetail(Connection conn, OAMDetailReceiver detailReceiver){
	  ArrayList<OAMDetail> listDetail = new ArrayList<>();
	  String query = "select MO_ID as moId,"
      		+ " PARTNERID as partnerId,"
      		+ " CLIENTID as clientId,"
      		+ " TELCO as telco,"
      		+ " CREATETIME as createTime,"
      		+ " UPDATETIME as updateTime,"
      		+ " SC as sc,"
      		+ " MSISDN as msisdn,"
      		+ " MO_CONTENT as moContent,"
      		+ " MT_CONTENT as mtContent,"
      		+ " STATUS as status"
      		+ " from TRANSACTIONS_SC_LOG transLog"
      		+ " where transLog.CREATETIME BETWEEN TO_DATE(?,'yyyy-MM-dd') AND TO_DATE(?,'yyyy-MM-dd')";
		if (detailReceiver.getClientId() != null && detailReceiver.getClientId() != Constant.STR_EMTY) {
			query = query + " AND transLog.CLIENTID = " + "'" + detailReceiver.getClientId() + "'";
		}
		if (detailReceiver.getPartnerId() != null && detailReceiver.getPartnerId() != Constant.STR_EMTY) {
			query = query + " AND transLog.PARTNERID = " + "'" + detailReceiver.getPartnerId() + "'";
		}
		if (detailReceiver.getTelco() != null && detailReceiver.getTelco() != Constant.STR_EMTY) {
			query = query + " AND transLog.TELCO = " + "'" + detailReceiver.getTelco() + "'";
		}
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			java.sql.Date dateFrom = new java.sql.Date(detailReceiver.getFrom().getTime());
			java.sql.Date dateTo = new java.sql.Date(detailReceiver.getTo().getTime());
			preparedStatement.setString(1, dateFrom.toString());
			preparedStatement.setString(2, dateTo.toString());
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				OAMDetail oamObj = new OAMDetail();
				oamObj.setClientId(resultSet.getString("clientId"));
				oamObj.setPartnerId(resultSet.getString("partnerId"));
				oamObj.setMoId(resultSet.getString("moId"));
				oamObj.setTelco(resultSet.getString("telco"));
				oamObj.setCreateTime(resultSet.getString("createTime"));
				oamObj.setUpdateTime(resultSet.getString("updateTime"));
				oamObj.setSc(resultSet.getString("sc"));
				oamObj.setMsisdn(resultSet.getString("msisdn"));
				oamObj.setMoContent(resultSet.getString("moContent"));
				oamObj.setMtContent(resultSet.getString("mtContent"));
				oamObj.setStatus(resultSet.getString("status"));
				listDetail.add(oamObj);
			}
			resultSet.close();
			preparedStatement.closeOnCompletion();
		} catch (SQLException e) {
			log.error("Error when find Transaction detail: ", e);
			Server.hipChatClient.SendHipChatMessage("Error when find Transaction detail: "+ e);
			return listDetail;
		}
	return listDetail;
  }
  
  public ArrayList<OAMGroupByStatus> findTransGroup(Connection conn, OAMGroupReceiver groupReceiver){
	  ArrayList<OAMGroupByStatus> listGroup = new ArrayList<>();
	  String query = "select CLIENT_ID as clientId,"
	      		+ " TELCO as telco,"
	      		+ " PARTNER_ID as partnerId,"
	      		+ " DAY as day,"
	      		+ " TRANS_STATUS as transStatus,"
	      		+ " VALUE as value"
	      		+ " from TBL_AZGATE_GROUP_BY_STATUS transGroup"
	      		+ " where transGroup.DAY BETWEEN TO_DATE(?,'yyyy-MM-dd') AND TO_DATE(?,'yyyy-MM-dd')";
			if (groupReceiver.getClientId() != null && groupReceiver.getClientId() != Constant.STR_EMTY) {
				query = query + " AND transGroup.CLIENTID = " + "'" +  groupReceiver.getClientId() + "'";
			}
			if (groupReceiver.getPartnerId() != null && groupReceiver.getPartnerId() != Constant.STR_EMTY) {
				query = query + " AND transGroup.PARTNERID = " + "'" + groupReceiver.getPartnerId() + "'";
			}
			if (groupReceiver.getTelco() != null && groupReceiver.getTelco() != Constant.STR_EMTY) {
				query = query + " AND transGroup.TELCO = " + "'" + groupReceiver.getTelco() + "'";
			}
			if (groupReceiver.getStatus() != null && groupReceiver.getStatus() != Constant.STR_EMTY) {
				query = query + " AND transGroup.TRANS_STATUS = "  + "'" + groupReceiver.getStatus() + "'";
			}
			try {
				PreparedStatement preparedStatement = conn.prepareStatement(query);
				java.sql.Date dateFrom = new java.sql.Date(groupReceiver.getFrom().getTime());
				java.sql.Date dateTo = new java.sql.Date(groupReceiver.getTo().getTime());
				preparedStatement.setString(1, dateFrom.toString());
				preparedStatement.setString(2, dateTo.toString());
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()){
					OAMGroupByStatus oamObj = new OAMGroupByStatus();
					oamObj.setClientId(resultSet.getString("clientId"));
					oamObj.setPartnerId(resultSet.getString("partnerId"));
					oamObj.setTelco(resultSet.getString("telco"));
					oamObj.setDay(resultSet.getString("day"));
					oamObj.setTransStatus(resultSet.getString("transStatus"));
					listGroup.add(oamObj);
				} 
				resultSet.close();
				preparedStatement.closeOnCompletion();
			} catch (SQLException e) {
				log.error("Error when find Transaction Group: ", e);
				Server.hipChatClient.SendHipChatMessage("Error when find Transaction Group: "+ e);
				return listGroup;
			}
	return listGroup;
	  
  }
  
 }
