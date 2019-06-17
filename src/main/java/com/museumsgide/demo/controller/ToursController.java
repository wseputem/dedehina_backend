package com.museumsgide.demo.controller;

import com.museumsgide.demo.dto.ToursDTO;
import com.museumsgide.demo.service.ToursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/tours")
public class ToursController {
    private ToursService toursService;

    @Autowired
    public ToursController(ToursService toursService) {
        this.toursService = toursService;
    }


    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public ToursDTO create(@RequestBody ToursDTO toursDTO){
        return toursService.save(toursDTO);
    }

    @DeleteMapping(path = "/delete/id:{id}")
    public  String delete(@PathVariable Long id){
        return toursService.delete(id);
    }

    @PostMapping(path = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity edit(@RequestBody ToursDTO toursDTO) {
        ToursDTO result = toursService.update(toursDTO);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {
            return ResponseEntity.ok(result);
        }
    }

    @GetMapping(path = "/search/all")
    public List<ToursDTO> searchAll() {
        return toursService.searchByAll();
    }
}
