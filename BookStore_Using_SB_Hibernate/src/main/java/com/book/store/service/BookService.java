package com.book.store.service;

import java.util.List;


import com.book.store.domain.BookDomain;

public interface BookService {

    /**
     * Creates a new book 
     *
     * @param book The BookDomain object representing the book to be created.
     */
    public BookDomain createBook(BookDomain book);

    /**
     * Updates an existing book in the bookstore.
     *
     * @param bookId The ID of the book to be updated.
     * @param book   The BookDomain object representing the updated book information.
     */
    public BookDomain updateBook(Long bookId, BookDomain book);

    /**
     * Retrieves a book by its unique ID 
     *
     * @param bookId The ID of the book to retrieve.
     */
    public BookDomain getBookById(Long bookId);

    /**
     * Retrieves a book by its name 
     *
     * @param bookName The name of the book to retrieve.
     */
    public BookDomain getBookByName(String bookName);

    /**
     * Deletes a book  based on its unique ID.
     *
     * @param bookId The ID of the book to delete.
     */
    public void deleteBookById(Long bookId);

    /**
     * Retrieves a list of all books 
     *
     */
    public List<BookDomain> getAllBooks();

    /**
     * Retrieves a list of books 
     *
     * @param offset The offset from where to start fetching books.
     * @param limit  The maximum number of books to be retrieved per page.
     */
    public List<BookDomain> getAllBooksWithPagination(Integer offset, Integer limit);
}

