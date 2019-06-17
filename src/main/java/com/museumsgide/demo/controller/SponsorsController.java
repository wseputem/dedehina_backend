package com.museumsgide.demo.controller;

import com.museumsgide.demo.shared.dto.SponsorsDTO;
import com.museumsgide.demo.service.SponsorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/sponsors")
public class SponsorsController {
    private SponsorsService sponsorsService;

    @Autowired
    public SponsorsController(SponsorsService sponsorsService) {
        this.sponsorsService = sponsorsService;
    }

    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public SponsorsDTO create(@RequestBody SponsorsDTO sponsorsDTO){
        return sponsorsService.save(sponsorsDTO);
    }

    @DeleteMapping(path = "/delete/id:{id}")
    public  String delete(@PathVariable Long id){
        return sponsorsService.delete(id);
    }

    @PostMapping(path = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity edit(@RequestBody SponsorsDTO sponsorsDTO) {
        SponsorsDTO result = sponsorsService.update(sponsorsDTO);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {
            return ResponseEntity.ok(result);
        }
    }

    @GetMapping(path = "/search/all")
    public List<SponsorsDTO> searchAll() {
        return sponsorsService.searchByAll();
    }
}
