package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.GameAppearanceDao;
import fr.diginamic.geoff.dto.AppearanceDTO;
import fr.diginamic.geoff.entity.Game;
import fr.diginamic.geoff.entity.GameAppearance;
import fr.diginamic.geoff.entity.Player;
import fr.diginamic.geoff.utils.JpaEntityFactory;
import jakarta.persistence.EntityManager;

import java.util.HashMap;
import java.util.Map;

/**
 * This class orchestrates dao and mappers to generate entities and persist them in the database
 * It implements a caching method using a sourceId from the data and an instance of the object, either created or fetched from the database if existing
 */
public class GameAppearanceService
{
    private final GameAppearanceDao gameAppearanceDao;
    private final Map<Long, GameAppearance> mapOfExisting = new HashMap<>();

    public GameAppearanceService(EntityManager em)
    {
        this.gameAppearanceDao = new GameAppearanceDao(em);

    }

    /**
     * Takes an instance of DTO, compares it to existing entity, if present in base return existing, if not create a new one from the DTO
     *
     * @param dto raw source entity
     * @return jpa entity
     */
    public GameAppearance findOrCreate(AppearanceDTO dto, Game game, Player player)
    {
        Long sourceId = dto.getAppearanceId();
        GameAppearance existing = mapOfExisting.get(sourceId);
        if (existing != null)
        {
            return existing;
        }

        GameAppearance gameAppearance = JpaEntityFactory.createGameAppearance(dto, game, player);
        mapOfExisting.put(gameAppearance.getSourceId(), gameAppearance);
        return gameAppearance;
    }

    /**
     * loads caching hashmap
     */
    public void loadExisting()
    {
        for (GameAppearance appearance : gameAppearanceDao.findAll())
        {
            mapOfExisting.put(appearance.getSourceId(), appearance);
        }
    }

    public void clear()
    {
        mapOfExisting.clear();
    }
}