package com.museumsgide.demo.controller;

import com.museumsgide.demo.shared.dto.ExhibitionsDTO;
import com.museumsgide.demo.shared.dto.ObjectsDTO;
import com.museumsgide.demo.service.ExhibitionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/exhibitions")
public class ExhibitionsController {
    private ExhibitionsService exhibitionsService;

    @Autowired
    public ExhibitionsController(ExhibitionsService exhibitionsService) {
        this.exhibitionsService = exhibitionsService;
    }

    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public ExhibitionsDTO createExhibitions(@RequestBody ExhibitionsDTO exhibitionsDTO){
        return exhibitionsService.save(exhibitionsDTO);
    }

    @DeleteMapping(path = "/delete/id:{id}")
    public  String delete(@PathVariable Long id){
        return exhibitionsService.delete(id);
    }

    @PostMapping(path = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity editExhibitions(@RequestBody ExhibitionsDTO exhibitionsDTO) {
        ExhibitionsDTO result = exhibitionsService.update(exhibitionsDTO);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {
            return ResponseEntity.ok(result);
        }
    }

    @GetMapping(path = "/search/all")
    public List<ExhibitionsDTO> searchAll() {
        return exhibitionsService.searchByAll();
    }

    @GetMapping(path = "/search/name:{name}")
    public List<ExhibitionsDTO> searchByName(@PathVariable String name) {
        return exhibitionsService.searchByName(name);
    }

    @GetMapping(path = "/search/startDate:{date}")
    public List<ExhibitionsDTO> searchByStartDate(@PathVariable Date date) {
        return exhibitionsService.searchByStartDate(date);
    }

    @GetMapping(path = "/search/completionDate:{date}")
    public List<ExhibitionsDTO> searchByCompletionDate(@PathVariable Date date) {
        return exhibitionsService.searchByCompletionDate(date);
    }

    @GetMapping(path = "/search/branchId:{id}")
    public List<ExhibitionsDTO> searchByBranchId(@PathVariable Long id) {
        return exhibitionsService.searchByBranchId(id);
    }

    @GetMapping(path = "/search/catExhibitionsId:{id}")
    public List<ExhibitionsDTO> searchByCatExhibitionsId(@PathVariable Long id) {
        return exhibitionsService.searchByCatExhibitionsId(id);
    }

    @GetMapping(path = "/search/catExhibitionsName:{name}")
    public List<ExhibitionsDTO> searchByCatExhibitionsName(@PathVariable String name) {
        return exhibitionsService.searchByCatExhibitionsName(name);
    }
    @GetMapping(path = "/search/objectsByExhibitionsName:{name}")
    public List<ObjectsDTO> searchObjectsByExhibitionsName(@PathVariable String name) {
        return exhibitionsService.searchObjectsByExhibitionsName(name);
    }
}
