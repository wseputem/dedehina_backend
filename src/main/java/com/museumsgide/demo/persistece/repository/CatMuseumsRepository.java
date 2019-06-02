package com.museumsgide.demo.persistece.repository;

import com.museumsgide.demo.persistece.entity.CatMuseums;
import org.springframework.data.repository.CrudRepository;

public interface CatMuseumsRepository extends CrudRepository<CatMuseums, Long> {
}
