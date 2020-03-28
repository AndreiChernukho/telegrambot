package com.company.telegrambot.city.service;

import com.company.telegrambot.city.entity.City;
import com.company.telegrambot.city.repository.CityRepository;
import com.google.common.collect.Streams;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Реализация {@link CityService}
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<City> getCities() {
        return Streams.stream(repository.findAll()).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public City get(String id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("City not found with id: %s ", id)));
    }

    @Override
    public Optional<String> getDescription(String name) {
        String cityName = Strings.trimToNull(name);

        return cityName != null
                ? repository.findByNameIgnoreCase(cityName).map(City::getDescription)
                : Optional.empty();
    }

    @Transactional
    @Override
    public void delete(String id) {
        City city = repository.
                findById(id).
                orElseThrow(() -> new IllegalStateException(String.format("City with id '%s' does not exist", id)));

        repository.delete(city);
    }

    @Transactional
    @Override
    public void create(City city) {
        city.setId(null);
        save(city);
    }

    @Transactional
    @Override
    public void update(City city) {
        repository.findById(city.getId()).orElseThrow(() ->
                new IllegalStateException(String.format("City with id '%s' does not exist", city.getId())));

        save(city);
    }

    private void save(City city) {
        repository.save(city);
    }
}
