package org.example.crud;

import org.example.model.redis.RAuthor;
import org.example.model.redis.RBook;
import org.example.repo.redis.AuthorRepository;
import org.example.repo.redis.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CrudRedisService implements CrudService<RBook, RAuthor> {

    private static String OK = "OK";
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public CrudRedisService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public RBook saveBook(RBook book) {
        return bookRepository.save(book);
    }

    @Override
    public RAuthor saveAuthor(RAuthor author) {
        return authorRepository.save(author);
    }

    @Override
    public String deleteBook(String id) {
        bookRepository.delete(new RBook(id));
        return OK;
    }

    @Override
    public String deleteAuthor(String id) {
        authorRepository.delete(new RAuthor(id));
        return OK;
    }

    @Override
    public RBook getBook(String id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public RAuthor getAuthor(String id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public List<RBook> getBooksByAuthor(String id) {
        return bookRepository.findAllByAuthorId(id);
    }
}
