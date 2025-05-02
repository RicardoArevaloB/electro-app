package com.electroapp.electro_app.infraestructure.repository.country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.electroapp.electro_app.domain.entities.country;

@Repository
public interface CountryRepository extends JpaRepository<country, Long> {
    
    
} 


