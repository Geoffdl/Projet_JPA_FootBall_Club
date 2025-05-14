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

/**
 * This class orchestrates Dao and mappers to generate entities and persist them in the database
 * It implements a caching method using a sourceId from the data and an instance of the object, either created or fetched from the database if existing
 */
public class PlayerService
{

    private final PlayerDao playerDao;


    private final Map<Long, Player> mapOfExistingPlayers = new HashMap<>();

    public PlayerService(EntityManager em)
    {
        this.playerDao = new PlayerDao(em);
    }

    /**
     * Takes an instance of DTO, compares it to existing entity, if present in base return existing, if not create a new one from the DTO
     *
     * @param dto raw source entity
     * @return jpa entity
     */
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

    /**
     * loads caching hashmap
     */
    public void loadExistingPlayers()
    {
        for (Player player : playerDao.findAll())
        {
            mapOfExistingPlayers.put(player.getSourceId(), player);
        }
    }

    /**
     * Takes an instance of DTO, compares it to existing entity, if present in base return existing
     *
     * @param dto raw source entity
     * @return jpa entity
     */
    public Player findForGameEvent(GameEventDTO dto)
    {
        return mapOfExistingPlayers.get(dto.getPlayerId());
    }

    /**
     * Takes an instance of DTO, compares it to existing entity, if present in base return existing
     *
     * @param sourceId raw source data matching sourceId
     * @return jpa entity
     */
    public Player findSecondaryPlayerForGameEvent(Long sourceId)
    {
        return mapOfExistingPlayers.get(sourceId);
    }

    /**
     * Takes an instance of DTO, compares it to existing entity, if present in base return existing
     *
     * @param dto raw source entity
     * @return jpa entity
     */
    public Player findForGameLineup(GameLineupDTO dto)
    {
        Long sourceId = dto.getPlayerId();
        return mapOfExistingPlayers.get(sourceId);
    }

    /**
     * Takes an instance of DTO, compares it to existing entity, if present in base return existing
     *
     * @param dto raw source entity
     * @return jpa entity
     */
    public Player findForAppearance(AppearanceDTO dto)
    {
        Long sourceId = dto.getPlayerId();
        return mapOfExistingPlayers.get(sourceId);
    }

    /**
     * clear cache
     */
    public void clearCache()
    {
        mapOfExistingPlayers.clear();
    }
}