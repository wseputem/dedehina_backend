package com.museumsgide.demo.persistece.entity;


import javax.persistence.*;

@Entity
public class Tours {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private Long price;

    @Column
    private Long duration;

    @ManyToOne
    private Exhibitions exhibitions;

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

    public Exhibitions getExhibitions() {
        return exhibitions;
    }

    public void setExhibitions(Exhibitions exhibitions) {
        this.exhibitions = exhibitions;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
