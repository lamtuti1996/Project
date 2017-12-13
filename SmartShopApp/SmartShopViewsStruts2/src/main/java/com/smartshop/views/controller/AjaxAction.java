package com.smartshop.views.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.opensymphony.xwork2.Action;

public class AjaxAction implements Action {
	private int quanity;
	private int productID;
	private InputStream inputStream;
	private static final String URL = "http://localhost:8082/";

	@Override
	public String execute() throws Exception {
		byte[] bArray;
		RestTemplate restTemplate = new RestTemplate();
		URI targetUrl = UriComponentsBuilder.fromUriString(URL).path("checkQuanity").queryParam("productID", productID)
				.queryParam("quanity", quanity).build().toUri();
		Boolean check = restTemplate.getForObject(targetUrl, Boolean.class);
		if (check == true) {
			 bArray = (" du so luong").getBytes();
			 inputStream = new ByteArrayInputStream(bArray);
			return "success";
		} else {
			 bArray = ("Khong du so luong").getBytes();
			 inputStream = new ByteArrayInputStream(bArray);
			 return "success";
		}

	}

	public int getQuanity() {
		return quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	
	
}
