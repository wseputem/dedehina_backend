package com.museumsgide.demo.persistece.repository;

import com.museumsgide.demo.persistece.entity.Sponsors;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SponsorsRepository extends CrudRepository<Sponsors, Long> {
    @Override
    List<Sponsors> findAll();
}
