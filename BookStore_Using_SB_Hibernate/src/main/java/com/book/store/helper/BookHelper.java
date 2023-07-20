package com.book.store.helper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.book.store.domain.BookDomain;
import com.book.store.response.BookResponse;
import com.book.store.response.StatusType;
import com.book.store.service.BookService;

/**
 * The BookHelper class provides to interact with the BookService.
 */
@Component
public class BookHelper {

	private static final Logger logger = LoggerFactory.getLogger(BookHelper.class);

	private static final String ERROR_MSG = "Exception Occured while executing service";

	@Autowired
	private BookService bookService;

	/**
     * Creates a new book 
     *
     * @param bookDomain The BookDomain object
     * @return A BookResponse object containing the status,message and data
     */
	public BookResponse<BookDomain> createBook(BookDomain bookDomain) {

		BookResponse<BookDomain> response;
		HttpStatus httpStatus;

		try {
			BookDomain savebook = bookService.createBook(bookDomain);

			if (savebook != null) {
				httpStatus = HttpStatus.OK;
				response = BookResponse.builResponse(null, StatusType.SUCCESS, httpStatus.value(),
						"Book Details are added successfully.");
			} else {
				httpStatus = HttpStatus.BAD_REQUEST;
				response = BookResponse.builResponse(null, StatusType.ERROR, httpStatus.value(),
						"Error Occurred While Creating Books,please try again later.");
			}
		} catch (Exception e) {
			logger.error(ERROR_MSG, e);
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response = BookResponse.builResponse(null, StatusType.ERROR, httpStatus.value(),
					"Error Occurred While Creating Books");
		}
		return response;
	}
	/**
     *  Updates an existing book 
     *
      * @param bookId     The ID of the book to be updated.
     * @param bookDomain The BookDomain object
     * @return A BookResponse object containing the status, message and data
     */
	public BookResponse<BookDomain> updateBook(Long bookId, BookDomain bookDomain) {

		BookResponse<BookDomain> response;
		HttpStatus httpStatus;

		try {
			BookDomain updateExistingBook = bookService.updateBook(bookId, bookDomain);

			if (updateExistingBook != null) {
				httpStatus = HttpStatus.OK;
				response = BookResponse.builResponse(null, StatusType.SUCCESS, httpStatus.value(),
						"Book Details are updated successfully.");
			} else {
				httpStatus = HttpStatus.BAD_REQUEST;
				response = BookResponse.builResponse(null, StatusType.ERROR, httpStatus.value(),
						"Error Occurred While updatiing Books,please try again later.");
			}

		}  catch (Exception e) {
			logger.error(ERROR_MSG, e);
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response = BookResponse.builResponse(null, StatusType.ERROR, httpStatus.value(),
					"Error Occurred While updating Books");
		}
		return response;
	}

	/**
     * Retrieves a book from the based on the given book ID.
     *
     * @param bookId The ID of the book to retrieve.
     * @return A BookResponse object containing the status, message, and data.
     */
	public BookResponse<BookDomain> retriveBook(Long bookId) {

		BookResponse<BookDomain> response;
		HttpStatus httpStatus;

		try {
			BookDomain getBook = bookService.getBookById(bookId);

			if (getBook != null) {
				httpStatus = HttpStatus.OK;
				response = BookResponse.builResponse(getBook, StatusType.SUCCESS, httpStatus.value(),
						"Book Details are fetch successfully.");
			} else {
				httpStatus = HttpStatus.BAD_REQUEST;
				response = BookResponse.builResponse(null, StatusType.ERROR, httpStatus.value(),
						"Error Occurred While fetch Books,please try again later.");
			}
		}  catch (Exception e) {
			logger.error(ERROR_MSG, e);
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response = BookResponse.builResponse(null, StatusType.ERROR, httpStatus.value(),
					"Error Occurred While fetching Books");
		}
		return response;
	}
    /**
     * Deletes a book
     * @param bookId The based on ID of the book to be deleted.
     * @return  A BookResponse object containing the status and message
     */
	public BookResponse<Void> deleteBook(Long bookId) {

		BookResponse<Void> response;
		HttpStatus httpStatus;

		try {
			bookService.deleteBookById(bookId);
			httpStatus = HttpStatus.OK;
			response = BookResponse.builResponse(null, StatusType.SUCCESS, httpStatus.value(),
					"Book Details are Delete successfully.");

		} catch (Exception e) {
			logger.error(ERROR_MSG, e);
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response = BookResponse.builResponse(null, StatusType.ERROR, httpStatus.value(),
					"Error Occurred While fetching Books");
		}
		return response;
	}

