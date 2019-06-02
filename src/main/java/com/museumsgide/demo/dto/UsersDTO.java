package com.museumsgide.demo.dto;

public class UsersDTO {
    private Long id;
    private String name;
    private String password;/*
    private Enum role;*/

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
/*
    public Enum getRole() {
        return role;
    }

    public void setRole(Enum role) {
        this.role = role;
    }*/
}
