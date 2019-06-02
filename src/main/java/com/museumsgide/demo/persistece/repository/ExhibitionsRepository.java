package com.museumsgide.demo.persistece.repository;

import com.museumsgide.demo.persistece.entity.CatExhibitions;
import com.museumsgide.demo.persistece.entity.Exhibitions;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ExhibitionsRepository extends CrudRepository<Exhibitions, Long> {
    List<Exhibitions> findAllByName(String name);
    List<Exhibitions> findAllByStartDate(Date date);
    List<Exhibitions> findAllByCompletionDate(Date date);
    List<Exhibitions> findAllByCatExhibitionsId(Long id);
    List<Exhibitions> findAllByBranchId(Long id);

    List<Exhibitions> findAllByCatExhibitionsName(String name);


    @Override
    List<Exhibitions> findAll();
}
