package org.example.repo.neo4j;

import org.example.model.neo4j.NAuthor;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface NAuthorRepo extends Neo4jRepository<NAuthor, String> {
}
