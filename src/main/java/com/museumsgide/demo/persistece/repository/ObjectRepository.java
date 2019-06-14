package com.museumsgide.demo.persistece.repository;

import com.museumsgide.demo.persistece.entity.Objects;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ObjectRepository extends CrudRepository<Objects, Long> {
    List<Objects> findAllByName(String name);
    @Override
    List<Objects> findAll();
}
