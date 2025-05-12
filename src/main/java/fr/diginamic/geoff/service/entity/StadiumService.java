package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.StadiumDao;
import fr.diginamic.geoff.dto.ClubDTO;
import fr.diginamic.geoff.dto.GameDTO;
import fr.diginamic.geoff.entity.Stadium;
import fr.diginamic.geoff.utils.JpaEntityFactory;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class StadiumService
{
    private final StadiumDao stadiumDao;

    public StadiumService(EntityManager em)
    {
        this.stadiumDao = new StadiumDao(em);
    }

    public Stadium findOrCreateStadium(GameDTO dto)
    {
        Optional<Stadium> stadiumOptional = stadiumDao.findByName(dto.getStadiumName());

        if (stadiumOptional.isPresent())
        {
            return stadiumOptional.get();
        }

        Stadium stadium = JpaEntityFactory.createStadium(dto);
        stadiumDao.save(stadium);

        return stadium;
    }

    public Stadium findOrCreateStadiumFromClubDTO(ClubDTO dto)
    {
        Optional<Stadium> stadiumOptional = stadiumDao.findByName(dto.getStadiumName());

        if (stadiumOptional.isPresent())
        {
            return stadiumOptional.get();
        }

        Stadium stadium = JpaEntityFactory.createStadiumFromClub(dto);
        stadiumDao.save(stadium);

        return stadium;
    }
}