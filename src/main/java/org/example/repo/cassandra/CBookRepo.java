package org.example.repo.cassandra;

import org.example.model.cassandra.CBook;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;

public interface CBookRepo extends CassandraRepository<CBook, String> {

    @Query(allowFiltering = true)
    List<CBook> findAllByAuthorId(String authorId);
}
