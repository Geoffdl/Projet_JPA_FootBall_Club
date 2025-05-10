package fr.diginamic.geoff.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Country
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long countryId;

    @OneToMany(mappedBy = "country")
    private Set<Competition> competitions;

    @OneToMany(mappedBy = "countryOfCitizenship")
    private Set<Player> playersCitizenship;
    @OneToMany(mappedBy = "countryOfBirth")
    private Set<Player> playersBirth;

    @OneToMany(mappedBy = "country")
    private Set<Club> clubs;

    public Country()
    {
    }

    public Country(Set<Competition> competitions, Set<Player> playersCitizenship, Set<Player> playersBirth, Set<Club> clubs)
    {
        this.competitions = competitions;
        this.playersCitizenship = playersCitizenship;
        this.playersBirth = playersBirth;
        this.clubs = clubs;
    }

    /**
     * Gets countryId for the class Country
     *
     * @return value of countryId
     */
    public Long getCountryId()
    {
        return countryId;
    }


    /**
     * Gets competitions for the class Country
     *
     * @return value of competitions
     */
    public Set<Competition> getCompetitions()
    {
        return competitions;
    }

    /**
     * Sets competitions for the class Country.
     *
     * @param competitions value of competitions
     */
    public void setCompetitions(Set<Competition> competitions)
    {
        this.competitions = competitions;
    }

    /**
     * Gets playersCitizenship for the class Country
     *
     * @return value of playersCitizenship
     */
    public Set<Player> getPlayersCitizenship()
    {
        return playersCitizenship;
    }

    /**
     * Sets playersCitizenship for the class Country.
     *
     * @param playersCitizenship value of playersCitizenship
     */
    public void setPlayersCitizenship(Set<Player> playersCitizenship)
    {
        this.playersCitizenship = playersCitizenship;
    }

    /**
     * Gets playersBirth for the class Country
     *
     * @return value of playersBirth
     */
    public Set<Player> getPlayersBirth()
    {
        return playersBirth;
    }

    /**
     * Sets playersBirth for the class Country.
     *
     * @param playersBirth value of playersBirth
     */
    public void setPlayersBirth(Set<Player> playersBirth)
    {
        this.playersBirth = playersBirth;
    }

    /**
     * Gets clubs for the class Country
     *
     * @return value of clubs
     */
    public Set<Club> getClubs()
    {
        return clubs;
    }

    /**
     * Sets clubs for the class Country.
     *
     * @param clubs value of clubs
     */
    public void setClubs(Set<Club> clubs)
    {
        this.clubs = clubs;
    }
}