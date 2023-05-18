package org.example.crud;

import org.example.model.mongo.MAuthor;
import org.example.model.mongo.MBook;
import org.example.repo.mongo.MongoAuthorRepository;
import org.example.repo.mongo.MongoBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CrudMongoService implements CrudService<MBook, MAuthor> {

    private static String OK = "OK";
    private final MongoAuthorRepository authorRepository;
    private final MongoBookRepository bookRepository;

    @Autowired
    public CrudMongoService(MongoAuthorRepository authorRepository, MongoBookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public MBook saveBook(MBook book) {
        return bookRepository.save(book);
    }

    @Override
    public MAuthor saveAuthor(MAuthor author) {
        return authorRepository.save(author);
    }

    @Override
    public String deleteBook(String id) {
        bookRepository.deleteById(id);
        return OK;
    }

    @Override
    public String deleteAuthor(String id) {
        authorRepository.deleteById(id);
        return OK;
    }

    @Override
    public MBook getBook(String id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public MAuthor getAuthor(String id) {
        return authorRepository.findById(id).get();
    }

    @Override
    public List<MBook> getBooksByAuthor(String id) {
        return bookRepository.findBooksByAuthorId(id);
    }
}
