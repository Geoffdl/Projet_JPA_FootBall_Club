package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.GameEventDao;
import fr.diginamic.geoff.dto.GameEventDTO;
import fr.diginamic.geoff.entity.GameEvent;
import fr.diginamic.geoff.entity.Player;
import fr.diginamic.geoff.utils.JpaEntityFactory;
import jakarta.persistence.EntityManager;

import java.util.HashMap;
import java.util.Map;

public class GameEventService
{
    private final GameEventDao gameEventDao;
    private final Map<String, GameEvent> mapOfExisting = new HashMap<>();

    public GameEventService(EntityManager em)
    {
        this.gameEventDao = new GameEventDao(em);

    }

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
        Long playerAssist = dto.getPlayerAssistId();
        if (playerAssist != null)
        {
            Player playerIn = playerService.findSecondaryPlayerForGameEvent(playerAssist);
            gameEvent.setPlayerIn(playerIn);
        }

        gameEventDao.save(gameEvent);
        mapOfExisting.put(gameEvent.getSourceId(), gameEvent);
        return gameEvent;
    }


    public void clear()
    {
        mapOfExisting.clear();
    }

    public void loadExisting()
    {
        for (GameEvent event : gameEventDao.findAll())
        {
            mapOfExisting.put(event.getSourceId(), event);
        }
    }
}