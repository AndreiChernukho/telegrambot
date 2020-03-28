package com.company.telegrambot.city.controller;

import com.company.telegrambot.city.entity.City;
import com.company.telegrambot.city.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для работы с городами
 */
@RestController
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping(value = "/cities")
    public List<City> getCities() {
        return cityService.getCities();
    }

    @PostMapping(value = "/city/create")
    public void create(@RequestBody City city) {
        cityService.create(city);
    }

    @PutMapping(value = "/city/update")
    public void update(@RequestBody City city) {
        cityService.update(city);
    }

    @GetMapping(value = "/city/get/{id}")
    public City get(@PathVariable("id") String id) {
        return cityService.get(id);
    }

    @DeleteMapping(value = "/city/delete/{id}")
    public void delete(@PathVariable("id") String id) {
        cityService.delete(id);
    }
}
