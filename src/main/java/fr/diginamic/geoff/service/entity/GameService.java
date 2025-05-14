package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.GameDao;
import fr.diginamic.geoff.dto.AppearanceDTO;
import fr.diginamic.geoff.dto.GameDTO;
import fr.diginamic.geoff.dto.GameEventDTO;
import fr.diginamic.geoff.dto.GameLineupDTO;
import fr.diginamic.geoff.entity.Game;
import fr.diginamic.geoff.utils.JpaEntityFactory;
import jakarta.persistence.EntityManager;

import java.util.HashMap;
import java.util.Map;

/**
 * This class orchestrates daos and mappers to generate entities and persist them in the database
 * It implements a caching method using a sourceId from the data and an instance of the object, either created or fetched from the database if existing
 */
public class GameService
{
    private final GameDao gameDao;

    private final Map<Long, Game> mapOfExisting = new HashMap<>();

    public GameService(EntityManager em)
    {
        this.gameDao = new GameDao(em);
    }

    /**
     * Takes an instance of DTO, compares it to existing entity, if present in base return existing, if not create a new one from the DTO
     *
     * @param dto raw source entity
     * @return jpa entity
     */
    public Game findOrCreateGame(GameDTO dto)
    {
        Long sourceId = dto.getGameId();
        Game existing = mapOfExisting.get(sourceId);
        if (existing != null)
        {
            return existing;
        }

        Game game = JpaEntityFactory.createGame(dto);
        mapOfExisting.put(sourceId, game);
        gameDao.save(game);
        return game;
    }

    /**
     * Takes an instance of DTO, compares it to existing entity, if present in base return existing
     *
     * @param dto raw source entity
     * @return jpa entity
     */
    public Game findForGameEvent(GameEventDTO dto)
    {
        return mapOfExisting.get(dto.getGameId());
    }

    /**
     * Takes an instance of DTO, compares it to existing entity, if present in base return existing
     *
     * @param dto raw source entity
     * @return jpa entity
     */
    public Game findForGameLineup(GameLineupDTO dto)
    {
        Long sourceId = dto.getGameId();
        return mapOfExisting.get(sourceId);
    }

    /**
     * Takes an instance of DTO, compares it to existing entity, if present in base return existing
     *
     * @param dto raw source entity
     * @return jpa entity
     */
    public Game findForAppearance(AppearanceDTO dto)
    {
        Long sourceId = dto.getGameId();
        return mapOfExisting.get(sourceId);
    }

    /**
     * loads caching hashmap
     */
    public void loadExistingGames()
    {
        mapOfExisting.clear();
        for (Game game : gameDao.findAll())
        {
            mapOfExisting.put(game.getSourceId(), game);
        }
    }

    /**
     * clear cache
     */
    public void clearCache() {mapOfExisting.clear();}
}