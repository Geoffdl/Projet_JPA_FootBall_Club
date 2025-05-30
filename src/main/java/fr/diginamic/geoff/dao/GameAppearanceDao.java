package fr.diginamic.geoff.dao;

import fr.diginamic.geoff.entity.GameAppearance;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

/**
 * Handles DB requests for this entity
 */
public class GameAppearanceDao
{
    final EntityManager em;

    public GameAppearanceDao(EntityManager em)
    {
        this.em = em;
    }

    public Optional<GameAppearance> findBySourceId(Long appearanceId)
    {
        TypedQuery<GameAppearance> query = em.createQuery(
                "SELECT ga FROM GameAppearance ga WHERE ga.sourceId = :appearanceId", GameAppearance.class
        );
        query.setParameter("appearanceId", appearanceId);
        try
        {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e)
        {
            return Optional.empty();
        }
    }

    public void save(GameAppearance gameAppearance) {em.persist(gameAppearance);}

    public List<GameAppearance> findAll()
    {
        TypedQuery<GameAppearance> query = em.createQuery("SELECT ga FROM GameAppearance ga", GameAppearance.class);
        return query.getResultList();
    }
}