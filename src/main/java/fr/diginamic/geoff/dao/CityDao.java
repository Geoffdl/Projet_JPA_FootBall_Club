package fr.diginamic.geoff.dao;

import fr.diginamic.geoff.entity.Agent;
import fr.diginamic.geoff.entity.City;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.Optional;

public class CityDao
{
    EntityManager em;

    public CityDao(EntityManager em)
    {
        this.em = em;
    }

    public Optional<City> findByName(String cityOfBirth) {
        if(cityOfBirth == null || cityOfBirth.isEmpty()){
            return Optional.empty();
        }
        try{
            TypedQuery<City> query = em.createQuery(
                    "SELECT c FROM City c WHERE c.name = :name", City.class
            );
            query.setParameter("name", cityOfBirth);

            return Optional.of(query.getSingleResult());
        } catch (NoResultException e){
            return Optional.empty();
        }
    };

    public void save (City city){
        em.persist(city);
    };
}