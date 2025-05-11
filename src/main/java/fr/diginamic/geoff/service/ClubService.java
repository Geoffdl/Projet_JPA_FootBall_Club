package fr.diginamic.geoff.service;

import fr.diginamic.geoff.dao.ClubDao;
import fr.diginamic.geoff.dto.PlayerDTO;
import fr.diginamic.geoff.entity.Club;
import fr.diginamic.geoff.entity.Club;
import fr.diginamic.geoff.utils.JpaEntityFactory;

import java.util.Optional;

public class ClubService
{
    private final ClubDao clubDao;
    private final JpaEntityFactory factory;

    public ClubService(ClubDao clubDao, JpaEntityFactory factory)
    {
        this.clubDao = clubDao;
        this.factory = factory;
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

        Club club = factory.createClub(dto);
        clubDao.save(club);
        return club;
    }
}