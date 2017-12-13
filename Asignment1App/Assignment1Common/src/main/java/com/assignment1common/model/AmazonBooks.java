package com.assignment1common.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Amazon_Books")
public class AmazonBooks {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "isbn")
	private int isbn;

	@Column(name = "Titile")
	private String title;

	@Column(name = "Authors")
	private String authors;

	@Column(name = "Date_of_Publication")
	private Date dateOfPublication;

	@Column(name = "Amazon_Start_Rating")
	private String amazonStartRating;

	@Column(name = "Publisher")
	private String publisher;

	@Column(name = "List_Price")
	private String listPrice;

	@Column(name = "Amazon_Price")
	private String amazonPrice;

	@Column(name = "Your_Saving")
	private String yourSaving;

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public Date getDateOfPublication() {
		return dateOfPublication;
	}

	public void setDateOfPublication(Date dateOfPublication) {
		this.dateOfPublication = dateOfPublication;
	}

	public String getAmazonStartRating() {
		return amazonStartRating;
	}

	public void setAmazonStartRating(String amazonStartRating) {
		this.amazonStartRating = amazonStartRating;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getListPrice() {
		return listPrice;
	}

	public void setListPrice(String listPrice) {
		this.listPrice = listPrice;
	}

	public String getAmazonPrice() {
		return amazonPrice;
	}

	public void setAmazonPrice(String amazonPrice) {
		this.amazonPrice = amazonPrice;
	}

	public String getYourSaving() {
		return yourSaving;
	}

	public void setYourSaving(String yourSaving) {
		this.yourSaving = yourSaving;
	}
	
	
	

}
