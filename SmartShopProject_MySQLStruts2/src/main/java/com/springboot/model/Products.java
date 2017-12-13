package com.springboot.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Products")
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProductID")
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

	@ManyToOne(optional = false)
	private CategoriesProduct categoryProduct;

	@Column(name = "Status")
	private String status;

	/*@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private OrderDetail orderDetail;*/

	public int getProductID() {
		return productID;
	}

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
