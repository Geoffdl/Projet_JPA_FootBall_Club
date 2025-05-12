package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.PlayerDao;
import fr.diginamic.geoff.dto.AppearanceDTO;
import fr.diginamic.geoff.dto.GameEventDTO;
import fr.diginamic.geoff.dto.GameLineupDTO;
import fr.diginamic.geoff.dto.PlayerDTO;
import fr.diginamic.geoff.entity.Player;
import fr.diginamic.geoff.utils.JpaEntityFactory;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class PlayerService
{
    private final PlayerDao playerDao;


    public PlayerService(EntityManager em)
    {
        this.playerDao = new PlayerDao(em);
    }


    /**
     * @param dto
     * @return
     */
    public Player findOrCreatePlayer(PlayerDTO dto)
    {
        Optional<Player> playerOptional = playerDao.findBySourceId(dto.getPlayerId());

        if (playerOptional.isPresent())
        {
            return playerOptional.get();
        }

        Player player = JpaEntityFactory.createPlayer(dto);
        playerDao.save(player);

        return player;
    }

    public Player findForGameEvent(GameEventDTO dto)
    {
        Optional<Player> playerOptional = playerDao.findBySourceId(dto.getPlayerId());
        return playerOptional.orElse(null);
    }

    public Player findSecondaryPlayerForGameEvent(Long sourceId)
    {
        Optional<Player> playerOptional = playerDao.findBySourceId(sourceId);
        return playerOptional.orElse(null);
    }

    public Player findForGameLineup(GameLineupDTO dto)
    {
        Optional<Player> playerOptional = playerDao.findBySourceId(dto.getPlayerId());
        return playerOptional.orElse(null);
    }

    public Player findForAppearance(AppearanceDTO dto)
    {
        Optional<Player> playerOptional = playerDao.findBySourceId(dto.getPlayerId());
        return playerOptional.orElse(null);
    }
}