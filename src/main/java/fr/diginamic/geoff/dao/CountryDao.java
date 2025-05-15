package fr.diginamic.geoff.dao;

import fr.diginamic.geoff.entity.Country;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

/**
 * Handles DB requests for this entity
 */
public class CountryDao
{
    final EntityManager em;

    public CountryDao(EntityManager em)
    {
        this.em = em;
    }

    public void save(Country country)
    {
        em.persist(country);

    }

    public Optional<Country> findByNom(String nom)
    {
        if (nom == null)
        {
            return Optional.empty();
        }

        TypedQuery<Country> query = em.createQuery(
                "SELECT p FROM Country p WHERE p.nom= :nom", Country.class);
        query.setParameter("nom", nom);

        List<Country> countryList = query.getResultList();
        if (!countryList.isEmpty())
        {
            return Optional.of(countryList.getFirst());
        }
        return Optional.empty();
    }


    public Optional<Country> finBySourceId(Long countryId)
    {
        if (countryId == null)
        {
            return Optional.empty();
        }
        try
        {
            TypedQuery<Country> query = em.createQuery("SELECT c FROM Country c WHERE c.sourceId = :sourceId", Country.class);
            query.setParameter("sourceId", countryId);
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e)
        {
            return Optional.empty();
        }
    }

    public List<Country> findAllWithCompetitions()
    {

        TypedQuery<Country> query = em.createQuery("SELECT DISTINCT c FROM Country c LEFT JOIN FETCH c.competitions", Country.class);

        return query.getResultList();
    }

    public List<Country> findAll()
    {
        TypedQuery<Country> query = em.createQuery("SELECT c FROM Country c", Country.class);
        return query.getResultList();
    }
}