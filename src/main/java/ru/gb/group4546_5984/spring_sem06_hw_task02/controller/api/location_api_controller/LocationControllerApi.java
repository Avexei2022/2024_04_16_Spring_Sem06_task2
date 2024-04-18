package ru.gb.group4546_5984.spring_sem06_hw_task02.controller.api.location_api_controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.group4546_5984.spring_sem06_hw_task02.Service.api.location_service.LocationServiceApi;
import ru.gb.group4546_5984.spring_sem06_hw_task02.domain.locations.Location;

//Проверка свагером http://localhost:8080/swagger-ui/index.html
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LocationControllerApi {
    private final LocationServiceApi service;

    @GetMapping("/locations")
    public ResponseEntity<Location> getLocations() {
        Location allLocations = service.getAllLocations();
        return new ResponseEntity<>(allLocations, HttpStatus.OK);
    }

}
