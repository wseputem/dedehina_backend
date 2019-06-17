package com.museumsgide.demo.shared.dto;

import java.util.List;

public class ObjectsDTO {

    private Long id;
    private String name;
    private Long date;
    private Long catObjectsId;
    private Long authorId;
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

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Long getCatObjectsId() {
        return catObjectsId;
    }

    public void setCatObjectsId(Long catObjectsId) {
        this.catObjectsId = catObjectsId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
