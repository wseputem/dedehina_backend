package com.museumsgide.demo.controller;

import com.museumsgide.demo.shared.dto.MuseumDTO;
import com.museumsgide.demo.service.MuseumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/museum")
public class MuseumController {
    private MuseumService museumService;

    @Autowired
    public MuseumController(MuseumService museumService) {
        this.museumService = museumService;
    }

    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public MuseumDTO createMuseum(@RequestBody MuseumDTO museumDTO){
        return museumService.save(museumDTO);
    }

    @DeleteMapping(path = "/delete/id:{id}")
    public  String delete(@PathVariable Long id){
        return museumService.delete(id);
    }

    @PostMapping(path = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity editNews(@RequestBody MuseumDTO museumDTO) {
        MuseumDTO result = museumService.update(museumDTO);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {
            return ResponseEntity.ok(result);
        }
    }

    @GetMapping(path = "/search/all")
    public List<MuseumDTO> searchAll() {
        return museumService.searchByAll();
    }

    @GetMapping(path = "/search/name:{name}")
    public List<MuseumDTO> searchByName(@PathVariable String name) {
        return museumService.searchByName(name);
    }

    @GetMapping(path = "/search/catMuseumsId:{id}")
    public List<MuseumDTO> searchByCatMuseumsId(@PathVariable Long id) {
        return museumService.searchByCatMuseumsId(id);
    }

    @GetMapping(path = "/search/catMuseumsName:{name}")
    public List<MuseumDTO> searchByCatMuseumsName(@PathVariable String name) {
        return museumService.searchByCatMuseumsName(name);
    }

    @GetMapping(path = "/search/cityId:{id}")
    public List<MuseumDTO> searchByCityId(@PathVariable Long id) {
        return museumService.searchByCityId(id);
    }

    @GetMapping(path = "/search/cityName:{name}")
    public List<MuseumDTO> searchByCityName(@PathVariable String name) {
        return museumService.searchByCityName(name);
    }

    @GetMapping(path = "/search/description:{descr}")
    public List<MuseumDTO> searchByDescription(@PathVariable String descr) {
        return museumService.searchByDescription(descr);
    }

    @GetMapping(path = "/search/entrancePriceIsGreaterThan:{entrancePrice}")
    public List<MuseumDTO> searchByEntrancePriceIsGreaterThan(@PathVariable Long entrancePrice) {
        return museumService.searchByEntrancePriceIsGreaterThan(entrancePrice);
    }

    @GetMapping(path = "/search/entrancePriceIsLessThan:{entrancePrice}")
    public List<MuseumDTO> searchByEntrancePriceIsLessThan(@PathVariable Long entrancePrice) {
        return museumService.searchByEntrancePriceIsLessThan(entrancePrice);
    }

}
