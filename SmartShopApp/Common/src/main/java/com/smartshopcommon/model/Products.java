package com.smartshopcommon.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Products")
public class Products implements Serializable{

	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ProductID", unique = true, nullable = false)
	private int productID;

	@Column(name = "ProductName")
	private String productName;

	@Column(name = "ProductPrice")
	private float price;

	@Column(name = "Description")
	private String description;

	@Column(name = "ImageURL")
	private String imageURL;

	@Column(name = "Quality")
	private int quality;

	@JsonBackReference
	@ManyToOne(optional = false)
	private CategoriesProduct categoryProduct;

	@Column(name = "Status")
	private String status;


/*	@JsonBackReference
	//@OneToOne(fetch = FetchType.LAZY,mappedBy = "product",cascade = CascadeType.ALL, orphanRemoval = true)
	@ManyToOne(optional = false)
	private OrderDetail orderdetails ;*/
	
	@JsonManagedReference
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private List<OrderDetail> orderDetailList;

	

	
	public List<OrderDetail> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(List<OrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}

	public int getProductID() {
		return productID;
	}

/*	public OrderDetail getOrderdetails() {
		return orderdetails;
	}

	public void setOrderdetails(OrderDetail orderdetails) {
		this.orderdetails = orderdetails;
	}*/

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public CategoriesProduct getCategoryProduct() {
		return categoryProduct;
	}

	public void setCategoryProduct(CategoriesProduct categoryProduct) {
		this.categoryProduct = categoryProduct;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


}
