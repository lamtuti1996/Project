package com.azplay.azpotal.azgate.sc.model;

public class MTReceiver {
	private String moId;
	private String sc;
	private String msisdn;
	private String content;
	private String mtType;
	private String timeStamp;
	private String rand;
	private String clientId;
	private String passToken;
	private String status;
	
	public MTReceiver() {
		super();
	}

	public MTReceiver(String moId, String sc, String msisdn, String content, String mtType, String timeStamp,
			String rand, String clientId, String passToken, String status) {
		super();
		this.moId = moId;
		this.sc = sc;
		this.msisdn = msisdn;
		this.content = content;
		this.mtType = mtType;
		this.timeStamp = timeStamp;
		this.rand = rand;
		this.clientId = clientId;
		this.passToken = passToken;
		this.status = status;
	}

	public String getMOId() {
		return moId;
	}

	public void setMOId(String moId) {
		this.moId = moId;
	}

	public String getSc() {
		return sc;
	}

	public void setSc(String sc) {
		this.sc = sc;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMtType() {
		return mtType;
	}

	public void setMtType(String mtType) {
		this.mtType = mtType;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getRand() {
		return rand;
	}

	public void setRand(String rand) {
		this.rand = rand;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getPassToken() {
		return passToken;
	}

	public void setPassToken(String passToken) {
		this.passToken = passToken;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
