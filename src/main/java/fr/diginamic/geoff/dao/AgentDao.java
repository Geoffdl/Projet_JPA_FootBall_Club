package fr.diginamic.geoff.dao;

import fr.diginamic.geoff.entity.Agent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.Optional;
import java.util.function.Consumer;

public class AgentDao
{
    private final EntityManager em;

    public AgentDao(EntityManager em)
    {
        this.em = em;
    }

    public Optional<Agent> findByName(String name){
        if(name == null || name.isEmpty()){
            return Optional.empty();
        }
        try{
            TypedQuery<Agent> query = em.createQuery(
                    "SELECT a FROM Agent a WHERE a.name = :name", Agent.class
            );
            query.setParameter("name", name);

            return Optional.of(query.getSingleResult());
        } catch (NoResultException e){
            return Optional.empty();
        }
    }

    public void save(Agent agent){
        em.persist(agent);

    }



}