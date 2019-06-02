package com.museumsgide.demo.persistece.repository;

import com.museumsgide.demo.persistece.entity.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotoRepository extends CrudRepository<Photo, Long> {
}
