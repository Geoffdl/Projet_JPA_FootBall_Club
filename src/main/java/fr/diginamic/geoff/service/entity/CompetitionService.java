package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.CompetitionDao;
import fr.diginamic.geoff.dto.ClubDTO;
import fr.diginamic.geoff.dto.CompetitionDTO;
import fr.diginamic.geoff.dto.GameDTO;
import fr.diginamic.geoff.entity.Competition;
import fr.diginamic.geoff.utils.JpaEntityFactory;
import jakarta.persistence.EntityManager;

import java.util.*;

/**
 * This class orchestrates dao and mappers to generate entities and persist them in the database
 * It implements a caching method using a sourceId from the data and an instance of the object, either created or fetched from the database if existing
 */
public class CompetitionService
{
    private final CompetitionDao competitionDao;
    private final Map<String, Competition> mapOfExistingCompetitions = new HashMap<>();
    private final Map<String, List<Competition>> competitionsByDomesticId = new HashMap<>();

    public CompetitionService(EntityManager em)
    {
        this.competitionDao = new CompetitionDao(em);

    }

    /**
     * Takes an instance of DTO, compares it to existing entity, if present in base return existing, if not create a new one from the DTO
     *
     * @param dto raw source entity
     * @return jpa entity
     */
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

    /**
     * Takes an instance of DTO, compares it to existing entity, if present in base return existing, if not create a new one from the DTO
     *
     * @param dto raw source entity
     * @return jpa entity
     */
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

    /**
     * Takes an instance of DTO, compares it to existing entity, if present in base return existing, if not create a new one from the DTO
     *
     * @param dto raw source entity
     * @return jpa entity
     */
    public List<Competition> findFromClubDTO(ClubDTO dto)
    {
        return competitionsByDomesticId.getOrDefault(dto.getDomesticCompetitionId(), Collections.emptyList());
    }

    /**
     * loads caching hashmap
     */
    public void loadExistingCompetitions()
    {
        for (Competition competition : competitionDao.findAll())
        {
            mapOfExistingCompetitions.put(competition.getSourceId(), competition);
        }
    }

    /**
     * loads caching hashmap
     */
    public void loadAndGroupCompetitionsByDomesticId()
    {
        for (Competition competition : competitionDao.findAll())
        {
            String key = competition.getDomesticLeagueCode();
            competitionsByDomesticId.computeIfAbsent(key, k -> new ArrayList<>()).add(competition);
        }
    }

    /**
     * clears cache
     */
    public void clearCache() {mapOfExistingCompetitions.clear();}
}