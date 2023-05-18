package org.example.repo.redis;

import org.example.model.redis.RAuthor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<RAuthor, String> {
    RAuthor findAuthorByName(String name);
}
