package com.azportal.service.warning.common;

public class ServerProperties {
	private String listPing;
	private int pingTimeout;
	private String listService;
	private int serviceTimeout;
	private String hipchatRoom;
	private String hipchatToken;
	private String gmailAddress;
	private String gmailPassword;
	private int timeCheck;
	private int retryTime;
	private String url;
	private int port;

	public ServerProperties() {
		setListPing(Utils.getProperties("list_ping_server"));
		setPingTimeout(Integer.parseInt(Utils.getProperties("ping_timeout")));
		setListService(Utils.getProperties("list_service"));
		setServiceTimeout(Integer.parseInt(Utils.getProperties("service_timeout")));
		setHipchatRoom(Utils.getProperties("hipchat_room"));
		setHipchatToken(Utils.getProperties("hipchat_token"));
		setGmailAddress(Utils.getProperties("gmail_address"));
		setGmailPassword(Utils.getProperties("gmail_password"));
		setTimeCheck(Integer.parseInt(Utils.getProperties("time_for_check")));
		setRetryTime(Integer.parseInt(Utils.getProperties("retry_times")));
		setUrl(Utils.getProperties("url"));
		setPort(Integer.parseInt(Utils.getProperties("port")));
	}

	public String getListPing() {
		return listPing;
	}

	public void setListPing(String listPing) {
		this.listPing = listPing;
	}

	public int getPingTimeout() {
		return pingTimeout;
	}

	public void setPingTimeout(int pingTimeout) {
		this.pingTimeout = pingTimeout;
	}

	public String getListService() {
		return listService;
	}

	public void setListService(String listService) {
		this.listService = listService;
	}

	public int getServiceTimeout() {
		return serviceTimeout;
	}

	public void setServiceTimeout(int serviceTimeout) {
		this.serviceTimeout = serviceTimeout;
	}

	public String getHipchatRoom() {
		return hipchatRoom;
	}

	public void setHipchatRoom(String hipchatRoom) {
		this.hipchatRoom = hipchatRoom;
	}

	public String getHipchatToken() {
		return hipchatToken;
	}

	public void setHipchatToken(String hipchatToken) {
		this.hipchatToken = hipchatToken;
	}

	public String getGmailAddress() {
		return gmailAddress;
	}

	public void setGmailAddress(String gmailAddress) {
		this.gmailAddress = gmailAddress;
	}

	public String getGmailPassword() {
		return gmailPassword;
	}

	public void setGmailPassword(String gmailPassword) {
		this.gmailPassword = gmailPassword;
	}

	public int getTimeCheck() {
		return timeCheck;
	}

	public void setTimeCheck(int timeCheck) {
		this.timeCheck = timeCheck;
	}

	public int getRetryTime() {
		return retryTime;
	}

	public void setRetryTime(int retryTime) {
		this.retryTime = retryTime;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
