package com.book.store.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.store.domain.BookDomain;
import com.book.store.helper.BookHelper;
import com.book.store.response.BookResponse;

@RestController
@Validated
@RequestMapping(value = "/api/books")
public class BookController {

	@Autowired
	private BookHelper bookHelper;
	
	@PostMapping()
	public ResponseEntity<BookResponse<BookDomain>> addBook(@Valid @RequestBody BookDomain book){
		BookResponse<BookDomain> response;
		HttpStatus httpStatus;
		response = bookHelper.createBook(book);
	    httpStatus = HttpStatus.valueOf(Integer.parseInt(response.getCode()));
		return new ResponseEntity<>(response, httpStatus);
	}
	
	@PutMapping(value = "/{bookId}")
	public ResponseEntity<BookResponse<BookDomain>> updateBook(@PathVariable(value = "bookId") Long bookId, @Valid @RequestBody BookDomain book){
		BookResponse<BookDomain> response;
		HttpStatus httpStatus;
		response = bookHelper.updateBook(bookId, book);
	    httpStatus = HttpStatus.valueOf(Integer.parseInt(response.getCode()));
		return new ResponseEntity<>(response, httpStatus);
	}
	
	@GetMapping(value = "/{bookId}")
	public ResponseEntity<BookResponse<BookDomain>> getBook(@PathVariable(value = "bookId") Long bookId){
		BookResponse<BookDomain> response;
		HttpStatus httpStatus;
		response = bookHelper.retriveBook(bookId);
	    httpStatus = HttpStatus.valueOf(Integer.parseInt(response.getCode()));
		return new ResponseEntity<>(response, httpStatus);
	}
	@DeleteMapping(value = "/{bookId}")
	public ResponseEntity<BookResponse<Void>> deleteBook(@PathVariable(value = "bookId") Long bookId){
		BookResponse<Void> response;
		HttpStatus httpStatus;
		response = bookHelper.deleteBook(bookId);
	    httpStatus = HttpStatus.valueOf(Integer.parseInt(response.getCode()));
		return new ResponseEntity<>(response, httpStatus);
	}
	
	@GetMapping(value = "/name/{bookName}")
	public ResponseEntity<BookResponse<BookDomain>> fetchBookName(@PathVariable(value = "bookName")String bookName){
		BookResponse<BookDomain> response;
		HttpStatus httpStatus;
		response = bookHelper.fetchBookName(bookName);
	    httpStatus = HttpStatus.valueOf(Integer.parseInt(response.getCode()));
		return new ResponseEntity<>(response, httpStatus);
	}
	
	@GetMapping(value = "/activeBooks")
	public ResponseEntity<BookResponse<List<BookDomain>>> fetchActiveBooks()
     {
		BookResponse<List<BookDomain>>response;
		HttpStatus httpStatus;
		response = bookHelper.fetchActiveBooks();
	    httpStatus = HttpStatus.valueOf(Integer.parseInt(response.getCode()));
		return new ResponseEntity<>(response, httpStatus);
	}
	
	
	@GetMapping(value = "/allPaginationBooks")
	public ResponseEntity<BookResponse<List<BookDomain>>> fetchBooksWithPagination(
			@RequestParam(name = "pageNumber", defaultValue = "1") @Range(min = 1, message = "Please select positive numbers for pageNumber")Integer pageNumber, 
			@RequestParam(value = "pageSize", defaultValue = "10") @Range(min = 1, max = 30, message = "Please select positive numbers for pageSize and must be between 1-30") Integer pageSize){
		BookResponse<List<BookDomain>>response;
		HttpStatus httpStatus;
		response = bookHelper.fetchBooksWithPagination(pageNumber, pageSize);
	    httpStatus = HttpStatus.valueOf(Integer.parseInt(response.getCode()));
		return new ResponseEntity<>(response, httpStatus);
	}	
	
}