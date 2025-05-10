package fr.diginamic.geoff.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Agent
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agent_id")
    private Long agentId;

    private String name;

    @OneToMany(mappedBy = "agent")
    private Set<Player> players;

    public Agent()
    {
    }

    public Agent( String name, Set<Player> players)
    {
        this.name = name;
        this.players = players;
    }

    /**
     * Gets agentId for the class Agent
     *
     * @return value of agentId
     */
    public Long getAgentId()
    {
        return agentId;
    }

    /**
     * Gets name for the class Agent
     *
     * @return value of name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets name for the class Agent.
     *
     * @param name value of name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets players for the class Agent
     *
     * @return value of players
     */
    public Set<Player> getPlayers()
    {
        return players;
    }

    /**
     * Sets players for the class Agent.
     *
     * @param players value of players
     */
    public void setPlayers(Set<Player> players)
    {
        this.players = players;
    }
}