package fr.diginamic.geoff.service;

import fr.diginamic.geoff.dao.AgentDao;
import fr.diginamic.geoff.dao.PlayerDao;
import fr.diginamic.geoff.dto.PlayerDTO;
import fr.diginamic.geoff.entity.*;
import fr.diginamic.geoff.utils.JpaEntityFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.Optional;
import java.util.function.Consumer;

public class PlayerService
{
    private final PlayerDao playerDao;
    private final AgentDao agentDao;
    private final JpaEntityFactory factory;
    private final EntityManager em;
    private final AgentService agentService;

    public PlayerService(PlayerDao playerDao, AgentDao agentDao, JpaEntityFactory factory, EntityManager em, AgentService agentService)
    {
        this.playerDao = playerDao;
        this.agentDao = agentDao;
        this.factory = factory;
        this.em = em;
        this.agentService = agentService;
    }


    /**
     * @param playerDTO
     * @return
     */
    public Player findOrCreatePlayer(PlayerDTO playerDTO)
    {
        Optional<Player> playerOptional = playerDao.findBySourceId(playerDTO.getPlayerId());

        if (playerOptional.isPresent())
        {
            return playerOptional.get();
        }

        Player player = factory.createPlayer(playerDTO);
        playerDao.save(player);

        return player;
    }

}