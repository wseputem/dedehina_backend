package com.museumsgide.demo.controller;

import com.museumsgide.demo.dto.UsersDTO;
import com.museumsgide.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UsersController {
    private UsersService usersService;

    /*@Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }*/

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public UsersDTO createUsers(@RequestBody UsersDTO usersDTO){
        return usersService.create(usersDTO);
    }

    @DeleteMapping(path = "/delete/id:{id}")
    public  String deleteUsers(@PathVariable Long id){
        return usersService.delete(id);
    }

    @PostMapping(path = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity editUsers(@RequestBody UsersDTO usersDTO) {
        UsersDTO result = usersService.update(usersDTO);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {
            return ResponseEntity.ok(result);
        }
    }

    @PostMapping(path = "/aut", consumes = "application/json", produces = "application/json")
    public ResponseEntity aut(@RequestBody UsersDTO usersDTO) {
        Long id = usersService.searchForAut(usersDTO);
        if (id == null) {   
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {
            return ResponseEntity.ok(id);
        }
    }


    @GetMapping(path = "/search/all")
    public List<UsersDTO> searchAll() {
        return usersService.searchByAll();
    }

    @GetMapping(path = "/search/name:{name}")
    public List<UsersDTO> searchByName(@PathVariable String name) {
        return usersService.searchByName(name);
    }
}
