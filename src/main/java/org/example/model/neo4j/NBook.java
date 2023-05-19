package org.example.model.neo4j;

import org.example.model.Book;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class NBook extends Book {

    @Id
    private String id;
    @EndNode
    private NAuthor author;

    private String name;
    private double price;

    public NBook(){
    }

    public NBook(String id, NAuthor author, String name, double price) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public NAuthor getAuthor() {
        return author;
    }

    public void setAuthor(NAuthor author) {
        this.author = author;
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
