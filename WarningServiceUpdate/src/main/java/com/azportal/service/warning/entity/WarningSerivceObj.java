package com.azportal.service.warning.entity;

import java.sql.Timestamp;
import java.util.Date;

public class WarningSerivceObj {

	private String message;
	private String adressService;
	private Timestamp timeRequest;
	private long timeDiff;
	private String status;

	public WarningSerivceObj() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAdressService() {
		return adressService;
	}

	public void setAdressService(String adressService) {
		this.adressService = adressService;
	}

	public Date getTimeRequest() {
		return timeRequest;
	}

	public void setTimeRequest(Timestamp timeRequest) {
		this.timeRequest = timeRequest;
	}

	public long getTimeDiff() {
		return timeDiff;
	}

	public void setTimeDiff(long timeDiff) {
		this.timeDiff = timeDiff;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
