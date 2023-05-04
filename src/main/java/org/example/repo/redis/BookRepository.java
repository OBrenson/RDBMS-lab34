package org.example.repo.redis;

import org.example.model.redis.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {

    List<Book> findAllByAuthorId(String authorId);

}