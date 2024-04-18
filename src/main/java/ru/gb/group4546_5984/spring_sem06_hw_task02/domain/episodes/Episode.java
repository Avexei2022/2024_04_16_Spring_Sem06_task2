package ru.gb.group4546_5984.spring_sem06_hw_task02.domain.episodes;

import lombok.Data;


import java.util.List;

/**
 * Объединенная информация об эпизодах
 * в соответствии с документацией Rick and Morty
 */
@Data
public class Episode {
    EpisodeInfo info;
    List<EpisodeResult> results;
}
