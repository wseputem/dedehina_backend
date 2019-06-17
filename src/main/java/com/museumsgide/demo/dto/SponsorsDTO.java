package com.museumsgide.demo.dto;

import java.util.List;

public class SponsorsDTO {
    private Long id;
    private String name;
    private List<Long> exhibitionIds;

    public List<Long> getExhibitionIds() {
        return exhibitionIds;
    }

    public void setExhibitionIds(List<Long> exhibitionIds) {
        this.exhibitionIds = exhibitionIds;
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
