package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.CompetitionDao;
import fr.diginamic.geoff.dto.ClubDTO;
import fr.diginamic.geoff.dto.CompetitionDTO;
import fr.diginamic.geoff.dto.GameDTO;
import fr.diginamic.geoff.entity.Competition;
import fr.diginamic.geoff.utils.JpaEntityFactory;
import jakarta.persistence.EntityManager;

import java.util.*;

public class CompetitionService
{
    private final CompetitionDao competitionDao;

    private final Map<String, Competition> mapOfExistingCompetitions = new HashMap<>();
    private final Map<String, List<Competition>> competitionsBydomesticId = new HashMap<>();

    public CompetitionService(EntityManager em)
    {
        this.competitionDao = new CompetitionDao(em);

    }

    public Competition findOrCreateCompetition(GameDTO dto)
    {
        String sourceId = dto.getCompetitionId();
        Competition existing = mapOfExistingCompetitions.get(sourceId);
        if (existing != null)
        {
            return existing;
        }

        Competition competition = JpaEntityFactory.createCompetition(dto);

        mapOfExistingCompetitions.put(competition.getSourceId(), competition);

        competitionDao.save(competition);

        return competition;
    }

    public Competition findOrCreateCompetitionFromCompetitionDTO(CompetitionDTO dto)
    {
        String sourceId = dto.getCompetitionId();

        Competition existing = mapOfExistingCompetitions.get(sourceId);
        if (existing != null)
        {
            existing.setCompetitionCode(dto.getCompetitionCode());
            existing.setCompetitionName(dto.getName());
            existing.setCompetitionSubtype(dto.getSubType());
            existing.setDomesticLeagueCode(dto.getDomesticLeagueCode());
            existing.setConfederation(dto.getConfederation());
            return existing;
        }

        Competition competition = JpaEntityFactory.createCompetitionFromCompetitionDto(dto);
        competitionDao.save(competition);
        mapOfExistingCompetitions.put(competition.getSourceId(), competition);
        return competition;
    }

    public List<Competition> findFromClubDTO(ClubDTO dto)
    {
        return competitionsBydomesticId.getOrDefault(dto.getDomesticCompetitionId(), Collections.emptyList());
    }

    public void loadExistingCompetitions()
    {
        for (Competition competition : competitionDao.findAll())
        {
            mapOfExistingCompetitions.put(competition.getSourceId(), competition);
        }
    }

    public void loadAndGroupCompetitionsbyDomesticId()
    {
        for (Competition competition : competitionDao.findAll())
        {
            String key = competition.getDomesticLeagueCode();
            competitionsBydomesticId.computeIfAbsent(key, k -> new ArrayList<>()).add(competition);
        }
    }

    public void clearCache() {mapOfExistingCompetitions.clear();}
}