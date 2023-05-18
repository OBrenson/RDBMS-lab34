package org.example.model.redis;

import org.example.model.Author;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("author")
public class RAuthor extends Author {

    private String id;
    private String name;
    private int year;

    public RAuthor() {
    }

    public RAuthor(String id, String name, int year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public RAuthor(String id) {
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
