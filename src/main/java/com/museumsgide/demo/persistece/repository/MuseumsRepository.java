package com.museumsgide.demo.persistece.repository;

import com.museumsgide.demo.persistece.entity.Museum;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MuseumsRepository extends CrudRepository<Museum, Long> {
    List<Museum> findAllByName(String name);
    List<Museum> findAllByCityId(Long id);
    List<Museum> findAllByCatMuseumsId(Long id);
    List<Museum> findAllByCatMuseums_Name(String name);
    List<Museum> findAllByCity_Name(String name);
    List<Museum> findAllByDescriptionContaining(String decsr);
    List<Museum> findAllByEntrancePriceIsGreaterThan(Long entrancePrice);
    List<Museum> findAllByEntrancePriceIsLessThan(Long entrancePrice);
    @Override
    List<Museum> findAll();
}
