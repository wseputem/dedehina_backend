package com.museumsgide.demo.persistece.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
public class Users {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    @Email
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
