package fr.diginamic.geoff.dao;

import fr.diginamic.geoff.entity.Club;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

/**
 * Handles DB requests for this entity
 */
public class ClubDao implements Dao<Club>
{
    EntityManager em;

    public ClubDao(EntityManager em)
    {
        this.em = em;
    }

    @Override
    public void save(Club club)
    {
        em.persist(club);
    }

    @Override
    public List<Club> findAllById(Long id)
    {
        return List.of();
    }

    @Override
    public List<Club> findAllByIdString(String id)
    {
        return List.of();
    }

    @Override
    public List<Club> findAll()
    {
        TypedQuery<Club> query = em.createQuery("SELECT c FROM Club c", Club.class);
        return query.getResultList();
    }
}