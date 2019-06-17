package com.museumsgide.demo.persistece.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Sponsors {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "exhibitions_sponsors",
            joinColumns = @JoinColumn(name="sponsors_id"),
            inverseJoinColumns = @JoinColumn(name="exhibitions_id")
    )
    private List<Exhibitions> exhibitions;

    public List<Exhibitions> getExhibitions() {
        return exhibitions;
    }

    public void setExhibitions(List<Exhibitions> exhibitions) {
        this.exhibitions = exhibitions;
    }

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
}
