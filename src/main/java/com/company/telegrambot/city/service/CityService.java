package com.company.telegrambot.city.service;

import com.company.telegrambot.city.entity.City;

import java.util.List;
import java.util.Optional;

/**
 * Сервис для работы с городами.
 */
public interface CityService {

    /**
     * Возвращает список городов.
     *
     * @return список городов
     */
    List<City> getCities();

    /**
     * Возвращает город по идентификатору.
     *
     * @param id идентификатор
     * @return город
     */
    City get(String id);

    /**
     * Возвращает описание города по его названию.
     *
     * @param name название города
     * @return описание города
     */
    Optional<String> getDescription(String name);

    /**
     * Удаляет город по идентификатору.
     *
     * @param id идентификатор города
     */
    void delete(String id);

    /**
     * Сохраняет новый город.
     *
     * @param city город
     */
    void create(City city);

    /**
     * Обновляет данные города.
     *
     * @param city город
     */
    void update(City city);
}
