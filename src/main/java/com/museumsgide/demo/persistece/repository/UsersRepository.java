package com.museumsgide.demo.persistece.repository;

import com.museumsgide.demo.persistece.entity.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsersRepository extends CrudRepository<Users, Long> {
    Users findAllById(Long id);
    List<Users> findAllByName(String name);
    Users findByNameAndPassword(String name, String password);
    @Override
    List<Users> findAll();
}
