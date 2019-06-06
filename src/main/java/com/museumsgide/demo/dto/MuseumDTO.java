package com.museumsgide.demo.dto;

public class MuseumDTO {
    private Long id;
    private String name;
    private Long cityId;
    private Long catMuseumsId;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getCatMuseumsId() {
        return catMuseumsId;
    }

    public void setCatMuseumsId(Long catMuseumsId) {
        this.catMuseumsId = catMuseumsId;
    }
}