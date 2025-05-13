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

public class GameService
{
    private final GameDao gameDao;
    private final Map<Long, Game> mapOfExisting = new HashMap<>();

    public GameService(EntityManager em)
    {
        this.gameDao = new GameDao(em);
    }

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

    public Game findForGameEvent(GameEventDTO dto)
    {
        return mapOfExisting.get(dto.getGameId());
    }

    public Game findForGameLineup(GameLineupDTO dto)
    {
        Long sourceId = dto.getGameId();
        return mapOfExisting.get(sourceId);
    }

    public Game findForAppearance(AppearanceDTO dto)
    {
        Long sourceId = dto.getGameId();
        return mapOfExisting.get(sourceId);
    }

    public void loadExistingGames()
    {
        mapOfExisting.clear();
        for (Game game : gameDao.findAll())
        {
            mapOfExisting.put(game.getSourceId(), game);
        }
    }

    public void clearCache() {mapOfExisting.clear();}
}