package com.company.telegrambot.city.repository;

import com.company.telegrambot.city.entity.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Репозиторий.
 */
@Repository
public interface CityRepository extends CrudRepository<City, String> {

    /**
     * Возвращает описание города по его названию.
     *
     * @param name название города
     * @return описание города по его названию
     */
    Optional<City> findByNameIgnoreCase(String name);
}
