package com.museumsgide.demo.dto;

import java.util.Date;

public class ExhibitionsDTO {

    private Long id;
    private String name;
    private Date startDate;
    private Date completionDate;
    private Long catExhibitionsId;
    private Long branchId;

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

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public Long getCatExhibitionsId() {
        return catExhibitionsId;
    }

    public void setCatExhibitionsId(Long catExhibitionsId) {
        this.catExhibitionsId = catExhibitionsId;
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
}
