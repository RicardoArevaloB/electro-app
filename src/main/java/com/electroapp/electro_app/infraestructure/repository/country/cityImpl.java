package com.electroapp.electro_app.infraestructure.repository.country;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.electroapp.electro_app.application.services.ICityService;


@Service
public class cityImpl implements ICityService{
    @Autowired
    private cityRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<City> findAll() {
        return (List<City>) repository.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public City save(City city) {
        return repository.save(city);
    }

    @Override
    public Optional<City> update(Long id, City city) {
        Optional<City> cityOld = repository.findById(id);
        if (cityOld.isPresent()) {
            City cityDb = cityOld.orElseThrow();
            cityDb.setName(city.getName());
            return Optional.of(repository.save(cityDb));
        }
        return Optional.empty();

    }

    @Override
    public Optional<City> delete(Long id) {
        Optional<City> cityOptional = repository.findById(id);
        cityOptional.ifPresent(cityDb -> {
            repository.delete(cityDb);
        });
        return cityOptional;
    }

}
