package com.museumsgide.demo.controller;

import com.museumsgide.demo.dto.ObjectsDTO;
import com.museumsgide.demo.service.ObjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
