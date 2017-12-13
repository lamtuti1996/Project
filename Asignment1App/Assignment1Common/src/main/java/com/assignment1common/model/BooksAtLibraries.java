package com.assignment1common.model;

import javax.persistence.*;

@Entity
@Table(name = "Books_At_Libraries")
public class BooksAtLibraries implements java.io.Serializable {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "library_id", nullable = false, insertable = false, updatable = false)
	private Libraries library;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "isbn", nullable = false, insertable = false, updatable = false)
	private Books books;

	@Column(name = "quanity_in_stock")
	private String quanityInStock;

	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "isbn", column = @Column(name = "isbn", nullable = false)),
			@AttributeOverride(name = "libraryID", column = @Column(name = "library_id", nullable = false)) })
	private BookLibraryID id;

	public Libraries getLibrary() {
		return library;
	}

	public void setLibrary(Libraries library) {
		this.library = library;
	}

	public Books getBooks() {
		return books;
	}

	public void setBooks(Books books) {
		this.books = books;
	}

	public String getQuanityInStock() {
		return quanityInStock;
	}

	public void setQuanityInStock(String quanityInStock) {
		this.quanityInStock = quanityInStock;
	}

}
