package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.core.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(
        basePackages = "org.example.repo.cassandra")
@PropertySource(value = { "classpath:application.properties" })
public class CassandraConfig extends AbstractCassandraConfiguration {
    @Override
    protected String getKeyspaceName() {
        return "test";
    }
    @Override
    protected String getLocalDataCenter() {
        return "datacenter1";
    }
}
