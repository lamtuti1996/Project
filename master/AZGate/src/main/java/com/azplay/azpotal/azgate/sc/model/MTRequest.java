package com.azplay.azpotal.azgate.sc.model;

public class MTRequest {
	private String moId;
	private String serviceId;
	private String sender;
	private String receiver;
	private String message;
	private String requestTime;
	private String operator;
	private String commandCode;
	private String contentType;
	private String messageType;
	private String messageIndex;
	private String userName;
	private String key;

	public MTRequest() {
		super();
	}

	public MTRequest(String moId, String serviceId, String sender, String receiver, String message, String requestTime,
			String operator, String commandCode, String contentType,String messageType, String messageIndex, String userName, String key) {
		super();
		this.moId = moId;
		this.serviceId = serviceId;
		this.sender = sender;
		this.receiver = receiver;
		this.message = message;
		this.requestTime = requestTime;
		this.operator = operator;
		this.commandCode = commandCode;
		this.contentType = contentType;
		this.messageType = messageType;
		this.messageIndex = messageIndex;
		this.userName = userName;
		this.key = key;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getMOId() {
		return moId;
	}

	public void setMOId(String moId) {
		this.moId = moId;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getCommandCode() {
		return commandCode;
	}

	public void setCommandCode(String commandCode) {
		this.commandCode = commandCode;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getMessageIndex() {
		return messageIndex;
	}

	public void setMessageIndex(String messageIndex) {
		this.messageIndex = messageIndex;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
