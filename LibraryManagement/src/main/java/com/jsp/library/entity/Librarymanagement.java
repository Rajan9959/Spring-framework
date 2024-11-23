package com.jsp.library.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQuery(name="Librarymanagement.findAll", query="SELECT l FROM Librarymanagement l")
public class Librarymanagement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer book_Id;

	private String book_Author;

	private String book_Name;

	private String library_Name;

	private int no_of_Books;

	@Temporal(TemporalType.DATE)
	private Date published_Date;

	public Librarymanagement() {
	}

	public int getBook_Id() {
		return this.book_Id;
	}

	public void setBook_Id(int book_Id) {
		this.book_Id = book_Id;
	}

	public String getBook_Author() {
		return this.book_Author;
	}

	public void setBook_Author(String book_Author) {
		this.book_Author = book_Author;
	}

	public String getBook_Name() {
		return this.book_Name;
	}

	public void setBook_Name(String book_Name) {
		this.book_Name = book_Name;
	}

	public String getLibrary_Name() {
		return this.library_Name;
	}

	public void setLibrary_Name(String library_Name) {
		this.library_Name = library_Name;
	}

	public int getNo_of_Books() {
		return this.no_of_Books;
	}

	public void setNo_of_Books(int no_of_Books) {
		this.no_of_Books = no_of_Books;
	}

	public Date getPublished_Date() {
		return this.published_Date;
	}

	public void setPublished_Date(Date published_Date) {
		this.published_Date = published_Date;
	}

}