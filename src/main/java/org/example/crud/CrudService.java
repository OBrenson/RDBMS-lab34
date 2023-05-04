package org.example.crud;

import org.example.model.redis.Author;
import org.example.model.redis.Book;

import java.util.List;

public interface CrudService {

    Book saveBook(Book book);

    Author saveAuthor(Author author);

    String deleteBook(String id);

    String deleteAuthor(String id);

    Book getBook(String id);

    Author getAuthor(String id);

    List<Book> getBooksByAuthor(String id);

}
