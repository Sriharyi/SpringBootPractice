package com.example.database.dao.impl;

import com.example.database.TestDataUtil;
import com.example.database.dao.AuthorDao;
import com.example.database.dao.impl.BookDaoImpl;
import com.example.database.domain.Author;
import com.example.database.domain.Book;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookDaoImplIntegrationTests {

    private AuthorDao authorDao;
    private BookDaoImpl underTest;

    @Autowired
    public BookDaoImplIntegrationTests(BookDaoImpl underTest, AuthorDao authorDao) {
        this.underTest = underTest;
        this.authorDao = authorDao;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled() {
        Author author = TestDataUtil.createTestAuthorA();
        authorDao.create(author);
        Book book = TestDataUtil.createTestBookA();
        book.setAuthorId(author.getId());
        underTest.create(book);
        Optional<Book> result = underTest.findOne(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);
    }
    
    
    @Test
    public void testThatMultipleBookCanBeCreatedAndRecalled() {
    	Author authorA = TestDataUtil.createTestAuthorA();
    	authorDao.create(authorA);
    	Book bookA = TestDataUtil.createTestBookA();
    	bookA.setAuthorId(authorA.getId());
    	underTest.create(bookA);
    	Book bookB = TestDataUtil.createTestBookB();
    	bookB.setAuthorId(authorA.getId());
    	underTest.create(bookB);
    	
    	List<Book> result = underTest.findMany();
    	
    	assertThat(result).hasSize(2).containsExactly(bookA,bookB);
    }
    
    @Test
    public void testThatBookCanBeUpdated() {
        Author author = TestDataUtil.createTestAuthorA();
        authorDao.create(author);

        Book bookA = TestDataUtil.createTestBookA();
        bookA.setAuthorId(author.getId());
        underTest.create(bookA);

        bookA.setTitle("UPDATED");
        underTest.update(bookA.getIsbn(), bookA);

        Optional<Book> result = underTest.findOne(bookA.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(bookA);
    }
}
