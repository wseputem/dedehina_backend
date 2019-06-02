package com.museumsgide.demo.persistece.repository;

import com.museumsgide.demo.persistece.entity.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsersRepository extends CrudRepository<Users, Long> {
    List<Users> findAllByName(String name);
    List<Users> findAllById(Long id);
    @Override
    List<Users> findAll();
}