	/**
     * Fetch a book by its name. 
     *
     * @param bookName The name of the book to retrieve.
     * @return A BookResponse object containing the status, message, and data.
     */
	public BookResponse<BookDomain> fetchBookName(String bookName) {

		BookResponse<BookDomain> response;
		HttpStatus httpStatus;

		try {
			BookDomain getBook = bookService.getBookByName(bookName);

			if (getBook != null) {
				httpStatus = HttpStatus.OK;
				response = BookResponse.builResponse(getBook, StatusType.SUCCESS, httpStatus.value(),
						"BookNames are fetch successfully.");
			} else {
				httpStatus = HttpStatus.BAD_REQUEST;
				response = BookResponse.builResponse(null, StatusType.ERROR, httpStatus.value(),
						"Error Occurred While BookNames,please try again later.");
			}
		} catch (Exception e) {
			logger.error(ERROR_MSG, e);
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response = BookResponse.builResponse(null, StatusType.ERROR, httpStatus.value(),
					"Error Occurred While fetching BookNames");
		}
		return response;
	}

	/**
     * Fetch all active books 
     *
     * @return A BookResponse object containing the status, message and data.
     */
	public BookResponse<List<BookDomain>> fetchActiveBooks() {

		BookResponse<List<BookDomain>> response = null;
		HttpStatus httpStatus;

		try {
			List<BookDomain> getBooks = bookService.getAllBooks();
			List<BookDomain> activeBooks = new ArrayList<>();
			for (BookDomain details : getBooks) {
				if (details.getActive() == true)
					activeBooks.add(details);
			}
			if (activeBooks != null) {
				httpStatus = HttpStatus.OK;
				response = BookResponse.builResponse(activeBooks, StatusType.SUCCESS, httpStatus.value(),
						"ActiveBooks are fetch successfully.");
			}
		} catch (Exception e) {
			logger.error(ERROR_MSG, e);
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response = BookResponse.builResponse(null, StatusType.ERROR, httpStatus.value(),
					"Error Occurred While fetching ActiveBooks");
		}
		return response;
	}

	/**
     * Fetch books with pagination 
     *
     * @param pageNumber The page number for pagination.
     * @param pageSize   The number of books per page.
     * @return A BookResponse object containing the status, message.
     */
	public BookResponse<List<BookDomain>> fetchBooksWithPagination(Integer pageNumber, Integer pageSize) {

		BookResponse<List<BookDomain>> response;
		HttpStatus httpStatus;

		try {
			List<BookDomain> bookDomain = bookService.getAllBooksWithPagination(pageNumber, pageSize);

			if (bookDomain != null) {
				httpStatus = HttpStatus.OK;
				response = BookResponse.builResponse(bookDomain, StatusType.SUCCESS, httpStatus.value(),
						"All Books are fetch successfully.");
			} else {
				httpStatus = HttpStatus.BAD_REQUEST;
				response = BookResponse.builResponse(null, StatusType.ERROR, httpStatus.value(),
						"Error Occurred While Book,please try again later.");
			}
		} catch (Exception e) {
			logger.error(ERROR_MSG, e);
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response = BookResponse.builResponse(null, StatusType.ERROR, httpStatus.value(),
					"Error Occurred While fetching Books");
		}
		return response;
	}

}
