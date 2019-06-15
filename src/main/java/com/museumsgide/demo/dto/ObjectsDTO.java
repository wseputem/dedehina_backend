package com.museumsgide.demo.dto;

import java.util.Date;
import java.util.List;

public class ObjectsDTO {

    private Long id;
    private String name;
    private Date date;
    private Long catObjectsId;
    private Long authorId;
    private List<ExhibitionsDTO> exhibitionsDTOList;

    public List<ExhibitionsDTO> getExhibitionsDTOList() {
        return exhibitionsDTOList;
    }

    public void setExhibitionsDTOList(List<ExhibitionsDTO> exhibitionsDTOList) {
        this.exhibitionsDTOList = exhibitionsDTOList;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
