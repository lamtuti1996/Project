package com.azportal.service.warning.httpcontroller.impl;

import com.azportal.service.warning.common.Constants;
import com.azportal.service.warning.common.Utils;

public class APICallServicesControlerImpl extends Thread {

	@Override
	public void run() {

		callToService();

	}

	public int stopThread() {
		APICallToService apiCallToService = new APICallToService();
		if (apiCallToService.isStop() == false) {
			apiCallToService.setStop(true);
			return Constants.Message.CHECK_SUCCESS;
		} else {
			return Constants.Message.CHECK_FAIL;
		}
	}

	public int checkStart() {
		APICallToService apiCallToService = new APICallToService();
		if (apiCallToService.isStop() == true) {
			apiCallToService.setStop(false);
			return Constants.Message.CHECK_SUCCESS;
		} else {
			return Constants.Message.CHECK_FAIL;
		}

	}

	public void callToService() {
		String api = Utils.getServerProperties().getListService();
		String[] listAPI = api.split("\\|");

		for (int i = 0; i < listAPI.length; i++) {
			APICallToService apiCallToService = new APICallToService(listAPI[i]);

			apiCallToService.start();

		}

	}

}
