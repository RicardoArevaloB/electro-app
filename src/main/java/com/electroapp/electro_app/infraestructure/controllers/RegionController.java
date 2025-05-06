package com.electroapp.electro_app.infraestructure.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.electroapp.electro_app.application.services.IRegionService;
import com.electroapp.electro_app.domain.entities.Region;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/region")
public class RegionController {
    @Autowired
    private IRegionService regionService;

    @GetMapping
    public List<Region> list() {
        return regionService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Region> regionOptional = regionService.findById(id);
        if (regionOptional.isPresent()) {
            return ResponseEntity.ok(regionOptional.orElseThrow());
        } 
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Region region) {
        return ResponseEntity.status(201).body(regionService.save(region));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Region region) {
        Optional<Region> regionOptional = regionService.update(id, region);
        if (regionOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(regionOptional.orElseThrow());
        } 
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Region> regionOptional = regionService.delete(id);
        if (regionOptional.isPresent()) {
            return ResponseEntity.ok(regionOptional.orElseThrow());
        } 
        return ResponseEntity.notFound().build();
    }
    
}
