package ru.gb.group4546_5984.spring_sem06_hw_task02.controller.api.episode_api_controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.group4546_5984.spring_sem06_hw_task02.Service.api.episode_service.EpisodeServiceApi;
import ru.gb.group4546_5984.spring_sem06_hw_task02.domain.episodes.Episode;

//Проверка свагером http://localhost:8080/swagger-ui/index.html
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EpisodeControllerApi {
    private final EpisodeServiceApi service;

    @GetMapping("/episodes")
    public ResponseEntity<Episode> getEpisodes() {
        Episode allEpisodes = service.getAllEpisodes();
        return new ResponseEntity<>(allEpisodes, HttpStatus.OK);
    }

}
