package com.electroapp.electro_app.application.services;

import java.util.List;
import java.util.Optional;

import com.electroapp.electro_app.domain.entities.country;

public interface ICountryService {
    List<country> findAll();

    Optional<country> findById(Long id);

    country save(country country);
    
    Optional<country> update(Long id, country country);

    Optional<country> delete(Long id);
}
