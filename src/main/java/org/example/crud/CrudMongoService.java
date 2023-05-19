package org.example.crud;

import org.example.model.mongo.MAuthor;
import org.example.model.mongo.MBook;
import org.example.repo.mongo.MongoAuthorRepository;
import org.example.repo.mongo.MongoBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CrudMongoService extends AbstractCrudService<MBook, MAuthor> {

    @Autowired
    public CrudMongoService(MongoBookRepository bookRepository, MongoAuthorRepository authorRepository) {
        super(bookRepository, authorRepository);
    }


    @Override
    public List<MBook> getBooksByAuthor(String id) {
        return ((MongoBookRepository)bookRepo).findAllByAuthorId(id);
    }
}
