package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.ClubDao;
import fr.diginamic.geoff.dto.ClubDTO;
import fr.diginamic.geoff.dto.GameDTO;
import fr.diginamic.geoff.dto.PlayerDTO;
import fr.diginamic.geoff.entity.Club;
import fr.diginamic.geoff.utils.JpaEntityFactory;
import jakarta.persistence.EntityManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * This class orchestrates daos and mappers to generate entities and persist them in the database
 * It implements a caching method using a sourceId from the data and an instance of the object, either created or fetched from the database if existing
 */
public class ClubService
{
    private final Map<Long, Club> mapOfExistingClubs = new HashMap<>();
    private final ClubDao clubDao;

    public ClubService(EntityManager em)
    {
        this.clubDao = new ClubDao(em);
    }

    public void loadExistingClubs()
    {
        for (Club club : clubDao.findAll())
        {
            mapOfExistingClubs.put(club.getSourceId(), club);
        }
    }

    public Club findOrCreateClub(PlayerDTO dto)
    {
        Long sourceId = dto.getCurrentClubId();
        Club existing = mapOfExistingClubs.get(sourceId);
        if (existing != null)
        {
            return existing;
        }

        Club club = JpaEntityFactory.createClub(dto);
        clubDao.save(club);
        mapOfExistingClubs.put(sourceId, club);
        return club;
    }

    public Club findOrCreateClubFromGame(GameDTO dto, boolean isHome)
    {
        Long sourceId;
        if (isHome)
        {
            sourceId = dto.getHomeClubId();
        } else
        {
            sourceId = dto.getAwayClubId();
        }
        Club existing = mapOfExistingClubs.get(sourceId);
        if (existing != null)
        {
            return existing;
        }

        Club club = JpaEntityFactory.createClubFromGame(dto, isHome);
        mapOfExistingClubs.put(sourceId, club);
        clubDao.save(club);
        return club;
    }

    public Club findOrCreateClubFromClubDTO(ClubDTO dto)
    {
        Long sourceId = dto.getClubId();
        Club existing = mapOfExistingClubs.get(sourceId);
        if (existing != null)
        {
            if (!Objects.equals(existing.getClubCode(), dto.getClubCode()))
            {
                existing.setClubCode(dto.getClubCode());
            }
            if (existing.getTransferRecord() != dto.getNetTransferRecord())
            {
                existing.setTransferRecord(dto.getNetTransferRecord());
            }
            return existing;
        }

        Club club = JpaEntityFactory.createClubFromClub(dto);
        clubDao.save(club);
        mapOfExistingClubs.put(sourceId, club);
        return club;
    }


    public void clearCache()
    {
        mapOfExistingClubs.clear();
    }
}