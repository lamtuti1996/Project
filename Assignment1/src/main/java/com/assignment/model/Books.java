package com.assignment.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Books")
public class Books implements java.io.Serializable{

	@Id
	@Column(name = "isbn")
	private int isbn;

	@Column(name = "book_title")
	private String bookTitle;

	@Column(name = "date_of_publication")
	private Date dateOfPublication;

	@OneToMany(mappedBy = "books", fetch = FetchType.LAZY)
	private List<MemberRequests> memberRequestList;

	@ManyToMany
	@JoinTable(name = "Books_by_Category", joinColumns = @JoinColumn(name = "isbn"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Categories> categories;

	@ManyToMany
	@JoinTable(name = "Books_by_Author", joinColumns = @JoinColumn(name = "isbn"), inverseJoinColumns = @JoinColumn(name = "author_id"))
	private Set<Authors> authors;



	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public Date getDateOfPublication() {
		return dateOfPublication;
	}

	public void setDateOfPublication(Date dateOfPublication) {
		this.dateOfPublication = dateOfPublication;
	}

	public List<MemberRequests> getMemberRequestList() {
		return memberRequestList;
	}

	public void setMemberRequestList(List<MemberRequests> memberRequestList) {
		this.memberRequestList = memberRequestList;
	}

	public Set<Categories> getCategories() {
		return categories;
	}

	public void setCategories(Set<Categories> categories) {
		this.categories = categories;
	}

	public Set<Authors> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Authors> authors) {
		this.authors = authors;
	}

}
