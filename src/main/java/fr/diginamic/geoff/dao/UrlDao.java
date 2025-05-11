package fr.diginamic.geoff.dao;

import fr.diginamic.geoff.entity.Url;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
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
        if (code == null)
        {
            return Optional.empty();
        }

        TypedQuery<Url> query = em.createQuery(
                "SELECT p FROM Url p WHERE p.url= :code", Url.class);
        query.setParameter("code", code);

        List<Url> list = query.getResultList();
        if (!list.isEmpty())
        {
            return Optional.of(list.getFirst());
        }
        return Optional.empty();
    }
}