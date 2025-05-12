package fr.diginamic.geoff.dao;

import fr.diginamic.geoff.entity.Competition;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class CompetitionDao
{
    private final EntityManager em;

    public CompetitionDao(EntityManager em)
    {
        this.em = em;
    }

    public void save(Competition competition) {em.persist(competition);}

    public Optional<Competition> findBySourceId(String sourceId)
    {
        if (sourceId == null)
        {
            return Optional.empty();
        }
        try
        {
            TypedQuery<Competition> query = em.createQuery(
                    "SELECT c FROM Competition c WHERE c.sourceId = :sourceId", Competition.class);
            query.setParameter("sourceId", sourceId);

            return Optional.of(query.getSingleResult());
        } catch (NoResultException e)
        {
            return Optional.empty();
        }
    }

    public List<Competition> findFromDomesticId(String domesticCompetitionId)
    {
        TypedQuery<Competition> query = em.createQuery(
                "SELECT c FROM Competition c WHERE c.domesticLeagueCode = :domesticCompetitionId", Competition.class
        );
        query.setParameter("domesticCompetitionId", domesticCompetitionId);
        return query.getResultList();
    }
}