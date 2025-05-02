package com.electroapp.electro_app.infraestructure.repository.country;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.electroapp.electro_app.application.services.ICountryService;
import com.electroapp.electro_app.domain.entities.country;



@Service
public class CountryImpl implements ICountryService {
    @Autowired
    private CountryRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<country> findAll() {
        return  (List<country>) repository.findAll();
    }


    
    @Override
    public Optional<country> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public country save(country country) {
        return repository.save(country);
    }

    @Override
    public Optional<country> update(Long id, country country) {
        Optional<country> countryOld = repository.findById(id);
        if (countryOld.isPresent()){
            country countryDb = countryOld.orElseThrow();
            countryDb.setName(country.getName());
            return Optional.of(repository.save(countryDb));
        }
        return Optional.empty();
    }

    @Override
    public Optional<country> delete(Long id) {
        Optional<country> countryOptional = repository.findById(id);
        countryOptional.ifPresent(countryDb -> {
            repository.delete(countryDb);
        });
        return countryOptional;
    }


}
