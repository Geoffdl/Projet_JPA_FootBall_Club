package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.GameDao;
import fr.diginamic.geoff.dto.GameDTO;
import fr.diginamic.geoff.dto.GameEventDTO;
import fr.diginamic.geoff.dto.GameLineupDTO;
import fr.diginamic.geoff.entity.Game;
import fr.diginamic.geoff.utils.JpaEntityFactory;

import java.util.Optional;

public class GameService
{
    private final GameDao gameDao;
    private final JpaEntityFactory factory;

    public GameService(GameDao gameDao, JpaEntityFactory factory)
    {
        this.gameDao = gameDao;
        this.factory = factory;
    }

    public Game findOrCreateGame(GameDTO dto)
    {
        Optional<Game> gameOptional = gameDao.findBySourceId(dto.getGameId());

        if (gameOptional.isPresent())
        {
            return gameOptional.get();
        }

        Game game = factory.createGame(dto);
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
}