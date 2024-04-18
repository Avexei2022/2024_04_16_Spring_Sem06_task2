package ru.gb.group4546_5984.spring_sem06_hw_task02.domain.episodes;

import lombok.Data;

/**
 * Информационная часть о странице эпизодов
 * в соответствии с документацией Rick and Morty
 */
@Data
public class EpisodeInfo {
    private Integer count;
    private Integer pages;
    private String next;
    private String prev;
}
