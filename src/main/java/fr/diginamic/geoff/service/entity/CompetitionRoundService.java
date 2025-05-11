package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.CompetitionRoundDao;
import fr.diginamic.geoff.dto.GameDTO;
import fr.diginamic.geoff.entity.CompetitionRound;
import fr.diginamic.geoff.utils.JpaEntityFactory;

import java.util.Optional;

public class CompetitionRoundService
{
    private final CompetitionRoundDao competitionRoundDao;
    private final JpaEntityFactory factory;

    public CompetitionRoundService(CompetitionRoundDao competitionRoundDao, JpaEntityFactory factory)
    {
        this.competitionRoundDao = competitionRoundDao;
        this.factory = factory;
    }

    public CompetitionRound findOrCreateCompetitionRound(GameDTO dto)
    {
        Optional<CompetitionRound> competitionRoundOptional = competitionRoundDao.findByRound(dto.getRound());

        if (competitionRoundOptional.isPresent())
        {
            return competitionRoundOptional.get();
        }

        CompetitionRound competitionRound = factory.createCompetitionRound(dto);
        competitionRoundDao.save(competitionRound);

        return competitionRound;
    }
}