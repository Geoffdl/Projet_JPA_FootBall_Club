package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.ClubDao;
import fr.diginamic.geoff.dto.ClubDTO;
import fr.diginamic.geoff.dto.GameDTO;
import fr.diginamic.geoff.dto.PlayerDTO;
import fr.diginamic.geoff.entity.Club;
import fr.diginamic.geoff.utils.JpaEntityFactory;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class ClubService
{
    private final ClubDao clubDao;

    public ClubService(EntityManager em)
    {
        this.clubDao = new ClubDao(em);
    }

    public Club findOrCreateClub(PlayerDTO dto)
    {
        if (dto.getCurrentClubId() == null)
        {
            return null;
        }
        Optional<Club> clubOptional = clubDao.findBySourceId(dto.getCurrentClubId());
        if (clubOptional.isPresent())
        {
            return clubOptional.get();
        }
        Club club = JpaEntityFactory.createClub(dto);
        clubDao.save(club);
        return club;
    }

    public Club findOrCreateClubFromHomeGame(GameDTO dto, boolean isHome)
    {
        if (isHome)
        {
            if (dto.getHomeClubId() == null)
            {
                return null;
            }
            Optional<Club> clubOptional = clubDao.findBySourceId(dto.getHomeClubId());
            if (clubOptional.isPresent())
            {
                return clubOptional.get();
            }
            Club club = JpaEntityFactory.createClubFromGame(dto, isHome);
            clubDao.save(club);
            return club;
        }
        if (dto.getAwayClubId() == null)
        {
            return null;
        }
        Optional<Club> clubOptional = clubDao.findBySourceId(dto.getAwayClubId());
        if (clubOptional.isPresent())
        {
            return clubOptional.get();
        }
        Club club = JpaEntityFactory.createClubFromGame(dto, isHome);
        clubDao.save(club);
        return club;
    }

    public Club findOrCreateClubFromClubDTO(ClubDTO dto)
    {
        Optional<Club> clubOptional = clubDao.findBySourceId(dto.getClubId());
        if (clubOptional.isPresent())
        {
            clubOptional.get().setClubCode(dto.getClubCode());
            clubOptional.get().setTransferRecord(dto.getNetTransferRecord());
            clubDao.save(clubOptional.get());
            return clubOptional.get();
        }
        Club club = JpaEntityFactory.createClubFromClub(dto);
        clubDao.save(club);
        return club;
    }
}