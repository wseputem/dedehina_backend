package com.museumsgide.demo.persistece.repository;

import com.museumsgide.demo.persistece.entity.Organizer;
import org.springframework.data.repository.CrudRepository;

public interface OrganizerRepository extends CrudRepository<Organizer, Long> {
}
