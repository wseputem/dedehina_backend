package com.museumsgide.demo.persistece.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Museum {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @ManyToOne
    private City city;

    @ManyToOne
    private CatMuseums catMuseums;

    @Column
    private String description;

    @Column
    private Integer entrancePrice;

    public Integer getEntrancePrice() {
        return entrancePrice;
    }

    public void setEntrancePrice(Integer entrancePrice) {
        this.entrancePrice = entrancePrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CatMuseums getCatMuseums() {
        return catMuseums;
    }

    public void setCatMuseums(CatMuseums catMuseums) {
        this.catMuseums = catMuseums;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
