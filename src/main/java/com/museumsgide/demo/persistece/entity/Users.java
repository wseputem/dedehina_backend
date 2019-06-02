package com.museumsgide.demo.persistece.entity;

import javax.persistence.*;

@Entity
public class Users {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String password;
/*
    @Column
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
