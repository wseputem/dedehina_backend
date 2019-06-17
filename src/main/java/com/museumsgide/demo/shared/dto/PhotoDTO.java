package com.museumsgide.demo.shared.dto;

public class PhotoDTO {
    private Long id;
    private String photo;
    private Long objectsId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Long getObjectsId() {
        return objectsId;
    }

    public void setObjectsId(Long objectsId) {
        this.objectsId = objectsId;
    }
}
