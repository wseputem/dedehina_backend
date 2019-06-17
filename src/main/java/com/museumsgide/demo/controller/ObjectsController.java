package com.museumsgide.demo.controller;

import com.museumsgide.demo.dto.ExhibitionsDTO;
import com.museumsgide.demo.dto.ObjectsDTO;
import com.museumsgide.demo.service.ObjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/objects")
public class ObjectsController {
    private ObjectsService objectsService;

    @Autowired
    public ObjectsController(ObjectsService objectsService) {
        this.objectsService = objectsService;
    }

    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public ObjectsDTO createMuseum(@RequestBody ObjectsDTO objectsDTO){
        return objectsService.save(objectsDTO);
    }

    @DeleteMapping(path = "/delete/id:{id}")
    public  String delete(@PathVariable Long id){
        return objectsService.delete(id);
    }

    @PostMapping(path = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity editNews(@RequestBody ObjectsDTO objectsDTO) {
        ObjectsDTO result = objectsService.update(objectsDTO);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {
            return ResponseEntity.ok(result);
        }
    }

    @GetMapping(path = "/search/all")
    public List<ObjectsDTO> searchAll() {
        return objectsService.searchByAll();
    }

    @GetMapping(path = "/search/name:{name}")
    public List<ObjectsDTO> searchByName(@PathVariable String name) {
        return objectsService.searchByName(name);
    }

    @GetMapping(path = "/search/date:{date}")
    public List<ObjectsDTO> searchByDate(@PathVariable Date date) {
        return objectsService.searchByDate(date);
    }

    @GetMapping(path = "/search/catObjectName:{name}")
    public List<ObjectsDTO> searchByCatObjectName(@PathVariable String name) {
        return objectsService.searchByCatObject_Name(name);
    }

    @GetMapping(path = "/search/authorName:{name}")
    public List<ObjectsDTO> searchByAuthorName(@PathVariable String name) {
        return objectsService.searchByAuthor_Name(name);
    }

    @GetMapping(path = "/search/exhibitionsByObjectName:{name}")
    public List<ExhibitionsDTO> searchExhibitionsByObjectName(@PathVariable String name) {
        return objectsService.searchExhibitionsByObjectName(name);
    }

}
