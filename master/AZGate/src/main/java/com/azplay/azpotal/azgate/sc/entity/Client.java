package com.azplay.azpotal.azgate.sc.entity;

public class Client {
	private String clientID;

	private String commandCode;
	
	private String AZGateMOURL;
	
	private String clientPass;

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

	public String getAZGateMOURL() {
		return AZGateMOURL;
	}

	public void setAZGateMOURL(String AZGateMOURL) {
		this.AZGateMOURL = AZGateMOURL;
	}

	public String getClientPass() {
		return clientPass;
	}

	public void setClientPass(String clientPass) {
		this.clientPass = clientPass;
	}

}
