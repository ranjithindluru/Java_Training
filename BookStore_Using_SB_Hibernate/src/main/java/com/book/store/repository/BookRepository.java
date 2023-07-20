package com.book.store.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.store.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	public Book findByBookId(Long bookId);

	public Book findByBookName(String bookName);
	
}
