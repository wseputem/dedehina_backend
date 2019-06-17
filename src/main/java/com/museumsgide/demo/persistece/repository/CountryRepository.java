package com.museumsgide.demo.persistece.repository;

import com.museumsgide.demo.persistece.entity.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Long> {
    @Override
    List<Country> findAll();
}
