package com.museumsgide.demo.persistece.repository;

import com.museumsgide.demo.persistece.entity.Tours;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ToursRepository extends CrudRepository<Tours, Long> {
    @Override
    List<Tours> findAll();
}
