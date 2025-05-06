package com.electroapp.electro_app.infraestructure.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.electroapp.electro_app.application.services.ICityService;
import com.electroapp.electro_app.domain.entities.City;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/city")
public class CityController {
    @Autowired
    private ICityService cityService;

    @GetMapping
    public List<City> list() {
        return cityService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<City> cityOptional = cityService.findById(id);
        if (cityOptional.isPresent()) {
            return ResponseEntity.ok(cityOptional.orElseThrow());
        } 
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody City city) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cityService.save(city));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody City city) {
        Optional<City> cityOptional = cityService.update(id, city);
        if (cityOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(cityOptional.orElseThrow());
        } 
        return ResponseEntity.notFound().build();
    }

    
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<City> cityOptional = cityService.delete(id);
        if (cityOptional.isPresent()) {
            return ResponseEntity.ok(cityOptional.orElseThrow());
        } 
        return ResponseEntity.notFound().build();
    }

}
