package com.museumsgide.demo.persistece.repository;

import com.museumsgide.demo.persistece.entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
