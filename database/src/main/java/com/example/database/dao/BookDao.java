package com.example.database.dao;

import java.util.List;
import java.util.Optional;

import com.example.database.domain.Book;

public interface BookDao {
    void create(Book book);

    Optional<Book> findOne(String isbn);
    
    List<Book> findMany();

	void update(String isbn, Book book);

	void delete(String isbn);
}
