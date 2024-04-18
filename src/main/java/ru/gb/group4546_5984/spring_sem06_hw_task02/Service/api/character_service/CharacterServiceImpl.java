package ru.gb.group4546_5984.spring_sem06_hw_task02.Service.api.character_service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.gb.group4546_5984.spring_sem06_hw_task02.Service.db.character_service_db.CharacterRepository;
import ru.gb.group4546_5984.spring_sem06_hw_task02.configuration.RickAndMortyApiConfig;
import ru.gb.group4546_5984.spring_sem06_hw_task02.domain.characters.CharacterResult;
import ru.gb.group4546_5984.spring_sem06_hw_task02.domain.characters.Characters;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log
public class CharacterServiceImpl implements CharacterServiceApi {
    private final CharacterRepository characterRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders headers;

    @Override
    public Characters getAllCharacters(String url) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpMethod method = HttpMethod.GET;
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        Class<Characters> responseType = Characters.class;
        log.info("URI - " + url);
        ResponseEntity<Characters> response = restTemplate.exchange(url, method, requestEntity, responseType);
        return response.getBody();
    }

    @Override
    public void saveOneCharacterById(String url) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpMethod method = HttpMethod.GET;
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        Class<CharacterResult> responseType = CharacterResult.class;
        log.info("URI - " + url);
        CharacterResult characterResult = restTemplate.exchange(url, method, requestEntity, responseType).getBody();
        if (characterResult != null) characterRepository.save(characterResult);
    }

    @Override
    public List<CharacterResult> getAllFromBasket() {
        return characterRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        characterRepository.deleteById(id);
    }
}
