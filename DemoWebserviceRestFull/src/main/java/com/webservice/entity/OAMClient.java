package com.webservice.entity;

public class OAMClient {
	private String name;
	private String clientPassword;
	private String clientID;
	private String commandCode;
	private String azgateUrl;

	public OAMClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OAMClient(String name, String clientPassword, String clientID, String commandCode, String azgateUrl) {
		super();
		this.name = name;
		this.clientPassword = clientPassword;
		this.clientID = clientID;
		this.commandCode = commandCode;
		this.azgateUrl = azgateUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClientPassword() {
		return clientPassword;
	}

	public void setClientPassword(String clientPassword) {
		this.clientPassword = clientPassword;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getCommandCode() {
		return commandCode;
	}

	public void setCommandCode(String commandCode) {
		this.commandCode = commandCode;
	}

	public String getAzgateUrl() {
		return azgateUrl;
	}

	public void setAzgateUrl(String azgateUrl) {
		this.azgateUrl = azgateUrl;
	}

}
