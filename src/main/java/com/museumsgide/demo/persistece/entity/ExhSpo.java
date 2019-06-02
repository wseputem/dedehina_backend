package com.museumsgide.demo.persistece.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ExhSpo {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Exhibitions exhibitions;

    @ManyToOne
    private Sponsors sponsors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sponsors getSponsors() {
        return sponsors;
    }

    public void setSponsors(Sponsors sponsors) {
        this.sponsors = sponsors;
    }

    public Exhibitions getExhibitions() {
        return exhibitions;
    }

    public void setExhibitions(Exhibitions exhibitions) {
        this.exhibitions = exhibitions;
    }
}
