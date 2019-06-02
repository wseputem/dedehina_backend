package com.museumsgide.demo.controller;

import com.museumsgide.demo.dto.MuseumDTO;
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
    public List<MuseumDTO> searchByName(@PathVariable Long id) {
        return museumService.searchByCatMuseumsId(id);
    }

    @GetMapping(path = "/search/cityId:{id}")
    public List<MuseumDTO> searchByCityId(@PathVariable Long id) {
        return museumService.searchByCityId(id);
    }
}
