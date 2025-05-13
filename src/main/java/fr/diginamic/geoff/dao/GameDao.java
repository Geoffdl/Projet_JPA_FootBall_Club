package fr.diginamic.geoff.dao;

import fr.diginamic.geoff.entity.Game;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class GameDao
{
    EntityManager em;

    public GameDao(EntityManager em)
    {
        this.em = em;
    }

    public Optional<Game> findBySourceId(Long sourceId)
    {
        if (sourceId == null)
        {
            return Optional.empty();
        }
        try
        {
            TypedQuery<Game> query = em.createQuery(
                    "SELECT g FROM Game g WHERE g.sourceId = :sourceId", Game.class);
            query.setParameter("sourceId", sourceId);

            return Optional.of(query.getSingleResult());
        } catch (NoResultException e)
        {
            return Optional.empty();
        }
    }

    public void save(Game game)
    {
        em.persist(game);
    }

    public List<Game> findAll()
    {
        TypedQuery<Game> query = em.createQuery(
                "SELECT g FROM Game g", Game.class
        );
        return query.getResultList();
    }
}