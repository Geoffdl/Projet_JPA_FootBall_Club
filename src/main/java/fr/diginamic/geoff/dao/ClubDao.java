package fr.diginamic.geoff.dao;

import fr.diginamic.geoff.entity.Club;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class ClubDao
{
    EntityManager em;

    public ClubDao(EntityManager em)
    {
        this.em = em;
    }

    public void save(Club club)
    {
        em.persist(club);

    }

    public Optional<Club> findBySourceId(Long sourceId)
    {
        if (sourceId == null)
        {
            return Optional.empty();
        }
        try
        {
            TypedQuery<Club> query = em.createQuery(
                    "SELECT c FROM Club c WHERE c.sourceId = :sourceId", Club.class);
            query.setParameter("sourceId", sourceId);

            return Optional.of(query.getSingleResult());
        } catch (NoResultException e)
        {
            return Optional.empty();
        }
    }

    public List<Club> findAll()
    {
        TypedQuery<Club> query = em.createQuery("SELECT c FROM Club c", Club.class);
        return query.getResultList();
    }
}