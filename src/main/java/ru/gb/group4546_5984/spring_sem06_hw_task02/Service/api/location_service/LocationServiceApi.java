package ru.gb.group4546_5984.spring_sem06_hw_task02.Service.api.location_service;

import ru.gb.group4546_5984.spring_sem06_hw_task02.domain.locations.Location;

/**
 * Интерфей сервиса локаций
 */
public interface LocationServiceApi {

    /**
     * Получить список всех локаций
     * @return
     */
    public Location getAllLocations();
}
