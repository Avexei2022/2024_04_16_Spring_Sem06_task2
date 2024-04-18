package ru.gb.group4546_5984.spring_sem06_hw_task02.Service.api.character_service;

import ru.gb.group4546_5984.spring_sem06_hw_task02.domain.characters.CharacterResult;
import ru.gb.group4546_5984.spring_sem06_hw_task02.domain.characters.Characters;

import java.util.List;

public interface CharacterServiceApi {
    public Characters getAllCharacters(String url);
    public void saveOneCharacterById(String url);
    public List<CharacterResult> getAllFromBasket();
    public void deleteById(Integer id);
}
