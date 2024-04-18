package ru.gb.group4546_5984.spring_sem06_hw_task02.Service.api.episode_service;

import ru.gb.group4546_5984.spring_sem06_hw_task02.domain.episodes.Episode;

/**
 * Интерфейс эпизодов
 */
public interface EpisodeServiceApi {

    /**
     * Получить список эпизодов
     * @return эпизоды
     */
    public Episode getAllEpisodes();
}
