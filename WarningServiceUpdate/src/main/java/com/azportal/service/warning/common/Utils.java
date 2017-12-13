package com.azportal.service.warning.common;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;


import com.azportal.service.warning.business.DBManager;
import com.azportal.service.warning.server.impl.PlatformImpl;
import com.google.gson.Gson;

public class Utils {

	public static String get4NetworkDate(Date date) {
		SimpleDateFormat f = new SimpleDateFormat(Constants.DateFormat.NETWORK_FORMAT);
		String timeStr = f.format(date);
		return timeStr;
	}

	// public static String getGameParam(String param) {
	// return PlatformImpl.getPlatform().gameInfo.getGameParams().get(param);
	// }

	public static String getCurrentTime() {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss,SSS");
		String timeNow = format.format(Calendar.getInstance().getTime());

		return timeNow;
	}

	public static long caculateTimeDiff(String timeRequest, String timeResponse) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss,SSS");
		Date d1 = null;
		Date d2 = null;
		try {
			d1 = dateFormat.parse(timeRequest);
			d2 = dateFormat.parse(timeResponse);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		long timeDiff = TimeUnit.MILLISECONDS.toMillis(d2.getTime() - d1.getTime());

		return timeDiff;
	}

	public static Timestamp convertDate(String time) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss,SSS");
		Date d = null;
		Timestamp timestamp = null;
		try {
			d = dateFormat.parse(time);
			timestamp = new java.sql.Timestamp(d.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return timestamp;
	}

	public static Date getCurrentDate() {
		return new Date();
	}

	public static String getProperties(String key) {
		return PlatformImpl.getPlatform().getPropertiesReader().getValue(key);
	}

	public static DBManager getDBManager() {
		return PlatformImpl.getPlatform().getDBManager();
	}

	public static ServerProperties getServerProperties() {
		return PlatformImpl.getPlatform().getServerProp();
	}

	public static String render(Object model) {
		Gson gson = new Gson();
		return gson.toJson(model);
	}
}
