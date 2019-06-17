package com.museumsgide.demo.shared.dto;

import java.util.Date;

public class OwnersDTO {
    private Long id;
    private String name;
    private Date dateOfReg;
    private Long catOwnersId;

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

    public Date getDateOfReg() {
        return dateOfReg;
    }

    public void setDateOfReg(Date dateOfReg) {
        this.dateOfReg = dateOfReg;
    }

    public Long getCatOwnersId() {
        return catOwnersId;
    }

    public void setCatOwnersId(Long catOwnersId) {
        this.catOwnersId = catOwnersId;
    }
}
