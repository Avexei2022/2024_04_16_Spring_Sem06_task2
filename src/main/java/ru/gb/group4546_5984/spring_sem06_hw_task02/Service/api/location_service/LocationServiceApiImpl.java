package ru.gb.group4546_5984.spring_sem06_hw_task02.Service.api.location_service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.gb.group4546_5984.spring_sem06_hw_task02.configuration.RickAndMortyApiConfig;
import ru.gb.group4546_5984.spring_sem06_hw_task02.domain.locations.Location;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log
public class LocationServiceApiImpl implements LocationServiceApi {
    private final RestTemplate template;
    private final HttpHeaders headers;
    private final RickAndMortyApiConfig rickAndMortyApiConfig;

    /**
     * Получить список всех локаций с рессурса Rick and Morty
     * @return
     */
    @Override
    public Location getAllLocations() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Location> responce = template.exchange(rickAndMortyApiConfig.getLOCATION_API(), HttpMethod.GET,entity, Location.class);

        return responce.getBody();
    }
}
