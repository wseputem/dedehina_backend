package com.museumsgide.demo.persistece.repository;

import com.museumsgide.demo.persistece.entity.Organizer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrganizerRepository extends CrudRepository<Organizer, Long> {
    @Override
    List<Organizer> findAll();
}
