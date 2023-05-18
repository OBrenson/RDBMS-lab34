package org.example.model.mongo;

import org.example.model.Book;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("book")
public class MBook extends Book {

    @Id
    private String id;

    private String authorId;
    private String name;
    private double price;

    public MBook(){
    }

    public MBook(String id, String authorId, String name, double price) {
        this.id = id;
        this.authorId = authorId;
        this.name = name;
        this.price = price;
    }

    public MBook(String id) {
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
