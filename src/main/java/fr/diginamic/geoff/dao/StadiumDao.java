package fr.diginamic.geoff.dao;

import fr.diginamic.geoff.entity.Stadium;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

/**
 * Handles DB requests for this entity
 */
public class StadiumDao
{
    final EntityManager em;

    public StadiumDao(EntityManager em)
    {
        this.em = em;
    }

    public void save(Stadium stadium) {em.persist(stadium);}

    public Optional<Stadium> findByName(String stadiumName)
    {
        if (stadiumName == null)
        {
            return Optional.empty();
        }
        try
        {
            TypedQuery<Stadium> query = em.createQuery(
                    "SELECT s FROM Stadium s WHERE s.name = :stadiumName", Stadium.class);
            query.setParameter("stadiumName", stadiumName);

            return Optional.of(query.getSingleResult());
        } catch (NoResultException e)
        {
            return Optional.empty();
        }
    }

    public List<Stadium> findAll()
    {
        TypedQuery<Stadium> query = em.createQuery("SELECT s FROM Stadium s", Stadium.class);
        return query.getResultList();
    }
}