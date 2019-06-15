package com.museumsgide.demo.persistece.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "author")
    private List<Objects> objects;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Objects> getObjects() {
        return objects;
    }

    public void setObjects(List<Objects> objects) {
        this.objects = objects;
    }
}
