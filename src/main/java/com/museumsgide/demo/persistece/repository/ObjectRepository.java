package com.museumsgide.demo.persistece.repository;

import com.museumsgide.demo.persistece.entity.Objects;
import org.springframework.data.repository.CrudRepository;

public interface ObjectRepository extends CrudRepository<Objects, Long> {
}
