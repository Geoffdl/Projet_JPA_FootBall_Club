package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.GameLineupDao;
import fr.diginamic.geoff.dto.GameLineupDTO;
import fr.diginamic.geoff.entity.Game;
import fr.diginamic.geoff.entity.GameLineup;
import fr.diginamic.geoff.entity.Player;
import fr.diginamic.geoff.utils.JpaEntityFactory;
import jakarta.persistence.EntityManager;

import java.util.HashMap;
import java.util.Map;

/**
 * This class orchestrates daos and mappers to generate entities and persist them in the database
 * It implements a caching method using a sourceId from the data and an instance of the object, either created or fetched from the database if existing
 */
public class GameLineupService
{

    private final GameLineupDao gameLineupDao;

    private final Map<String, GameLineup> mapOfExisting = new HashMap<>();

    public GameLineupService(EntityManager em)
    {
        this.gameLineupDao = new GameLineupDao(em);
    }

    public GameLineup findOrCreate(GameLineupDTO dto, Game game, Player player)
    {
        String sourceId = dto.getGameLineUpsId();
        GameLineup existing = mapOfExisting.get(sourceId);
        if (existing != null)
        {
            return existing;
        }

        GameLineup gameLineup = JpaEntityFactory.createGameLineup(dto, game, player);
        mapOfExisting.put(gameLineup.getSourceId(), gameLineup);
        return gameLineup;
    }

    public void loadExisting()
    {
        for (GameLineup gameLineup : gameLineupDao.findAll())
        {
            mapOfExisting.put(gameLineup.getSourceId(), gameLineup);
        }
    }

    public void clear()
    {
        mapOfExisting.clear();
    }
}