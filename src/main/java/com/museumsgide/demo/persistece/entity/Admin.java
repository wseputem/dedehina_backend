package com.museumsgide.demo.persistece.entity;

import javax.persistence.*;

@Entity
public class Admin {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Users users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
