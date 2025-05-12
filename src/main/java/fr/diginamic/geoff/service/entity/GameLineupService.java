package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.GameLineupDao;
import fr.diginamic.geoff.dto.GameLineupDTO;
import fr.diginamic.geoff.entity.Game;
import fr.diginamic.geoff.entity.GameLineup;
import fr.diginamic.geoff.entity.Player;
import fr.diginamic.geoff.utils.JpaEntityFactory;

import java.util.Optional;

public class GameLineupService
{

    private final GameLineupDao gameLineupDao;
    private final JpaEntityFactory factory;

    public GameLineupService(GameLineupDao gameLineupDao, JpaEntityFactory factory)
    {
        this.gameLineupDao = gameLineupDao;
        this.factory = factory;
    }

    public GameLineup findOrCreate(GameLineupDTO dto, Game game, Player player)
    {

        Optional<GameLineup> gameLineupOptional = gameLineupDao.findBySourceId(dto.getGameLineUpsId());
        if (gameLineupOptional.isPresent())
        {
            return gameLineupOptional.get();
        }
        GameLineup gameLineup = factory.createGameLineup(dto, game, player);
        return gameLineup;
    }
}