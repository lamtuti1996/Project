package com.azportal.service.warning.httpcontroller.impl;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import com.azportal.service.warning.common.SendInfo;
import com.azportal.service.warning.common.Utils;

public class APICallToService extends Thread {
	private static Logger logger = Logger.getLogger(APICallToService.class);
	private long threadId = this.getId();
	private int count = 0;
	private String timeRequest = "";
	private String url = "";
	private static boolean stop = true;

	public APICallToService() {
		super();

	}

	public APICallToService(String url) {
		super();
		this.url = url;
	}

	public static boolean isStop() {
		return stop;
	}

	public static void setStop(boolean stop) {
		APICallToService.stop = stop;
	}

	@Override
	public void run() {

		while (stop == false) {

			if (count <= Utils.getServerProperties().getRetryTime()) {

				requestAPI(url);
			} else {
				count = 0;
				// send error to hipchat and email when requested more than retryTime
				SendInfo.sendErr(timeRequest, threadId, Utils.getServerProperties().getGmailAddress(),
						Utils.getServerProperties().getGmailPassword(), url, "request");
				SendInfo.insertDB(timeRequest, -1, url, "Request to address is Failed", "E");

				try {
					Thread.sleep(Utils.getServerProperties().getTimeCheck() * 60 * 1000);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private void requestAPI(String url) {

		int status = 0;

		RequestConfig requestConfig = RequestConfig.custom()
				.setConnectTimeout(Utils.getServerProperties().getServiceTimeout() * 1000).build();
		HttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();
		HttpGet get = new HttpGet(url);

		try {

			// time request to API
			timeRequest = Utils.getCurrentTime();

			logger.info("Thread " + threadId + " Request  to address: " + url + " in timeRequest: " + timeRequest);
			// Request to API
			HttpResponse response = httpClient.execute(get);

			// Response from API
			status = response.getStatusLine().getStatusCode();
			// time response from API
			String timeResponse = Utils.getCurrentTime();

			logger.info("Thread " + threadId + " Request  to address: " + url + " in timeRespones: " + timeResponse
					+ "- status:" + status);

			// respone success return status :200
			if (status == 200) {
				long timeDiff = Utils.caculateTimeDiff(timeRequest, timeResponse);
				count = 0;
				logger.info("TimeRequest: " + timeRequest + " Request  to address: " + url + " is: " + status
						+ " on the time: " + timeDiff + " (milliseconds)");
				SendInfo.insertDB(timeRequest, timeDiff, url, "Request to address is succsessfully", "S");
				try {
					Thread.sleep(Utils.getServerProperties().getTimeCheck() * 60 * 1000);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}

				// respone timeout return status :408
			} else if (status == 408) {
				count++;
				logger.info("TimeRequest: " + timeRequest + " Request  to address: " + url + " is: " + status);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {

					ex.printStackTrace();
				}
			}

		} catch (ClientProtocolException e) {
			count++;
			logger.info("TimeRequest: " + timeRequest + " Request  to address: " + url + " is error: "
					+ e.getLocalizedMessage());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {

				ex.printStackTrace();
			}
		} catch (IOException e) {
			count++;
			logger.info("TimeRequest: " + timeRequest + " Request  to address: " + url + " is error: "
					+ e.getLocalizedMessage());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

}
