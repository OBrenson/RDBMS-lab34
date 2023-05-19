package org.example.repo.mongo;

import org.example.model.mongo.MBook;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MongoBookRepository extends MongoRepository<MBook, String> {

    List<MBook> findAllByAuthorId(String id);
}
