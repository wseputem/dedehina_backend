package com.museumsgide.demo.persistece.repository;

import com.museumsgide.demo.persistece.entity.Branch;
import org.springframework.data.repository.CrudRepository;

public interface BranchRepository extends CrudRepository<Branch, Long> {
}
