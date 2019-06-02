package com.museumsgide.demo.persistece.entity;

import javax.persistence.*;

@Entity
public class Photo {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String photo;

    @ManyToOne
    private Objects objects;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Objects getObjects() {
        return objects;
    }

    public void setObjects(Objects objects) {
        this.objects = objects;
    }
}
