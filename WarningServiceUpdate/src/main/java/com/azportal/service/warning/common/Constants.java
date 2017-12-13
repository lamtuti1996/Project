package com.azportal.service.warning.common;

public interface Constants {
	public interface DateFormat {
		static final String NETWORK_FORMAT = "ddMMyyyyHHmmss";
		static final String DDMMYYYY_HHMMSS = "dd/MM/yyyy hh:MM:ss";
		static final String DDMMYYYY_HHMMSS_ = "yyyy-MM-dd hh:MM:ss";
		static String DDMMYYY_HHMMSS = "dd/MM/yyyy hh:MM:ss";
		static String DDMMYYY_HHmmSS = "dd/MM/yyyy hh:mm:ss";
		static String DDMMYYY = "dd/MM/yyyy";
		static String TIME_HHMMSS = "hh:mm:ss";
	}

	public interface Properties {
		public static final String APP_PROP_FILE = "app.properties";
		public static final String DEPLOY_MODE = "deployMode";
		public static final String SERVER_NAME = "serverName";

	}

	public interface Message {
		public static final int CHECK_SUCCESS = 1;
		public static final int CHECK_FAIL = -1;
		public static final String ERR_CODE_STOP = "-3";
		public static final String ERR_MESS_STOP = "Program is not running";
		public static final String ERR_CODE_START = "-2";
		public static final String ERR_MESS_START = "Program is  running";
		public static final String SUCCESS_CODE_START = "2";
		public static final String SUCCESS_MESS_START = "Start program is successfully";
		public static final String SUCCESS_CODE_STOP = "3";
		public static final String SUCCESS_MESS_STOP = "Stop program is successfully";
	}

}
