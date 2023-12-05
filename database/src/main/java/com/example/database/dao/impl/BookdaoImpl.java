package com.example.database.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import com.example.database.dao.BookDao;

public class BookdaoImpl implements BookDao{

    private final JdbcTemplate jdbcTemplate;

    public BookdaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
