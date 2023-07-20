package com.book.store.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.book.store.domain.BookDomain;
import com.book.store.entity.Book;
import com.book.store.objectcopier.ObjectCopier;
import com.book.store.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository bookRepository;
	
	/**
     * Creates a new book 
     *
     * @param book The BookDomain object representing the book to be created.
     * @return The BookDomain object representing the newly created book.
     */
	
	@Override
	public BookDomain createBook(BookDomain bookDomain) {
		Book entity = toEntity(bookDomain);
		entity = bookRepository.save(entity);
		return toDomain(entity);
	}
	
	/**
     * Updates an existing book 
     *
     * @param bookId The ID of the book to be updated.
     * @param book   The BookDomain object representing the updated book information.
     * @return The BookDomain object representing the updated book.
     */

	
	public BookDomain updateBook(Long bookId, BookDomain bookDomain) {
		Book existingbooks = bookRepository.findByBookId(bookId);		
		if(existingbooks != null) {
			existingbooks.setBookName(bookDomain.getBookName());
			existingbooks.setBookAuthor(bookDomain.getBookAuthor());
			existingbooks.setBookDescription(bookDomain.getBookDescription());
			existingbooks.setActive(bookDomain.getActive());
			return toDomain(bookRepository.save(existingbooks));
		}
		return null;
	}


	/**
     * Retrieves a book by its unique ID 
     *
     * @param bookId The ID of the book to retrieve.
     * @return The BookDomain object representing the found book, or null if not found.
     */
	public BookDomain getBookById(Long bookId) {
		
		Book getBook = bookRepository.findByBookId(bookId);
		if (getBook != null) {
			return toDomain(getBook);
		}
		return null;
	}
		
	 /**
     * Deletes a book based on its unique ID.
     *
     * @param bookId The ID of the book to delete.
     */
	public void deleteBookById(Long bookId) {
		bookRepository.deleteById(bookId);
	}

	/**
	 *Retrieves a list of books
	 */
	@Override
	public List<BookDomain> getAllBooks() {
		
		List<BookDomain> eventsList = new ArrayList<BookDomain>();
		List<Book> entityList = bookRepository.findAll();
		if (entityList.size() > 0) {
			for (Book entity : entityList) {
				eventsList.add(toDomain(entity));
			}
		}
		return eventsList;
	}
	 /**
     * Retrieves a list of books with pagination support.
     *
     * @param offset The offset from where to start fetching books.
     * @param limit  The maximum number of books to be retrieved per page.
     * @return A List of BookDomain objects representing the books within the given offset and limit.
     */
	public List<BookDomain> getAllBooksWithPagination(Integer offset, Integer limit) {
		Pageable pageable = PageRequest.of(--offset, limit);
		Page<com.book.store.entity.Book> page = bookRepository
				.findAll(pageable);
		List<BookDomain> bookDomainList = new ArrayList<BookDomain>();
		for (com.book.store.entity.Book bookDetail : page) {
			BookDomain domain = toDomain(bookDetail);
			domain.setTotalRecords(page.getTotalElements());
			bookDomainList.add(domain);
		}
		return bookDomainList;
	}

	/**
     * Retrieves a book by its name from the bookstore.
     *
     * @param bookName The name of the book to retrieve.
     * @return The BookDomain object representing the found book, or null if not found.
     */
	@Override
	public BookDomain getBookByName(String bookName) {
		Book getBookName = bookRepository.findByBookName(bookName);
		if (getBookName != null) {
			return toDomain(getBookName);
		}
		return null;
	}

	/**
     * Converts a BookDomain object to a Book entity.
     *
     * @param domain The BookDomain object to convert.
     * @return The corresponding Book entity.
     */
	
	private com.book.store.entity.Book toEntity(BookDomain domain) {
		com.book.store.entity.Book entity = new com.book.store.entity.Book();
		ObjectCopier.copyObject(domain, entity);
		return entity;
	}

	/**
     * Converts a Book entity to a BookDomain object.
     *
     * @param entity The Book entity to convert.
     * @return The corresponding BookDomain object.
     */
	private BookDomain toDomain(com.book.store.entity.Book entity) {
		BookDomain domain = new BookDomain();
		ObjectCopier.copyObject(entity, domain);
		return domain;
	}

	
}
