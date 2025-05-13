package fr.diginamic.geoff.dao;

import fr.diginamic.geoff.entity.GameLineup;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

/**
 * Handles DB requests for this entity
 */
public class GameLineupDao
{
    private final EntityManager em;

    public GameLineupDao(EntityManager em)
    {
        this.em = em;
    }

    public Optional<GameLineup> findBySourceId(String gameLineUpsId)
    {
        TypedQuery<GameLineup> query = em.createQuery(
                "SELECT gl FROM GameLineup gl WHERE gl.sourceId = :gameLineUpsId", GameLineup.class
        );
        query.setParameter("gameLineUpsId", gameLineUpsId);
        try
        {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e)
        {
            return Optional.empty();
        }
    }

    public void save(GameLineup gameLineup) {em.persist(gameLineup);}

    public List<GameLineup> findAll()
    {
        TypedQuery<GameLineup> query = em.createQuery("SELECT gl FROM GameLineup gl ", GameLineup.class);
        return query.getResultList();
    }
}