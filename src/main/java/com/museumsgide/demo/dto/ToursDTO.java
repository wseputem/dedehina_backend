package com.museumsgide.demo.dto;

public class ToursDTO {
    private Long id;
    private String name;
    private Long price;
    private Long duration;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getExhibitionsId() {
        return exhibitionsId;
    }

    public void setExhibitionsId(Long exhibitionsId) {
        this.exhibitionsId = exhibitionsId;
    }
}
