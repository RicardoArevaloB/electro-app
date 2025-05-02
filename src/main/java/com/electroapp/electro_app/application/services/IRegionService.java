package com.electroapp.electro_app.application.services;

import java.util.List;
import java.util.Optional;

import com.electroapp.electro_app.domain.entities.Region;

public interface IRegionService {
    List<Region> findAll();

    Optional<Region> findById(Long id);

    Region save(Region region);

    Region update(Region region, Long id);
    
    void delete(Long id);
}
