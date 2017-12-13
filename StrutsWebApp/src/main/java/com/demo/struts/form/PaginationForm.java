package com.demo.struts.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

public class PaginationForm extends ActionForm {

	private String start;
	private String range;
	private String results;
	private String action;
	private String styleClass;
	private String title;
	private List listProduct;

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getStyleClass() {
		return styleClass;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List getListProduct() {
		return listProduct;
	}

	public void setListProduct(List listProduct) {
		this.listProduct = listProduct;
	}

}
