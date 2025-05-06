package com.electroapp.electro_app.infraestructure.repository.country;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electroapp.electro_app.domain.entities.City;

public interface cityRepository extends JpaRepository<City, Long> {

}
