package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.GameLineupDao;
import fr.diginamic.geoff.dto.GameLineupDTO;
import fr.diginamic.geoff.entity.Game;
import fr.diginamic.geoff.entity.GameLineup;
import fr.diginamic.geoff.entity.Player;
import fr.diginamic.geoff.utils.JpaEntityFactory;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class GameLineupService
{

    private final GameLineupDao gameLineupDao;

    public GameLineupService(EntityManager em)
    {
        this.gameLineupDao = new GameLineupDao(em);
    }

    public GameLineup findOrCreate(GameLineupDTO dto, Game game, Player player)
    {

        Optional<GameLineup> gameLineupOptional = gameLineupDao.findBySourceId(dto.getGameLineUpsId());
        if (gameLineupOptional.isPresent())
        {
            return gameLineupOptional.get();
        }
        GameLineup gameLineup = JpaEntityFactory.createGameLineup(dto, game, player);
        return gameLineup;
    }
}