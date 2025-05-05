package com.electroapp.electro_app.infraestructure.repository.country;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.electroapp.electro_app.application.services.IRegionService;
import com.electroapp.electro_app.domain.entities.Region;



@Service
public class RegionsImpl implements IRegionService{
    @Autowired
    private RegionsRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Region> findAll() {
        return (List<Region>) repository.findAll();
    }

    @Override
    public Optional<Region> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Region save(Region region) {
        return repository.save(region);
    }

    @Override
    public Optional<Region> update(Long id, Region region) {
        Optional<Region> regionsOld = repository.findById(id);
        if (regionsOld.isPresent()) {
            Region regionDb = regionsOld.orElseThrow();
            regionDb.setName(region.getName());
            return Optional.of(repository.save(regionDb));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Region> delete(Long id) {
        Optional<Region> regionOptional = repository.findById(id);
        regionOptional.ifPresent(regionDb -> {
            repository.delete(regionDb);
        });
        return regionOptional;
    }
}
