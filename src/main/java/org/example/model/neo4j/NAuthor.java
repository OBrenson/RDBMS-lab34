package org.example.model.neo4j;

import org.example.model.Author;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity
public class NAuthor extends Author {

    @Id
    private String id;
    private String name;
    private int year;

    @Relationship(type="WROTE", direction = Relationship.INCOMING)
    private List<NBook> books;

    public NAuthor() {
    }

    public NAuthor(String id, String name, int year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public NAuthor(String id) {
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

    public List<NBook> getBooks() {
        return books;
    }

    public void setBooks(List<NBook> books) {
        this.books = books;
    }
}
