package org.example.crud;

import org.example.model.cassandra.CAuthor;
import org.example.model.cassandra.CBook;
import org.example.repo.cassandra.CAuthorRepo;
import org.example.repo.cassandra.CBookRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CrudCassandraService extends AbstractCrudService<CBook, CAuthor> {

    public CrudCassandraService(CBookRepo bookRepo, CAuthorRepo authorRepo) {
        super(bookRepo, authorRepo);
    }

    @Override
    public List<CBook> getBooksByAuthor(String id) {
        return ((CBookRepo)bookRepo).findAllByAuthorId(id);
    }
}
