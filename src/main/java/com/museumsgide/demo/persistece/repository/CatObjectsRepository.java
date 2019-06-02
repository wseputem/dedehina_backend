package com.museumsgide.demo.persistece.repository;

import com.museumsgide.demo.persistece.entity.CatObject;
import org.springframework.data.repository.CrudRepository;

public interface CatObjectsRepository extends CrudRepository<CatObject, Long> {
}
