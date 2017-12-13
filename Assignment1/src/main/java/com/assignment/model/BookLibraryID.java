package com.assignment.model;

import javax.persistence.*;

@Embeddable
public class BookLibraryID implements java.io.Serializable{
	
	
	@Column(name ="isbn", nullable = false)
	private int isbn;
	
	
	@Column(name ="library_id", nullable = false)
	private int libraryID;
	
	
	public int getIsbn() {
		return isbn;
	}


	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}


	public int getLibraryID() {
		return libraryID;
	}


	public void setLibraryID(int libraryID) {
		this.libraryID = libraryID;
	}


	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIsbn();
		result = 37 * result + this.getLibraryID();
		return result;
		}

}
