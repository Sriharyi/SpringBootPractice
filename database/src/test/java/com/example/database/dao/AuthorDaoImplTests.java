 package com.example.database.dao;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.database.dao.impl.AuthorDaoImpl;
import com.example.database.domain.Author;

public class AuthorDaoImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AuthorDaoImpl underTest;

    @Test
    public void testThatCreateAuthorandGenerateCorrectSql(){
        Author author = Author.builder()
        .id(1L)
        .name("sriharyi")
        .age(33)
        .build();
        underTest.create(author);
        verify(jdbcTemplate).update(eq("INSERT INTO authors (id, name, age) VALUES (?, ?, ?)"),
                                    eq(1L),eq("sriharyi"),eq(33));
    }


}
