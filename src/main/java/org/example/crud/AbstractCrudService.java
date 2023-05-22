package org.example.crud;

import org.example.model.Author;
import org.example.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public abstract class AbstractCrudService<B extends Book, A extends Author> implements CrudService<B, A>{

    private final static String OK = "OK";
    
    protected final CrudRepository<B, String> bookRepo;
    private final CrudRepository<A, String> authorRepo;
    
    public AbstractCrudService(CrudRepository<B, String> bookRepo, CrudRepository<A, String> authorRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
    }

    @Override
    public B saveBook(B book) {
        return bookRepo.save(book);
    }

    @Override
    public A saveAuthor(A author) {
        return authorRepo.save(author);
    }

    @Override
    public String deleteBook(String id) {
        bookRepo.deleteById(id);
        return OK;
    }

    @Override
    public String deleteAuthor(String id) {
        authorRepo.deleteById(id);
        return OK;
    }

    @Override
    public B getBook(String id) {
        return bookRepo.findById(id).orElse(null);
    }

    @Override
    public A getAuthor(String id) {
        return authorRepo.findById(id).orElse(null);
    }

    @Override
    public abstract List<B> getBooksByAuthor(String id);

    @Override
    public List<B> findAllBooks() {
        Iterable<B> iterable = bookRepo.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<A> findAllAuthors() {
        Iterable<A> iterable = authorRepo.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }
}
