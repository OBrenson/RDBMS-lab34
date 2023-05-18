package org.example.repo.mongo;

import org.example.model.mongo.MAuthor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoAuthorRepository extends MongoRepository<MAuthor, String> {

}
