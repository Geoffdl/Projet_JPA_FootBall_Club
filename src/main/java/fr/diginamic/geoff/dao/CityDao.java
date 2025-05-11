package fr.diginamic.geoff.dao;

import fr.diginamic.geoff.entity.City;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class CityDao
{
    EntityManager em;

    public CityDao(EntityManager em)
    {
        this.em = em;
    }

    public Optional<City> findByName(String cityOfBirth)
    {
        if (cityOfBirth == null || cityOfBirth.isEmpty())
        {
            return Optional.empty();
        }

        TypedQuery<City> query = em.createQuery(
                "SELECT c FROM City c WHERE c.name = :name", City.class
        );
        query.setParameter("name", cityOfBirth);

        List<City> cityList = query.getResultList();
        if (!cityList.isEmpty())
        {
            return Optional.of(cityList.getFirst());
        }
        return Optional.empty();

    }

    public void save(City city)
    {
        em.persist(city);
    }

}