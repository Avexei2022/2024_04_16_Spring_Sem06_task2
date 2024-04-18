package ru.gb.group4546_5984.spring_sem06_hw_task02.domain.episodes;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Карточка эпизода в соответствии с документацией Rick and Morty
 */
@Data
public class EpisodeResult {
    private Integer id;
    private String name;
    private String air_date;
    private String episode;
    private List<String> characters;
    private String gender;
    private String url;
    private Date created;
}
