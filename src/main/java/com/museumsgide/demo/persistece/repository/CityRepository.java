package com.museumsgide.demo.persistece.repository;

import com.museumsgide.demo.persistece.entity.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long> {
}
