package org.example.repo.redis;

import org.example.model.redis.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, String> {
    Author findAuthorByName(String name);
}
