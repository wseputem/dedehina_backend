package com.museumsgide.demo.persistece.repository;

import com.museumsgide.demo.persistece.entity.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {
}
