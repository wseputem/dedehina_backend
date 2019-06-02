package com.museumsgide.demo.persistece.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ExhObject {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Exhibitions exhibitions;

    @ManyToOne
    private Objects objects;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Objects getObjects() {
        return objects;
    }

    public void setObjects(Objects objects) {
        this.objects = objects;
    }

    public Exhibitions getExhibitions() {
        return exhibitions;
    }

    public void setExhibitions(Exhibitions exhibitions) {
        this.exhibitions = exhibitions;
    }
}
