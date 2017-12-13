package com.azplay.azpotal.azgate.sc.entity;

import com.azplay.azpotal.azgate.sc.model.MTResponse;

public class RespondSendClient {
	private String status;
	private MTResponse data;
	private Error error;

	public RespondSendClient(String status, MTResponse data, Error error) {
		super();
		this.status = status;
		this.data = data;
		this.error = error;
	}

	public RespondSendClient() {
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public MTResponse getData() {
		return data;
	}

	public void setData(MTResponse data) {
		this.data = data;
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}
}
