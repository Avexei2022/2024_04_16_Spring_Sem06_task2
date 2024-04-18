package ru.gb.group4546_5984.spring_sem06_hw_task02.controller.web.character_web_controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.group4546_5984.spring_sem06_hw_task02.Service.api.character_service.CharacterServiceApi;
import ru.gb.group4546_5984.spring_sem06_hw_task02.configuration.RickAndMortyApiConfig;
import ru.gb.group4546_5984.spring_sem06_hw_task02.domain.characters.CharacterInfo;
import ru.gb.group4546_5984.spring_sem06_hw_task02.domain.characters.CharacterResult;
import ru.gb.group4546_5984.spring_sem06_hw_task02.domain.characters.Characters;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
@Log
public class CharacterControllerWeb {
    private final CharacterServiceApi serviceApi;
    private final RickAndMortyApiConfig rickAndMortyApiConfig;


    @GetMapping("/")
    public String redirectToFirstPage() {
        return "redirect:/characters/page/1";
    }
    
    @GetMapping("/characters/page/{page}")
    public String getCharacters(@PathVariable("page") String page, Model model) {
        String url = rickAndMortyApiConfig.getCHARACTER_API() + "/?page=" + page;
        Characters allCharacters = serviceApi.getAllCharacters(url);
        CharacterInfo characterInfo = getCharacterInfo(allCharacters);
        List<CharacterResult> characterResultList = allCharacters.getResults();
        List<CharacterResult> characterResultListFromBasket = serviceApi.getAllFromBasket();
        model.addAttribute("character_info", characterInfo);
        model.addAttribute("characters_list", characterResultList);
        model.addAttribute("current_page", page);
        model.addAttribute("basket_size", characterResultListFromBasket.size());
        model.addAttribute("basket_cards", characterResultListFromBasket);
        return "index";
    }

    @GetMapping("/characters/add_to_basket/{id}/{page}")
    public String addToBasket(@PathVariable("id") Integer id, @PathVariable("page") String page) {
        String url = rickAndMortyApiConfig.getCHARACTER_API() + "/" + id;
        serviceApi.saveOneCharacterById(url);
        return "redirect:/characters/page/" + page;
    }

    @GetMapping("/characters/delete_from_basket/{id}/{page}")
    public String deleteFromBasket(@PathVariable("id") Integer id, @PathVariable("page") String page) {
        serviceApi.deleteById(id);
        return "redirect:/characters/page/" + page;
    }


    private CharacterInfo getCharacterInfo(Characters allCharacters) {
        CharacterInfo characterInfo = allCharacters.getInfo();
        if (characterInfo.getPrev() == null
                || characterInfo.getPrev().isEmpty()
                || !characterInfo.getPrev().contains("https://rickandmortyapi.com/api/character/?page=")) {
            characterInfo.setPrev("1");
        } else {
            characterInfo.setPrev(characterInfo
                    .getPrev()
                    .replace("https://rickandmortyapi.com/api/character/?page=", ""));
        }
        if (characterInfo.getNext() == null
                || characterInfo.getNext().isEmpty()
                || !characterInfo.getNext().contains("https://rickandmortyapi.com/api/character/?page=")) {
            characterInfo.setNext("1");
        } else {
            characterInfo.setNext(characterInfo
                    .getNext()
                    .replace("https://rickandmortyapi.com/api/character/?page=", ""));
        }
        return characterInfo;
    }


}
