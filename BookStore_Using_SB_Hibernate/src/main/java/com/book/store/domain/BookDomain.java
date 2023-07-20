package com.book.store.domain;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



public class BookDomain implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long bookId;
	
	@NotBlank(message = "bookName should not be Null or Empty")
	private String bookName;
	
	@NotBlank(message = "bookName should not be Null or Empty")
	private String bookAuthor;
	
	@NotBlank(message = "bookName should not be Null or Empty")
	private String bookDescription;
	
	@NotNull(message = "active should not be Null or Empty")
	private Boolean active;
	
	
     private Long totalRecords;

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(Long totalRecords) {
		this.totalRecords = totalRecords;
	}

	     
}
