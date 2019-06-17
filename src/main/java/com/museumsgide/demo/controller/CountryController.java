package com.museumsgide.demo.controller;

import com.museumsgide.demo.dto.CountryDTO;
import com.museumsgide.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/country")
public class CountryController {
    private CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public CountryDTO create(@RequestBody CountryDTO countryDTO){
        return countryService.save(countryDTO);
    }

    @DeleteMapping(path = "/delete/id:{id}")
    public  String delete(@PathVariable Long id){
        return countryService.delete(id);
    }

    @PostMapping(path = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity edit(@RequestBody CountryDTO countryDTO) {
        CountryDTO result = countryService.update(countryDTO);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {
            return ResponseEntity.ok(result);
        }
    }

    @GetMapping(path = "/search/all")
    public List<CountryDTO> searchAll() {
        return countryService.searchByAll();
    }
}
