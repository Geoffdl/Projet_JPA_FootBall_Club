package fr.diginamic.geoff.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class City
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Long cityId;

    private String name;

    @OneToMany(mappedBy = "cityOfBirth")
    private Set<Player> players;

    public City()
    {
    }

    public City(String name, Set<Player> players)
    {

        this.name = name;
        this.players = players;
    }

    /**
     * Gets cityId for the class City
     *
     * @return value of cityId
     */
    public Long getCityId()
    {
        return cityId;
    }


    /**
     * Gets name for the class City
     *
     * @return value of name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets name for the class City.
     *
     * @param name value of name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets players for the class City
     *
     * @return value of players
     */
    public Set<Player> getPlayers()
    {
        return players;
    }

    /**
     * Sets players for the class City.
     *
     * @param players value of players
     */
    public void setPlayers(Set<Player> players)
    {
        this.players = players;
    }
}