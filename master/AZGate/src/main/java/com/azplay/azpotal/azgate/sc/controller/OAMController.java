package com.azplay.azpotal.azgate.sc.controller;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.azplay.azpotal.azgate.sc.app.Server;
import com.azplay.azpotal.azgate.sc.common.Common;
import com.azplay.azpotal.azgate.sc.common.Constant;
import com.azplay.azpotal.azgate.sc.dao.DataDao;
import com.azplay.azpotal.azgate.sc.db.DatabaseConnector;
import com.azplay.azpotal.azgate.sc.entity.Error;
import com.azplay.azpotal.azgate.sc.entity.OAMDetail;
import com.azplay.azpotal.azgate.sc.entity.OAMGroupByStatus;
import com.azplay.azpotal.azgate.sc.model.OAMDetailReceiver;
import com.azplay.azpotal.azgate.sc.model.OAMGroupReceiver;
import com.azplay.azpotal.azgate.sc.util.JsonTransformer;

import spark.Request;
import spark.Response;
import spark.Route;

public class OAMController {
	DatabaseConnector dc;

	public OAMController(DatabaseConnector dc) {
		this.dc = dc;
	}

	public Route handleRequestDetail = (Request request, Response response) -> {
		// check value
		if (validateOAM(request)) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date datefrom = dateFormat.parse(request.queryParams("from"));
			Date dateTo = dateFormat.parse(request.queryParams("to"));
			OAMDetailReceiver detailReceiver = new OAMDetailReceiver(request.queryParams("clientId"),
					request.queryParams("partnerId"), request.queryParams("telco"), datefrom, dateTo,
					request.queryParams("timestamp"), request.queryParams("username"), request.queryParams("passToken"),
					request.queryParams("rand"));

			// check passToken
			String key = detailReceiver.getTimestamp() + "|" + detailReceiver.getRand() + "|"
					+ Server.serverConfig.getOamUsername() + "|" + Server.serverConfig.getOamPass();
			String passToken = Common.SHA256(key);
			if (passToken.equals(detailReceiver.getPassToken())) {
				// select data
				DataDao dataDao = new DataDao();
				Connection connection = dc.getPooledConnection();
				ArrayList<OAMDetail> listDetail = dataDao.findTransDetail(connection, detailReceiver);
				// convert to json
				return listDetail;
			} else {
				// return error sai username password
				return responseErr(Constant.ERR_CODE_102, Constant.ERR_MESS_102);
			}
		} else {
			// return error thieu value
			return responseErr(Constant.ERR_CODE_101, Constant.ERR_MESS_101);
		}
	};

	public Route handleRequestGroup = (Request request, Response response) -> {
		if (validateOAM(request)) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyy-mm-dd");
			Date datefrom = dateFormat.parse(request.queryParams("from"));
			Date dateTo = dateFormat.parse(request.queryParams("to"));
			OAMGroupReceiver groupReceiver = new OAMGroupReceiver(request.queryParams("clientId"),
					request.queryParams("partnerId"), datefrom, dateTo, request.queryParams("telco"),
					request.queryParams("status"), request.queryParams("timestamp"), request.queryParams("username"),
					request.queryParams("passToken"), request.queryParams("rand"));

			// check passToken
			String key = groupReceiver.getTimestamp() + "|" + groupReceiver.getRand() + "|"
					+ groupReceiver.getUsername() + "|" + Server.serverConfig.getOamPass();
			String passToken = Common.SHA256(key);
			if (passToken.equals(groupReceiver.getPassToken())) {
				// select data
				DataDao dataDao = new DataDao();
				Connection connection = dc.getPooledConnection();
				ArrayList<OAMGroupByStatus> listGroup = dataDao.findTransGroup(connection, groupReceiver);
				// convert to json
				return listGroup;
			} else {
				// return error sai username password
				return responseErr(Constant.ERR_CODE_102, Constant.ERR_MESS_102);
			}
		} else {
			// return error thieu value
			return responseErr(Constant.ERR_CODE_101, Constant.ERR_MESS_101);
		}

	};

	private boolean validateOAM(Request request) {
		if (request.queryParams("timestamp") == null || request.queryParams("timestamp") == Constant.STR_EMTY
				|| request.queryParams("username") == null || request.queryParams("username") == Constant.STR_EMTY
				|| request.queryParams("passToken") == null || request.queryParams("passToken") == Constant.STR_EMTY
				|| request.queryParams("rand") == null || request.queryParams("rand") == Constant.STR_EMTY) {
			return false;
		}
		return true;
	}

	private String responseErr(String errMes, String errCode) {
		Error error = new Error();
		if (Constant.STR_EMTY.equals(errMes) || Constant.STR_EMTY.equals(errCode) || errMes == null
				|| errCode == null) {
			error = null;
		} else {
			error.setCode(errCode);
			error.setMessage(errMes);
		}
		return new JsonTransformer().render(error);
	}
}
