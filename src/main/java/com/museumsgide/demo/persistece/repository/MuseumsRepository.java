package com.museumsgide.demo.persistece.repository;

import com.museumsgide.demo.persistece.entity.Museum;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MuseumsRepository extends CrudRepository<Museum, Long> {
    List<Museum> findAllByName(String name);
    List<Museum> findAllByCityId(Long id);
    List<Museum> findAllByCatMuseumsId(Long id);
    @Override
    List<Museum> findAll();
}
