package org.example.model.mongo;

import org.example.model.Author;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("author")
public class MAuthor extends Author {

    @Id
    private String id;
    private String name;
    private int year;

    public MAuthor() {
    }

    public MAuthor(String id, String name, int year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public MAuthor(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
