package org.example.api;

import org.example.model.Author;
import org.example.model.Book;

import java.util.List;

public interface ControllerApi <B extends Book, A extends Author> {

    String saveBook(B book);

    String saveAuthor(A author);

    String deleteBook(String id);

    String deleteAuthor(String id);

    B findBook(String id);

    A findAuthor(String id);

    List<B> getBooksByAuthor(String id);
}
