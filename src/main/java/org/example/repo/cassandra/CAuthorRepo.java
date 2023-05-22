package org.example.repo.cassandra;

import org.example.model.cassandra.CAuthor;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface CAuthorRepo extends CassandraRepository<CAuthor, String> {
}
