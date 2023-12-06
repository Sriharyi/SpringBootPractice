package com.example.database.dao;

import java.util.Optional;

import com.example.database.domain.Book;

public interface BookDao {
    void create(Book book);

    Optional<Book> find(String isbn);
}
