package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.StadiumDao;
import fr.diginamic.geoff.dto.ClubDTO;
import fr.diginamic.geoff.dto.GameDTO;
import fr.diginamic.geoff.entity.Stadium;
import fr.diginamic.geoff.utils.JpaEntityFactory;
import jakarta.persistence.EntityManager;

import java.util.HashMap;
import java.util.Map;

/**
 * This class orchestrates Dao and mappers to generate entities and persist them in the database
 * It implements a caching method using a sourceId from the data and an instance of the object, either created or fetched from the database if existing
 */
public class StadiumService
{
    private final StadiumDao stadiumDao;

    private final Map<String, Stadium> mapOfExistingStadiums = new HashMap<>();

    public StadiumService(EntityManager em)
    {
        this.stadiumDao = new StadiumDao(em);
    }

    public Stadium findOrCreateStadium(GameDTO dto)
    {
        String sourceName = dto.getStadiumName();
        Stadium existing = mapOfExistingStadiums.get(sourceName);
        if (existing != null)
        {
            return existing;
        }
        Stadium stadium = JpaEntityFactory.createStadium(dto);
        mapOfExistingStadiums.put(sourceName, stadium);
        stadiumDao.save(stadium);

        return stadium;
    }

    public Stadium findOrCreateStadiumFromClubDTO(ClubDTO dto)
    {
        String sourceName = dto.getStadiumName();
        Stadium existing = mapOfExistingStadiums.get(sourceName);
        if (existing != null)
        {
            existing.setSeats(dto.getStadiumSeats());
            return existing;
        }
        Stadium stadium = JpaEntityFactory.createStadiumFromClub(dto);
        stadiumDao.save(stadium);
        mapOfExistingStadiums.put(sourceName, stadium);
        return stadium;
    }

    public void loadExistingStadiums()
    {
        for (Stadium stadium : stadiumDao.findAll())
        {
            mapOfExistingStadiums.put(stadium.getName(), stadium);
        }
    }

    public void clearCache()
    {
        mapOfExistingStadiums.clear();
    }
}