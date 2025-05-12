package fr.diginamic.geoff.dao;

import fr.diginamic.geoff.entity.Url;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.Optional;

public class UrlDao
{
    EntityManager em;

    public UrlDao(EntityManager em)
    {
        this.em = em;
    }

    public void save(Url url)
    {
        em.persist(url);

    }

    public Optional<Url> findByCode(String code)
    {
        if (code.isEmpty())
        {
            return Optional.empty();
        }
        try
        {
            TypedQuery<Url> query = em.createQuery(
                    "SELECT p FROM Url p WHERE p.url= :code", Url.class);
            query.setParameter("code", code);

            return Optional.of(query.getSingleResult());
        } catch (
                NoResultException e)

        {
            return Optional.empty();
        }
    }
}