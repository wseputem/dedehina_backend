package com.museumsgide.demo.persistece.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Exhibitions {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private Date startDate;

    @Column
    private Date completionDate;

    @ManyToOne
    private CatExhibitions catExhibitions;

    @ManyToOne
    private Branch branch;

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

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public CatExhibitions getCatExhibitions() {
        return catExhibitions;
    }

    public void setCatExhibitions(CatExhibitions catExhibitions) {
        this.catExhibitions = catExhibitions;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
