package com.demo.struts.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;
import org.apache.struts.validator.ValidatorForm;

import com.demo.struts.entity.Product;

public class ShowProductForm extends   ActionForm {

	private List listProduct;

	public ShowProductForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List getListProduct() {
		return listProduct;
	}

	public void setListProduct(List listProduct) {
		this.listProduct = listProduct;
	}






}
