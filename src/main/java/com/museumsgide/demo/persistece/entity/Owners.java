package com.museumsgide.demo.persistece.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Owners {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private Date dateOfReg;

    @ManyToOne
    private CatOwners catOwners;

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

    public CatOwners getCatOwners() {
        return catOwners;
    }

    public void setCatOwners(CatOwners catOwners) {
        this.catOwners = catOwners;
    }

    public Date getDateOfReg() {
        return dateOfReg;
    }

    public void setDateOfReg(Date dateOfReg) {
        this.dateOfReg = dateOfReg;
    }
}
