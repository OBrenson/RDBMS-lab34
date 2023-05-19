package org.example.crud;

import org.example.model.redis.RAuthor;
import org.example.model.redis.RBook;
import org.example.repo.redis.AuthorRepository;
import org.example.repo.redis.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CrudRedisService extends AbstractCrudService<RBook, RAuthor> {

    @Autowired
    public CrudRedisService(BookRepository bookRepository, AuthorRepository authorRepository) {
        super(bookRepository, authorRepository);
    }

    @Override
    public List<RBook> getBooksByAuthor(String id) {
        return ((BookRepository)bookRepo).findAllByAuthorId(id);
    }
}
