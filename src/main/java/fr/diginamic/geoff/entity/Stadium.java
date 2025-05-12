package fr.diginamic.geoff.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Stadium
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stadium_id")
    private Long stadiumId;

    @Column(unique = true)
    private String name;

    private int seats;

    @OneToMany(mappedBy = "stadium")
    private Set<Game> games = new HashSet<>();

    @OneToMany(mappedBy = "homeStadium")
    private Set<Club> clubs = new HashSet<>();

    public Stadium()
    {
    }

    /**
     * Gets stadiumId for the class Stadium
     *
     * @return value of stadiumId
     */
    public Long getStadiumId()
    {
        return stadiumId;
    }

    /**
     * Gets name for the class Stadium
     *
     * @return value of name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets name for the class Stadium.
     *
     * @param name value of name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets seats for the class Stadium
     *
     * @return value of seats
     */
    public int getSeats()
    {
        return seats;
    }

    /**
     * Sets seats for the class Stadium.
     *
     * @param seats value of seats
     */
    public void setSeats(int seats)
    {
        this.seats = seats;
    }

    /**
     * Gets games for the class Stadium
     *
     * @return value of games
     */
    public Set<Game> getGames()
    {
        return games;
    }

    /**
     * Sets games for the class Stadium.
     *
     * @param games value of games
     */
    public void setGames(Set<Game> games)
    {
        this.games = games;
    }

    /**
     * Gets club for the class Stadium
     *
     * @return value of club
     */
    /**
     * Gets clubs for the class Stadium
     *
     * @return value of clubs
     */
    public Set<Club> getClubs()
    {
        return clubs;
    }

    /**
     * Sets clubs for the class Stadium.
     *
     * @param clubs value of clubs
     */
    public void setClubs(Set<Club> clubs)
    {
        this.clubs = clubs;
    }
}