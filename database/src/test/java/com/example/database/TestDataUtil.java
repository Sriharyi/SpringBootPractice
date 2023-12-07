package com.example.database;

import com.example.database.domain.Author;
import com.example.database.domain.Book;

public final class TestDataUtil {
    private TestDataUtil(){
    }

    public static Author createTestAuthorA() {
        return Author.builder()
                .id(1L)
                .name("Abigail Rose")
                .age(80)
                .build();
    }
    
    public static Author createTestAuthorB() {
        return Author.builder()
                .id(2L)
                .name("Thomas Wayne")
                .age(40)
                .build();
    }

    public static Book createTestBookA() {
        return Book.builder()
                .isbn("978-1-2345-6789-0")
                .title("The Shadow in the Attic")
                .authorId(1L)
                .build();
    }
    
    public static Book createTestBookB() {
        return Book.builder()
                .isbn("978-1-2345-6798-0")
                .title("The Shadow in the Basement")
                .authorId(1L)
                .build();
    }
}
