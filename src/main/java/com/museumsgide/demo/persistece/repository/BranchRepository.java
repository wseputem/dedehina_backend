package com.museumsgide.demo.persistece.repository;

import com.museumsgide.demo.persistece.entity.Branch;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BranchRepository extends CrudRepository<Branch, Long> {
    Branch findAllByMuseum_Id(Long id);

    @Override
    List<Branch> findAll();
}
