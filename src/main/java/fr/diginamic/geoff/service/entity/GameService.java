package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.GameDao;
import fr.diginamic.geoff.dto.AppearanceDTO;
import fr.diginamic.geoff.dto.GameDTO;
import fr.diginamic.geoff.dto.GameEventDTO;
import fr.diginamic.geoff.dto.GameLineupDTO;
import fr.diginamic.geoff.entity.Game;
import fr.diginamic.geoff.utils.JpaEntityFactory;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class GameService
{
    private final GameDao gameDao;

    public GameService(EntityManager em)
    {
        this.gameDao = new GameDao(em);
    }

    public Game findOrCreateGame(GameDTO dto)
    {
        Optional<Game> gameOptional = gameDao.findBySourceId(dto.getGameId());

        if (gameOptional.isPresent())
        {
            return gameOptional.get();
        }

        Game game = JpaEntityFactory.createGame(dto);
        gameDao.save(game);

        return game;
    }

    public Game findForGameEvent(GameEventDTO dto)
    {
        Optional<Game> gameOptional = gameDao.findBySourceId(dto.getGameId());
        return gameOptional.orElse(null);
    }

    public Game findForGameLineup(GameLineupDTO dto)
    {
        Optional<Game> gameOptional = gameDao.findBySourceId(dto.getGameId());
        return gameOptional.orElse(null);
    }

    public Game findForAppearance(AppearanceDTO dto)
    {
        Optional<Game> gameOptional = gameDao.findBySourceId(dto.getGameId());
        return gameOptional.orElse(null);
    }
}