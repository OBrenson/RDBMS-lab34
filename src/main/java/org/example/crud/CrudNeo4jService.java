package org.example.crud;

import org.example.model.neo4j.NAuthor;
import org.example.model.neo4j.NBook;
import org.example.repo.neo4j.NAuthorRepo;
import org.example.repo.neo4j.NBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CrudNeo4jService extends AbstractCrudService<NBook, NAuthor>{

    @Autowired
    public CrudNeo4jService(NBookRepo bookRepo, NAuthorRepo authorRepo) {
        super(bookRepo, authorRepo);
    }

    @Override
    public List<NBook> getBooksByAuthor(String id) {
        return ((NBookRepo)bookRepo).findAllByAuthorId(id);
    }
}
