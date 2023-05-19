package org.example.repo.neo4j;

import org.example.model.neo4j.NBook;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface NBookRepo extends Neo4jRepository<NBook, String> {

    List<NBook> findAllByAuthorId(String id);
}
