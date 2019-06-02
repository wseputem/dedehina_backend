package com.museumsgide.demo.persistece.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Objects {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private Date date;

    @ManyToOne
    private Author author;

    @ManyToOne
    private CatObject catObject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public CatObject getCatObject() {
        return catObject;
    }

    public void setCatObject(CatObject catObject) {
        this.catObject = catObject;
    }
}
