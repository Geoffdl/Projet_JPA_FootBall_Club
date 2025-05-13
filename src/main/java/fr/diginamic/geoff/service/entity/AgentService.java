package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.AgentDao;
import fr.diginamic.geoff.dto.PlayerDTO;
import fr.diginamic.geoff.entity.Agent;
import fr.diginamic.geoff.utils.JpaEntityFactory;

import java.util.HashMap;
import java.util.Map;

public class AgentService
{
    private final AgentDao agentDao;
    private final JpaEntityFactory factory;

    private final Map<String, Agent> mapOfExistingAgents = new HashMap<>();

    public AgentService(AgentDao agentDao, JpaEntityFactory factory)
    {
        this.agentDao = agentDao;
        this.factory = factory;
    }

    public Agent findOrCreateAgent(PlayerDTO playerDTO)
    {
        String sourceName = playerDTO.getAgentName();
        if (sourceName == null || sourceName.trim().isEmpty())
        {
            return null;
        }

        Agent existing = mapOfExistingAgents.get(sourceName);
        if (existing != null)
        {
            return existing;
        }

        Agent agent = factory.createAgent(playerDTO);
        agentDao.save(agent);
        mapOfExistingAgents.put(sourceName, agent);
        return agent;
    }

    public void loadExistingAgents()
    {
        mapOfExistingAgents.clear();
        for (Agent agent : agentDao.findAll())
        {
            mapOfExistingAgents.put(agent.getName(), agent);
        }
    }

    public void clearCache()
    {
        mapOfExistingAgents.clear();
    }
}