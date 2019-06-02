package com.museumsgide.demo.persistece.repository;

import com.museumsgide.demo.persistece.entity.Tours;
import org.springframework.data.repository.CrudRepository;

public interface ToursRepository extends CrudRepository<Tours, Long> {
}
