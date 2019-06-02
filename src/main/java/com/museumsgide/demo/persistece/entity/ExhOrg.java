package com.museumsgide.demo.persistece.entity;

import javax.persistence.*;

@Entity
public class ExhOrg {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Exhibitions exhibitions;

    @ManyToOne
    private Organizer organizer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public Exhibitions getExhibitions() {
        return exhibitions;
    }

    public void setExhibitions(Exhibitions exhibitions) {
        this.exhibitions = exhibitions;
    }
}
