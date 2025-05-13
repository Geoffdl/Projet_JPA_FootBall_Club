package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.CompetitionRoundDao;
import fr.diginamic.geoff.dto.GameDTO;
import fr.diginamic.geoff.entity.CompetitionRound;
import fr.diginamic.geoff.utils.JpaEntityFactory;
import jakarta.persistence.EntityManager;

import java.util.HashMap;
import java.util.Map;

/**
 * This class orchestrates daos and mappers to generate entities and persist them in the database
 * It implements a caching method using a sourceId from the data and an instance of the object, either created or fetched from the database if existing
 */
public class CompetitionRoundService
{
    private final CompetitionRoundDao competitionRoundDao;
    private final Map<String, CompetitionRound> mapOfExistingRound = new HashMap<>();

    public CompetitionRoundService(EntityManager em)
    {
        this.competitionRoundDao = new CompetitionRoundDao(em);
    }

    public CompetitionRound findOrCreateCompetitionRound(GameDTO dto)
    {
        String sourceId = dto.getRound();
        CompetitionRound existing = mapOfExistingRound.get(sourceId);
        if (existing != null)
        {
            return existing;
        }


        CompetitionRound competitionRound = JpaEntityFactory.createCompetitionRound(dto);
        mapOfExistingRound.put(competitionRound.getRound(), competitionRound);
        competitionRoundDao.save(competitionRound);

        return competitionRound;
    }

    public void loadExistingCompetitionrounds()
    {
        for (CompetitionRound competitionRound : competitionRoundDao.findAll())
        {
            mapOfExistingRound.put(competitionRound.getRound(), competitionRound);
        }
    }

    public void clearCache() {mapOfExistingRound.clear();}
}