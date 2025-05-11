package fr.diginamic.geoff.service;

import fr.diginamic.geoff.dao.AgentDao;
import fr.diginamic.geoff.dto.PlayerDTO;
import fr.diginamic.geoff.entity.Agent;
import fr.diginamic.geoff.entity.Player;
import fr.diginamic.geoff.utils.JpaEntityFactory;

import java.util.Optional;
import java.util.Set;

public class AgentService
{
    private final AgentDao agentDao;
    private final JpaEntityFactory factory;

    public AgentService(AgentDao agentDao, JpaEntityFactory factory)
    {
        this.agentDao = agentDao;
        this.factory = factory;
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

        Agent agent = factory.createAgent(playerDTO);
        agentDao.save(agent);
        return agent;
    }

}