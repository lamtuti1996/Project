package com.azplay.azpotal.azgate.sc.model;

public class MTResponse {
	private String moId;
	private String sc;
	private String msisdn;
	private String content;
	private String mtType;
	private String clientId;

	public MTResponse(String moId, String sc, String msisdn, String content, String mtType, String clientId) {
		super();
		this.moId = moId;
		this.sc = sc;
		this.msisdn = msisdn;
		this.content = content;
		this.mtType = mtType;
		this.clientId = clientId;
	}

	/**
	 * @return the moId
	 */
	public String getMoId() {
		return moId;
	}

	/**
	 * @param moId
	 *            the moId to set
	 */
	public void setMoId(String moId) {
		this.moId = moId;
	}

	/**
	 * @return the sc
	 */
	public String getSc() {
		return sc;
	}

	/**
	 * @param sc
	 *            the sc to set
	 */
	public void setSc(String sc) {
		this.sc = sc;
	}

	/**
	 * @return the msisdn
	 */
	public String getMsisdn() {
		return msisdn;
	}

	/**
	 * @param msisdn
	 *            the msisdn to set
	 */
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the mtType
	 */
	public String getMtType() {
		return mtType;
	}

	/**
	 * @param mtType
	 *            the mtType to set
	 */
	public void setMtType(String mtType) {
		this.mtType = mtType;
	}

	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * @param clientId
	 *            the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

}
