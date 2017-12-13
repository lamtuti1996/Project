package com.azportal.service.warning.httpcontroller.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.azportal.service.warning.common.Constants;
import com.azportal.service.warning.common.Utils;
import com.azportal.service.warning.entity.ResponeObj;
import com.azportal.service.warning.http.HTTPService;
import com.azportal.service.warning.httpcontroller.HTTPController;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class HTTPControllerImpl implements HTTPController {
	private static Logger logger = Logger.getLogger(HTTPControllerImpl.class);
	private APICallServicesControlerImpl apiCallServiceImpl = new APICallServicesControlerImpl();
	private APIPingServicesControllerImpl apiPingServiceImpl = new APIPingServicesControllerImpl();
	private HTTPService httpService;

	@Path("start/callservice")
	@GET
	public Response startAPICallServices() {
		logger.info("-----Start  API Call Services-------");
		String result = "";
		ResponeObj responeObj = new ResponeObj();
		int check = apiCallServiceImpl.checkStart();
		if (check == Constants.Message.CHECK_FAIL) {

			responeObj.setCode(Constants.Message.ERR_CODE_START);
			responeObj.setMessage(Constants.Message.ERR_MESS_START);
			result = Utils.render(responeObj);
			return Response.ok().entity(result).build();
		} else {
			responeObj.setCode(Constants.Message.SUCCESS_CODE_START);
			responeObj.setMessage(Constants.Message.SUCCESS_MESS_START);
			result = Utils.render(responeObj);
			apiCallServiceImpl.start();
			return Response.ok().entity(result).build();
		}

	}

	@Path("start/pingservice")
	@GET
	public Response startAPIPingServices() {
		logger.info("-----Start  API Ping Services-------");
		String result = "";
		ResponeObj responeObj = new ResponeObj();
		int check = apiPingServiceImpl.checkStart();
		if (check == Constants.Message.CHECK_FAIL) {

			responeObj.setCode(Constants.Message.ERR_CODE_START);
			responeObj.setMessage(Constants.Message.ERR_MESS_START);
			result = Utils.render(responeObj);
			return Response.ok().entity(result).build();
		} else {
			responeObj.setCode(Constants.Message.SUCCESS_CODE_START);
			responeObj.setMessage(Constants.Message.SUCCESS_MESS_START);
			result = Utils.render(responeObj);
			apiPingServiceImpl.start();
			return Response.ok().entity(result).build();
		}
	}

	@Path("stop/callservice")
	@GET
	public Response stopAPICallServices() {
		logger.info("-----Stop API Call Services-------");
		String result = "";
		ResponeObj responeObj = new ResponeObj();
		int check = apiCallServiceImpl.stopThread();

		if (check == Constants.Message.CHECK_FAIL) {
			responeObj.setCode(Constants.Message.ERR_CODE_STOP);
			responeObj.setMessage(Constants.Message.ERR_MESS_STOP);
			result = Utils.render(responeObj);
			return Response.ok().entity(result).build();
		} else {
			responeObj.setCode(Constants.Message.SUCCESS_CODE_STOP);
			responeObj.setMessage(Constants.Message.SUCCESS_MESS_STOP);
			result = Utils.render(responeObj);
			return Response.ok().entity(result).build();
		}

	}

	@Path("stop/pingservice")
	@GET
	public Response stoptAPIPingServices() {
		logger.info("-----Stop API Ping Services-------");
		String result = "";
		ResponeObj responeObj = new ResponeObj();
		int check = apiPingServiceImpl.stopThread();

		if (check == Constants.Message.CHECK_FAIL) {
			responeObj.setCode(Constants.Message.ERR_CODE_STOP);
			responeObj.setMessage(Constants.Message.ERR_MESS_STOP);
			result = Utils.render(responeObj);
			return Response.ok().entity(result).build();
		} else {
			responeObj.setCode(Constants.Message.SUCCESS_CODE_STOP);
			responeObj.setMessage(Constants.Message.SUCCESS_MESS_STOP);
			result = Utils.render(responeObj);
			return Response.ok().entity(result).build();
		}

	}

}
