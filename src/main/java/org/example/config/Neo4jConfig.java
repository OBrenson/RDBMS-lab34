package org.example.config;

import org.springframework.context.annotation.Configuration;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;

@ComponentScan("org.example")
@EnableNeo4jRepositories(basePackages = "org.example.repo.neo4j")
@PropertySource("classpath:application.properties")
public class Neo4jConfig {
    public static final String URL = "bolt://localhost:7676";

    @Bean
    public org.neo4j.ogm.config.Configuration getConfiguration() {
        return new org.neo4j.ogm.config.Configuration.Builder().credentials("neo4j", "neo4jneo4j")
                .uri(URL).build();
    }

    @Bean
    public SessionFactory getSessionFactory(org.neo4j.ogm.config.Configuration configuration) {
        return new SessionFactory(configuration,
                "org.example.model.neo4j");
    }

    @Bean
    public Neo4jTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new Neo4jTransactionManager(sessionFactory);
    }
}
