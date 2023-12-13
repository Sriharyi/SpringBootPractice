package com.deviro.books;

import com.deviro.books.domain.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JacksonTests {

  @Test
  public void testthatCreateObjectMapperCanCreateJsonFromJavaObject()
      throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    Book book =
        Book.builder()
            .isbn("978-0-13-478627-5")
            .title("The Enigma of Eternity")
            .author("Aria Montgomery")
            .yearPublished("2005")
            .build();

    String result = objectMapper.writeValueAsString(book);

    Assertions.assertThat(result)
        .isEqualTo(
            "{\"isbn\":\"978-0-13-478627-5\",\"title\":\"The Enigma of"
                + " Eternity\",\"author\":\"Aria Montgomery\",\"yearPublished\":\"2005\"}");
  }

  @Test
  public void testthatCreateObjectMapperCanCreateJavaObjectFromJson()
      throws JsonMappingException, JsonProcessingException {
    String json =
        "{\"isbn\":\"978-0-13-478627-5\",\"title\":\"The Enigma of"
            + " Eternity\",\"author\":\"Aria Montgomery\",\"yearPublished\":\"2005\"}";
    Book book =
        Book.builder()
            .isbn("978-0-13-478627-5")
            .title("The Enigma of Eternity")
            .author("Aria Montgomery")
            .yearPublished("2005")
            .build();

    ObjectMapper objectMapper = new ObjectMapper();

    Book resultBook = objectMapper.readValue(json, Book.class);

    Assertions.assertThat(resultBook).isEqualTo(book);
  }
}
