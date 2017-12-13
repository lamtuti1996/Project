package com.azportal.service.warning.httpcontroller.impl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.azportal.service.warning.common.HipChatClient;
import com.azportal.service.warning.common.SendInfo;
import com.azportal.service.warning.common.Utils;

public class APIPingToService extends Thread {
	private static Logger logger = Logger.getLogger(APIPingToService.class);
	private String ipAddress;
	private long threadId = this.getId();
	private int count = 0;
	private String timeRequest = "";
	private boolean ping;
	private static boolean stop = true;

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public APIPingToService() {
		super();

	}

	public APIPingToService(String ipAddress) {
		super();
		this.ipAddress = ipAddress;
	}

	@Override
	public void run() {

		while (stop == false) {

			if (count <= Utils.getServerProperties().getRetryTime()) {
				pingToServer(ipAddress);
			} else {
				count = 0;
				SendInfo.sendErr(timeRequest, threadId, Utils.getServerProperties().getGmailAddress(),
						Utils.getServerProperties().getGmailPassword(), ipAddress, "ping");
				SendInfo.insertDB(timeRequest, -1, ipAddress, "Ping to address is Failed", "E");

				try {
					Thread.sleep(Utils.getServerProperties().getTimeCheck() * 60 * 1000);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}
			}
		}
	}

	public void pingToServer(String ipAddress) {
		try {
			// create inet ping to ipAddress
			InetAddress inet = InetAddress.getByName(ipAddress);

			// time request ping to ipAddress
			timeRequest = Utils.getCurrentTime();

			// ping to ipAddress
			ping = inet.isReachable(Utils.getServerProperties().getPingTimeout() * 1000);
			// time response ping to ipAddress
			String timeResponse = Utils.getCurrentTime();

			if (ping) {
				long timeDiff = Utils.caculateTimeDiff(timeRequest, timeResponse);
				count = 0;
				logger.info("TimeRequest: " + timeRequest + " Ping to address: " + ipAddress + " is: " + ping
						+ " on the time: " + timeDiff + " (milliseconds)");
				SendInfo.insertDB(timeRequest, timeDiff, ipAddress, "Ping to address is succsessfully", "S");
				Thread.sleep(Utils.getServerProperties().getTimeCheck() * 60 * 1000);
			} else {
				logger.info("TimeRequest: " + timeRequest + " Ping to address: " + ipAddress + " is: " + ping);
				count++;
				Thread.sleep(1000);
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
