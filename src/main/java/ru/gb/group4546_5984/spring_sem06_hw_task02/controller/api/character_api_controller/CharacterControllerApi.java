package ru.gb.group4546_5984.spring_sem06_hw_task02.controller.api.character_api_controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.group4546_5984.spring_sem06_hw_task02.Service.api.character_service.CharacterServiceApi;
import ru.gb.group4546_5984.spring_sem06_hw_task02.configuration.RickAndMortyApiConfig;
import ru.gb.group4546_5984.spring_sem06_hw_task02.domain.characters.Characters;

/**
 * Контроллер API
 * Проверка свагером http://localhost:8080/swagger-ui/index.html
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Log
public class CharacterControllerApi {
    private final CharacterServiceApi service;
    private final RickAndMortyApiConfig rickAndMortyApiConfig;

    /**
     * Принудительная пересылка со страницы /api на загрузку первой страницы с рессурса
     * @return
     */
    @GetMapping("/")
    public String redirectToFirstPage() {
        return "redirect:/characters/page/1";
    }

    /**
     *
     * @param page
     * @return
     */
    @GetMapping("/characters/page/{page}")
    public ResponseEntity<Characters> getCharacters(@PathVariable("page") String page) {
        String url = rickAndMortyApiConfig.getCHARACTER_API() + "/?page=" + page;
        Characters allCharacters = service.getAllCharacters(url);
        return new ResponseEntity<>(allCharacters, HttpStatus.OK);
    }

}
