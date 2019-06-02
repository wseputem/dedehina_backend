package com.museumsgide.demo.persistece.repository;

import com.museumsgide.demo.persistece.entity.CatOwners;
import org.springframework.data.repository.CrudRepository;

public interface CatOwnersRepository extends CrudRepository<CatOwners, Long> {
}
