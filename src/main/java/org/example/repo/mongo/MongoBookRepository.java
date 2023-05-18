package org.example.repo.mongo;

import org.example.model.mongo.MBook;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MongoBookRepository extends MongoRepository<MBook, String> {

    @Query("{id:'?0'}")
    List<MBook> findBooksByAuthorId(String id);
}
