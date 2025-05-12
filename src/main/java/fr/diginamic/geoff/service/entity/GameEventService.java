package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.GameEventDao;
import fr.diginamic.geoff.dto.GameEventDTO;
import fr.diginamic.geoff.entity.GameEvent;
import fr.diginamic.geoff.entity.Player;
import fr.diginamic.geoff.utils.JpaEntityFactory;

import java.util.Optional;

public class GameEventService
{
    private final GameEventDao gameEventDao;
    private final JpaEntityFactory factory;

    public GameEventService(GameEventDao gameEventDao, JpaEntityFactory factory)
    {
        this.gameEventDao = gameEventDao;
        this.factory = factory;
    }

    public GameEvent findOrCreate(GameEventDTO dto, PlayerService playerService)
    {
        Optional<GameEvent> gameEventOptional = gameEventDao.findBySourceId(dto.getGameEventId());
        if (gameEventOptional.isPresent())
        {
            return gameEventOptional.get();
        }

        GameEvent gameEvent = factory.createGameEvent(dto);
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
        return gameEvent;
    }


}