package com.museumsgide.demo.dto;

public class SponsorsDTO {
    private Long id;
    private String name;
    private Long exhibitionsId;

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

    public Long getExhibitionsId() {
        return exhibitionsId;
    }

    public void setExhibitionsId(Long exhibitionsId) {
        this.exhibitionsId = exhibitionsId;
    }
}
