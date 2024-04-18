package ru.gb.group4546_5984.spring_sem06_hw_task02.Service.api.character_service;

import ru.gb.group4546_5984.spring_sem06_hw_task02.domain.characters.CharacterResult;
import ru.gb.group4546_5984.spring_sem06_hw_task02.domain.characters.Characters;

import java.util.List;

/**
 * Интерфей сервиса героев
 */
public interface CharacterServiceApi {
    /**
     * Получить с сайта Rick and Morty страницу со списком героев
     * @param url ссылка на сайт Rick and Morty в соответствии с документацией
     * @return Страница со списком героев
     */
    public Characters getAllCharacters(String url);

    /**
     * Метод сохранения выбранной прльзователем карточки в базе данных
     * @param url ссылка
     */
    public void saveOneCharacterById(String url);

    /**
     * Получить все карточки героев из базы данных
     * @return список карточек героев
     */
    public List<CharacterResult> getAllFromBasket();

    /**
     * Удалить карточку героя из базы данных
     * @param id Id героя
     */
    public void deleteById(Integer id);
}
