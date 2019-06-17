package com.museumsgide.demo.controller;


import com.museumsgide.demo.shared.dto.AdminDTO;
import com.museumsgide.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/admin")
public class AdminController {
    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public AdminDTO create(@RequestBody AdminDTO adminDTO){
        return adminService.save(adminDTO);
    }

    @DeleteMapping(path = "/delete/id:{id}")
    public  String delete(@PathVariable Long id){
        return adminService.delete(id);
    }

    @PostMapping(path = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity edit(@RequestBody AdminDTO adminDTO) {
        AdminDTO result = adminService.update(adminDTO);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {
            return ResponseEntity.ok(result);
        }
    }

    @GetMapping(path = "/search/all")
    public List<AdminDTO> searchAll() {
        return adminService.searchByAll();
    }
}
