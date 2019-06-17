package com.museumsgide.demo.dto;

import sun.plugin.javascript.navig.Array;

import java.util.ArrayList;
import java.util.List;

public class MuseumDTO {
    private Long id;
    private String name;
    private Long cityId;
    private Long catMuseumsId;
    private String description;
    private Long entrancePrice;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getEntrancePrice() {
        return entrancePrice;
    }

    public void setEntrancePrice(Long entrancePrice) {
        this.entrancePrice = entrancePrice;
    }

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