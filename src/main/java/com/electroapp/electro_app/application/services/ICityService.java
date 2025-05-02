package com.electroapp.electro_app.application.services;

import java.util.List;
import java.util.Optional;

import com.electroapp.electro_app.domain.entities.City;

public interface ICityService {
    List<City> findAll();

    Optional<City> findById(Long id);

    City save(City city);

    City update(City city, Long id);

    void delete(Long id);
}
