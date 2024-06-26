package ru.gb.group4546_5984.spring_sem06_hw_task02.domain.locations;

import lombok.Data;
import ru.gb.group4546_5984.spring_sem06_hw_task02.domain.characters.CharacterInfo;
import ru.gb.group4546_5984.spring_sem06_hw_task02.domain.characters.CharacterResult;

import java.util.List;

/**
 * Объединенная информация о локациях
 * в соответствии с документациией Rick and Morty
 */
@Data
public class Location {
    LocationInfo info;
    List<LocationResult> results;
}
