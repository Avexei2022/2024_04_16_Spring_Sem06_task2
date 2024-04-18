package ru.gb.group4546_5984.spring_sem06_hw_task02.domain.characters;

import lombok.Data;

@Data
public class CharacterInfo {
    private Integer count;
    private Integer pages;
    private String next;
    private String prev;
}
