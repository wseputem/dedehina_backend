package com.museumsgide.demo.controller;

import com.museumsgide.demo.shared.dto.OrganizerDTO;
import com.museumsgide.demo.service.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/organizer")
public class OrganizerController {
    private OrganizerService organizerService;

    @Autowired
    public OrganizerController(OrganizerService organizerService) {
        this.organizerService = organizerService;
    }


    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public OrganizerDTO create(@RequestBody OrganizerDTO organizerDTO){
        return organizerService.save(organizerDTO);
    }

    @DeleteMapping(path = "/delete/id:{id}")
    public  String delete(@PathVariable Long id){
        return organizerService.delete(id);
    }

    @PostMapping(path = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity edit(@RequestBody OrganizerDTO organizerDTO) {
        OrganizerDTO result = organizerService.update(organizerDTO);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {
            return ResponseEntity.ok(result);
        }
    }

    @GetMapping(path = "/search/all")
    public List<OrganizerDTO> searchAll() {
        return organizerService.searchByAll();
    }
}
