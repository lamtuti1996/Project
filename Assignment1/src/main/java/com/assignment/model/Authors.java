package com.assignment.model;

import java.util.Set;

import javax.persistence.*;



@Entity
@Table(name = "Authors")
public class Authors {

	@Id
	@Column(name="author_id")
	private int authorID;
	
	@Column(name="author_first_name")
	private String authorFirstName;
	
	@Column(name="author_last_name")
	private String authorLastName;
	
	@ManyToMany(mappedBy = "authors")
	private Set<Books> books;

	public int getAuthorID() {
		return authorID;
	}

	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}

	public String getAuthorFirstName() {
		return authorFirstName;
	}

	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}

	public String getAuthorLastName() {
		return authorLastName;
	}

	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}

	public Set<Books> getBooks() {
		return books;
	}

	public void setBooks(Set<Books> books) {
		this.books = books;
	}
	
	
}
