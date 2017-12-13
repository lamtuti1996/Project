package com.azportal.service.warning.httpcontroller.impl;

import com.azportal.service.warning.common.Constants;
import com.azportal.service.warning.common.Utils;

public class APIPingServicesControllerImpl extends Thread {

	@Override
	public void run() {

		pingToServer();

	}

	public int stopThread() {
		APIPingToService apiPingToService = new APIPingToService();
		if (apiPingToService.isStop() == false) {
			apiPingToService.setStop(true);
			return Constants.Message.CHECK_SUCCESS;
		} else {
			return Constants.Message.CHECK_FAIL;
		}
	}

	public int checkStart() {
		APIPingToService apiPingToService = new APIPingToService();
		if (apiPingToService.isStop() == true) {
			apiPingToService.setStop(false);
			return Constants.Message.CHECK_SUCCESS;
		} else {
			return Constants.Message.CHECK_FAIL;
		}
	}

	public void pingToServer() {
		String server = Utils.getServerProperties().getListPing();
		String[] listIP = server.split("\\|");
		for (int i = 0; i < listIP.length; i++) {

			APIPingToService apiPingToService = new APIPingToService(listIP[i]);

			apiPingToService.start();

		}

	}

}
