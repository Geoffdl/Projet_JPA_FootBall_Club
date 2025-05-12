package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.CompetitionRoundDao;
import fr.diginamic.geoff.dto.GameDTO;
import fr.diginamic.geoff.entity.CompetitionRound;
import fr.diginamic.geoff.utils.JpaEntityFactory;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class CompetitionRoundService
{
    private final CompetitionRoundDao competitionRoundDao;


    public CompetitionRoundService(EntityManager em)
    {
        this.competitionRoundDao = new CompetitionRoundDao(em);

    }

    public CompetitionRound findOrCreateCompetitionRound(GameDTO dto)
    {
        Optional<CompetitionRound> competitionRoundOptional = competitionRoundDao.findByRound(dto.getRound());

        if (competitionRoundOptional.isPresent())
        {
            return competitionRoundOptional.get();
        }

        CompetitionRound competitionRound = JpaEntityFactory.createCompetitionRound(dto);
        competitionRoundDao.save(competitionRound);

        return competitionRound;
    }
}