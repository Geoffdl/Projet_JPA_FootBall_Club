package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.CompetitionDao;
import fr.diginamic.geoff.dto.CompetitionDTO;
import fr.diginamic.geoff.dto.GameDTO;
import fr.diginamic.geoff.entity.Competition;
import fr.diginamic.geoff.utils.JpaEntityFactory;

import java.util.Optional;

public class CompetitionService
{
    private final CompetitionDao competitionDao;
    private final JpaEntityFactory factory;

    public CompetitionService(CompetitionDao competitionDao, JpaEntityFactory factory)
    {
        this.competitionDao = competitionDao;
        this.factory = factory;
    }

    public Competition findOrCreateCompetition(GameDTO dto)
    {
        Optional<Competition> competitionOptional = competitionDao.findBySourceId(dto.getCompetitionId());

        if (competitionOptional.isPresent())
        {
            return competitionOptional.get();
        }

        Competition competition = factory.createCompetition(dto);
        competitionDao.save(competition);

        return competition;
    }

    public Competition findOrCreateCompetitionFromCompetitionDTO(CompetitionDTO dto) {}
}