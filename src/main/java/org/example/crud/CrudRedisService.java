package org.example.crud;

import org.example.model.redis.Author;
import org.example.model.redis.Book;
import org.example.repo.redis.AuthorRepository;
import org.example.repo.redis.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class CrudRedisService implements CrudService {

    private static String OK = "OK";
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public CrudRedisService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public String deleteBook(String id) {
        bookRepository.delete(new Book(id));
        return OK;
    }

    @Override
    public String deleteAuthor(String id) {
        authorRepository.delete(new Author(id));
        return OK;
    }

    @Override
    public Book getBook(String id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Author getAuthor(String id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Book> getBooksByAuthor(String id) {
        return StreamSupport.stream(bookRepository.findAll().spliterator(), false)
                .filter(b -> b.getAuthorId().equals(id)).collect(Collectors.toList());
    }
}
