package com.museumsgide.demo.persistece.repository;

import com.museumsgide.demo.persistece.entity.City;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityRepository extends CrudRepository<City, Long> {
    @Override
    List<City> findAll();
}
