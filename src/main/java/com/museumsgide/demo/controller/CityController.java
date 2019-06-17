package com.museumsgide.demo.controller;

import com.museumsgide.demo.dto.CityDTO;
import com.museumsgide.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/city")
public class CityController {
    private CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public CityDTO create(@RequestBody CityDTO cityDTO){
        return cityService.save(cityDTO);
    }

    @DeleteMapping(path = "/delete/id:{id}")
    public  String delete(@PathVariable Long id){
        return cityService.delete(id);
    }

    @PostMapping(path = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity edit(@RequestBody CityDTO cityDTO) {
        CityDTO result = cityService.update(cityDTO);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {
            return ResponseEntity.ok(result);
        }
    }

    @GetMapping(path = "/search/all")
    public List<CityDTO> searchAll() {
        return cityService.searchByAll();
    }
}
