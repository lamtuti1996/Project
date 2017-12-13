package com.azplay.azpotal.azgate.sc.model;

import java.util.Date;

/**
 * Represents an User for this web application.
 */
public class DataObject {

	// ------------------------
	// PRIVATE FIELDS
	// ------------------------

	private String moId;

	private String partnerID;

	private String clientID;

	private String telco;

	private String sc;

	private String msisdn;
	
	private Date updateTime;
	
	private Date createTime;
	
	private String moContent;
	
	private String status;
	
	private String mtContent;

	public DataObject() {
	}

	public DataObject(String moId) {
		this.moId = moId;
	}

	public DataObject(String moId, String partnerID, String clientID, String telco, String sc, String msisdn,
			Date updateTime, Date createTime, String moContent, String status, String mtContent) {
		super();
		this.moId = moId;
		this.partnerID = partnerID;
		this.clientID = clientID;
		this.telco = telco;
		this.sc = sc;
		this.msisdn = msisdn;
		this.updateTime = updateTime;
		this.createTime = createTime;
		this.moContent = moContent;
		this.status = status;
		this.mtContent = mtContent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTelco() {
		return telco;
	}

	public void setTelco(String telco) {
		this.telco = telco;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public String getMOId() {
		return moId;
	}

	public void setMOId(String moId) {
		this.moId = moId;
	}

	public String getPartnerID() {
		return partnerID;
	}

	public void setPartnerID(String partnerID) {
		this.partnerID = partnerID;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
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

	public String getMtContent() {
		return mtContent;
	}

	public void setMtContent(String mtContent) {
		this.mtContent = mtContent;
	}
}
