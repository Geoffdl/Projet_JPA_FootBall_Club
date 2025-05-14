package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.GameEventDao;
import fr.diginamic.geoff.dto.GameEventDTO;
import fr.diginamic.geoff.entity.GameEvent;
import fr.diginamic.geoff.entity.Player;
import fr.diginamic.geoff.utils.JpaEntityFactory;
import jakarta.persistence.EntityManager;

import java.util.HashMap;
import java.util.Map;

/**
 * This class orchestrates daos and mappers to generate entities and persist them in the database
 * It implements a caching method using a sourceId from the data and an instance of the object, either created or fetched from the database if existing
 */
public class GameEventService
{
    private final GameEventDao gameEventDao;

    private final Map<String, GameEvent> mapOfExisting = new HashMap<>();

    public GameEventService(EntityManager em)
    {
        this.gameEventDao = new GameEventDao(em);

    }

    /**
     * Takes an instance of DTO, compares it to existing entity, if present in base return existing, if not create a new one from the DTO
     *
     * @param dto raw source entity
     * @return jpa entity
     */
    public GameEvent findOrCreate(GameEventDTO dto, PlayerService playerService)
    {
        String sourceId = dto.getGameEventId();
        GameEvent existing = mapOfExisting.get(sourceId);
        if (existing != null)
        {
            return existing;
        }
        GameEvent gameEvent = JpaEntityFactory.createGameEvent(dto);
        Long playerInId = dto.getPlayerInId();
        if (playerInId != null)
        {
            Player playerIn = playerService.findSecondaryPlayerForGameEvent(playerInId);
            gameEvent.setPlayerIn(playerIn);
        }
        Long playerAssistId = dto.getPlayerAssistId();
        if (playerAssistId != null)
        {
            Player playerAssist = playerService.findSecondaryPlayerForGameEvent(playerAssistId);
            gameEvent.setPlayerAssist(playerAssist);
        }

        gameEventDao.save(gameEvent);
        mapOfExisting.put(gameEvent.getSourceId(), gameEvent);
        return gameEvent;
    }

    /**
     * clear cache
     */
    public void clear()
    {
        mapOfExisting.clear();
    }

    /**
     * loads caching hashmap
     */
    public void loadExisting()
    {
        for (GameEvent event : gameEventDao.findAll())
        {
            mapOfExisting.put(event.getSourceId(), event);
        }
    }
}