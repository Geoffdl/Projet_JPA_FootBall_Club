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
    ;
    @ManyToOne
    @JoinColumn(name = "club_id", referencedColumnName = "club_id")
    private Club club;

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
    public Club getClub()
    {
        return club;
    }

    /**
     * Sets club for the class Stadium.
     *
     * @param club value of club
     */
    public void setClub(Club club)
    {
        this.club = club;
    }
}