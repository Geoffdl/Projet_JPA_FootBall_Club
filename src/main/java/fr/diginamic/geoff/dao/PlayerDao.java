package fr.diginamic.geoff.dao;

import fr.diginamic.geoff.entity.Player;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class PlayerDao
{
    EntityManager em;

    public PlayerDao(EntityManager em)
    {
        this.em = em;
    }

    public void save(Player player)
    {
        em.persist(player);
    }

    public Optional<Player> findBySourceId(Long sourceId)
    {
        if (sourceId == null)
        {
            return Optional.empty();
        }
        try
        {
            TypedQuery<Player> query = em.createQuery(
                    "SELECT p FROM Player p WHERE p.sourceId = :sourceId", Player.class);
            query.setParameter("sourceId", sourceId);

            return Optional.of(query.getSingleResult());
        } catch (NoResultException e)
        {
            return Optional.empty();
        }
    }

    public Set<Long> findAllSourceIds()
    {
        TypedQuery<Long> query = em.createQuery(
                "SELECT p.sourceId FROM Player p", Long.class);

        return new HashSet<>(query.getResultList());
    }

    public List<Player> findAll()
    {
        TypedQuery<Player> query = em.createQuery("SELECT p FROM Player p", Player.class);
        return query.getResultList();
    }
}