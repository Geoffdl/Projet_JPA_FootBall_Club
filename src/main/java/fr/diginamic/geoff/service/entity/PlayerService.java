package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.PlayerDao;
import fr.diginamic.geoff.dto.AppearanceDTO;
import fr.diginamic.geoff.dto.GameEventDTO;
import fr.diginamic.geoff.dto.GameLineupDTO;
import fr.diginamic.geoff.dto.PlayerDTO;
import fr.diginamic.geoff.entity.Player;
import fr.diginamic.geoff.utils.JpaEntityFactory;
import jakarta.persistence.EntityManager;

import java.util.HashMap;
import java.util.Map;

public class PlayerService
{

    private final PlayerDao playerDao;


    private final Map<Long, Player> mapOfExistingPlayers = new HashMap<>();

    public PlayerService(EntityManager em)
    {
        this.playerDao = new PlayerDao(em);
    }

    public Player findOrCreatePlayer(PlayerDTO dto)
    {
        Long sourceId = dto.getPlayerId();

        Player existing = mapOfExistingPlayers.get(sourceId);
        if (existing != null)
        {
            return existing;
        }

        Player player = JpaEntityFactory.createPlayer(dto);
        mapOfExistingPlayers.put(sourceId, player);
        playerDao.save(player);

        return player;
    }

    public void loadExistingPlayers()
    {
        for (Player player : playerDao.findAll())
        {
            mapOfExistingPlayers.put(player.getSourceId(), player);
        }
    }

    public Player findForGameEvent(GameEventDTO dto)
    {
        return mapOfExistingPlayers.get(dto.getPlayerId());
    }

    public Player findSecondaryPlayerForGameEvent(Long sourceId)
    {
        return mapOfExistingPlayers.get(sourceId);
    }

    public Player findForGameLineup(GameLineupDTO dto)
    {
        Long sourceId = dto.getPlayerId();
        return mapOfExistingPlayers.get(sourceId);
    }

    public Player findForAppearance(AppearanceDTO dto)
    {
        Long sourceId = dto.getPlayerId();
        return mapOfExistingPlayers.get(sourceId);
    }

    public void clearCache()
    {
        mapOfExistingPlayers.clear();
    }
}