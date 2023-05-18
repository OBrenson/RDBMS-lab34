package org.example.model.redis;

import org.example.model.Book;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash("book")
public class RBook extends Book {


    private String id;
    @Indexed
    private String authorId;
    private String name;
    private double price;

    public RBook(){
    }

    public RBook(String id, String authorId, String name, double price) {
        this.id = id;
        this.authorId = authorId;
        this.name = name;
        this.price = price;
    }

    public RBook(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
