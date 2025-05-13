package fr.diginamic.geoff.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//@Entity
public class City
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Long cityId;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "cityOfBirth")
    private Set<Player> players = new HashSet<>();

    public City()
    {
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

    @Override
    public boolean equals(Object object)
    {
        if (!(object instanceof City city)) return false;
        return Objects.equals(name, city.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(name);
    }
}