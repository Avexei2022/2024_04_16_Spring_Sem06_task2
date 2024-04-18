package ru.gb.group4546_5984.spring_sem06_hw_task02.Service.db.character_service_db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.group4546_5984.spring_sem06_hw_task02.domain.characters.CharacterResult;

/**
 * Репозиторий Героев (Корзина)
 */
@Repository
public interface CharacterRepository extends JpaRepository<CharacterResult, Integer> {
}
