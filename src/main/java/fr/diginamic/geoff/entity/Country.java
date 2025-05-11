package fr.diginamic.geoff.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Country
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long countryId;


    @Column(name = "source_id", unique = true)
    private Long sourceId;

    private String nom;

    @OneToMany(mappedBy = "country")
    private Set<Competition> competitions = new HashSet<>();
    ;

    @OneToMany(mappedBy = "countryOfCitizenship")
    private Set<Player> playersCitizenship = new HashSet<>();
    ;
    @OneToMany(mappedBy = "countryOfBirth")
    private Set<Player> playersBirth = new HashSet<>();
    ;

    @OneToMany(mappedBy = "country")
    private Set<Club> clubs = new HashSet<>();
    ;

    public Country()
    {
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
     * Gets sourceId for the class Country
     *
     * @return value of sourceId
     */
    public Long getSourceId()
    {
        return sourceId;
    }

    /**
     * Sets sourceId for the class Country.
     *
     * @param sourceId value of sourceId
     */
    public void setSourceId(Long sourceId)
    {
        this.sourceId = sourceId;
    }

    /**
     * Gets nom for the class Country
     *
     * @return value of nom
     */
    public String getNom()
    {
        return nom;
    }

    /**
     * Sets nom for the class Country.
     *
     * @param nom value of nom
     */
    public void setNom(String nom)
    {
        this.nom = nom;
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