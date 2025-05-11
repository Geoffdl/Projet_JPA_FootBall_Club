package fr.diginamic.geoff.dao;

import fr.diginamic.geoff.entity.Country;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class CountryDao
{
    EntityManager em;

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


}