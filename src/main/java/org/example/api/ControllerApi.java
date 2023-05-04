package org.example.api;

import org.example.model.redis.Author;
import org.example.model.redis.Book;

import java.util.List;

public interface ControllerApi {

    String saveBook(Book book);

    String saveAuthor(Author author);

    String deleteBook(String id);

    String deleteAuthor(String id);

    Book findBook(String id);

    Author findAuthor(String id);

    List<Book> getBooksByAuthor(String name);
}
