package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.AgentDao;
import fr.diginamic.geoff.dto.PlayerDTO;
import fr.diginamic.geoff.entity.Agent;
import fr.diginamic.geoff.utils.JpaEntityFactory;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class AgentService
{
    private final AgentDao agentDao;

    public AgentService(EntityManager em)
    {
        this.agentDao = new AgentDao(em);
    }

    public Agent findOrCreateAgent(PlayerDTO playerDTO)
    {
        if (playerDTO.getAgentName() == null || playerDTO.getAgentName().trim().isEmpty())
        {
            return null;
        }

        Optional<Agent> agentOptional = agentDao.findByName(playerDTO.getAgentName());

        if (agentOptional.isPresent())
        {
            return agentOptional.get();
        }

        Agent agent = JpaEntityFactory.createAgent(playerDTO);
        agentDao.save(agent);
        return agent;
    }

}