package ru.gb.group4546_5984.spring_sem06_hw_task02.domain.characters;

import lombok.Data;

import java.util.List;

@Data
public class Characters {
    CharacterInfo info;
    List<CharacterResult> results;
}
