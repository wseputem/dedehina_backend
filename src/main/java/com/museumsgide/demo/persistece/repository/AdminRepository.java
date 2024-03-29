package com.museumsgide.demo.persistece.repository;

import com.museumsgide.demo.persistece.entity.Admin;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdminRepository extends CrudRepository<Admin, Long> {
    Admin findAllByUsers_Id(Long id);

    @Override
    List<Admin> findAll();
}
