package org.example.repo.redis;

import org.example.model.redis.RBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<RBook, String> {

    List<RBook> findAllByAuthorId(String authorId);

}
