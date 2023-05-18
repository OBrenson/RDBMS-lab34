package org.example.crud;

import org.example.model.Author;
import org.example.model.Book;

import java.util.List;

public interface CrudService<B extends Book, A extends Author> {

    B saveBook(B book);

    A saveAuthor(A author);

    String deleteBook(String id);

    String deleteAuthor(String id);

    B getBook(String id);

    A getAuthor(String id);

    List<B> getBooksByAuthor(String id);

}
