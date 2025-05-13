package fr.diginamic.geoff.dao;

import fr.diginamic.geoff.entity.Agent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;


public class AgentDao
{
    private final EntityManager em;

    public AgentDao(EntityManager em)
    {
        this.em = em;
    }

    public Optional<Agent> findByName(String name)
    {
        if (name == null || name.isEmpty())
        {
            return Optional.empty();
        }

        TypedQuery<Agent> query = em.createQuery(
                "SELECT a FROM Agent a WHERE a.name = :name", Agent.class
        );
        query.setParameter("name", name);

        List<Agent> agentList = query.getResultList();
        if (!agentList.isEmpty())
        {
            return Optional.of(agentList.getFirst());
        }
        return Optional.empty();
    }

    public void save(Agent agent)
    {
        em.persist(agent);

    }


    public List<Agent> findAll()
    {
        TypedQuery<Agent> query = em.createQuery("SELECT a FROM Agent a", Agent.class);
        return query.getResultList();
    }
}