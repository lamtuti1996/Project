package com.azplay.azpotal.azgate.sc.model;

import java.sql.Timestamp;

public class MOReceiver {
	private String moId;
	private String partnerId;
	private String commandCode;
	private String telco;
	private Timestamp timeStamp;
	private String sc;
	private String msisdn;
	private String moContent;
	private String status;

	public MOReceiver() {
		super();
	}

	public MOReceiver(String moId, String partnerId, String commandCode, String telco, Timestamp timeStamp, String sc,
			String msisdn, String moContent, String status) {
		super();
		this.moId = moId;
		this.partnerId = partnerId;
		this.commandCode = commandCode;
		this.telco = telco;
		this.timeStamp = timeStamp;
		this.sc = sc;
		this.msisdn = msisdn;
		this.moContent = moContent;
		this.status = status;
	}

	public String getMOId() {
		return moId;
	}

	public void setMOId(String moId) {
		this.moId = moId;
	}

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public String getCommandCode() {
		return commandCode;
	}

	public void setCommandCode(String commandCode) {
		this.commandCode = commandCode;
	}

	public String getTelco() {
		return telco;
	}

	public void setTelco(String telco) {
		this.telco = telco;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
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

	public String getMoContent() {
		return moContent;
	}

	public void setMoContent(String moContent) {
		this.moContent = moContent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
