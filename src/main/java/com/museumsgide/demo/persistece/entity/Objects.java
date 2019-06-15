package com.museumsgide.demo.persistece.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Objects {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private Long date;

    @ManyToOne
    private Author author;

    @ManyToOne
    private CatObject catObject;

    @ManyToMany(mappedBy = "objects")
    private List<Exhibitions> exhibitions;

    public List<Exhibitions> getExhibitions() {
        return exhibitions;
    }

    public void setExhibitions(List<Exhibitions> exhibitions) {
        this.exhibitions = exhibitions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
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
