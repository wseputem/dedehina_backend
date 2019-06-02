package com.museumsgide.demo.persistece.repository;

import com.museumsgide.demo.persistece.entity.Owners;
import org.springframework.data.repository.CrudRepository;

public interface OwnersRepository extends CrudRepository<Owners, Long> {
}
