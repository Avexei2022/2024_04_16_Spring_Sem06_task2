package ru.gb.group4546_5984.spring_sem06_hw_task02.Service.api.episode_service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.gb.group4546_5984.spring_sem06_hw_task02.configuration.RickAndMortyApiConfig;
import ru.gb.group4546_5984.spring_sem06_hw_task02.domain.episodes.Episode;

import java.util.List;


/**
 * Сервис эпизодов
 */
@Service
@RequiredArgsConstructor
@Log
public class EpisodeServiceApiImpl implements EpisodeServiceApi {
    private final RestTemplate template;
    private final HttpHeaders headers;
    private final RickAndMortyApiConfig rickAndMortyApiConfig;

    /**
     * Получить список эпизодов
     * @return эпизоды
     */
    @Override
    public Episode getAllEpisodes() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Episode> responce = template.exchange(rickAndMortyApiConfig.getEPISODE_API(), HttpMethod.GET,entity, Episode.class);

        return responce.getBody();
    }
}
