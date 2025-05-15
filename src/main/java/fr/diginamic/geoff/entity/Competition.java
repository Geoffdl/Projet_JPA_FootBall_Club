package fr.diginamic.geoff.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "competition", indexes = {@Index(name = "idx_comp_name", columnList = "name"), @Index(name = "idx_comp_code", columnList = "competition_code")})
public class Competition
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "competition_id")
    private Long competitionId;

    @Column(name = "source_id", unique = true, length = 10)
    private String sourceId;

    @Column(name = "competition_code")
    private String competitionCode;

    @Column(name = "name")
    private String competitionName;

    @Column(name = "type")
    private String competitionType;
    @Column(name = "subtype")
    private String competitionSubtype;
    @Column(name = "domestic_league_code")
    private String domesticLeagueCode;

    private String confederation;


    @OneToOne
    @JoinColumn(name = "url_id", referencedColumnName = "url_id")
    private Url url;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    private Country country;

    @ManyToMany(mappedBy = "competitions")
    private Set<Club> clubs = new HashSet<>();
    @OneToMany(mappedBy = "competition")
    private Set<Game> games = new HashSet<>();

    public Competition()
    {
    }

    /**
     * Gets competitionId for the class Competition
     *
     * @return value of competitionId
     */
    public Long getCompetitionId()
    {
        return competitionId;
    }

    /**
     * Gets sourceId for the class Competition
     *
     * @return value of sourceId
     */
    public String getSourceId()
    {
        return sourceId;
    }

    /**
     * Sets sourceId for the class Competition.
     *
     * @param sourceId value of sourceId
     */
    public void setSourceId(String sourceId)
    {
        this.sourceId = sourceId;
    }

    /**
     * Gets competitionCode for the class Competition
     *
     * @return value of competitionCode
     */
    public String getCompetitionCode()
    {
        return competitionCode;
    }

    /**
     * Sets competitionCode for the class Competition.
     *
     * @param competitionCode value of competitionCode
     */
    public void setCompetitionCode(String competitionCode)
    {
        this.competitionCode = competitionCode;
    }

    /**
     * Gets competitionName for the class Competition
     *
     * @return value of competitionName
     */
    public String getCompetitionName()
    {
        return competitionName;
    }

    /**
     * Sets competitionName for the class Competition.
     *
     * @param competitionName value of competitionName
     */
    public void setCompetitionName(String competitionName)
    {
        this.competitionName = competitionName;
    }

    /**
     * Gets competitionType for the class Competition
     *
     * @return value of competitionType
     */
    public String getCompetitionType()
    {
        return competitionType;
    }

    /**
     * Sets competitionType for the class Competition.
     *
     * @param competitionType value of competitionType
     */
    public void setCompetitionType(String competitionType)
    {
        this.competitionType = competitionType;
    }

    /**
     * Gets competitionSubtype for the class Competition
     *
     * @return value of competitionSubtype
     */
    public String getCompetitionSubtype()
    {
        return competitionSubtype;
    }

    /**
     * Sets competitionSubtype for the class Competition.
     *
     * @param competitionSubtype value of competitionSubtype
     */
    public void setCompetitionSubtype(String competitionSubtype)
    {
        this.competitionSubtype = competitionSubtype;
    }

    /**
     * Gets domesticLeagueCode for the class Competition
     *
     * @return value of domesticLeagueCode
     */
    public String getDomesticLeagueCode()
    {
        return domesticLeagueCode;
    }

    /**
     * Sets domesticLeagueCode for the class Competition.
     *
     * @param domesticLeagueCode value of domesticLeagueCode
     */
    public void setDomesticLeagueCode(String domesticLeagueCode)
    {
        this.domesticLeagueCode = domesticLeagueCode;
    }

    /**
     * Gets confederation for the class Competition
     *
     * @return value of confederation
     */
    public String getConfederation()
    {
        return confederation;
    }

    /**
     * Sets confederation for the class Competition.
     *
     * @param confederation value of confederation
     */
    public void setConfederation(String confederation)
    {
        this.confederation = confederation;
    }

    /**
     * Gets url for the class Competition
     *
     * @return value of url
     */
    public Url getUrl()
    {
        return url;
    }

    /**
     * Sets url for the class Competition.
     *
     * @param url value of url
     */
    public void setUrl(Url url)
    {
        this.url = url;
    }

    /**
     * Gets country for the class Competition
     *
     * @return value of country
     */
    public Country getCountry()
    {
        return country;
    }

    /**
     * Sets country for the class Competition.
     *
     * @param country value of country
     */
    public void setCountry(Country country)
    {
        this.country = country;
    }

    /**
     * Gets clubs for the class Competition
     *
     * @return value of clubs
     */
    public Set<Club> getClubs()
    {
        return clubs;
    }

    /**
     * Sets clubs for the class Competition.
     *
     * @param clubs value of clubs
     */
    public void setClubs(Set<Club> clubs)
    {
        this.clubs = clubs;
    }

    /**
     * Gets games for the class Competition
     *
     * @return value of games
     */
    public Set<Game> getGames()
    {
        return games;
    }

    /**
     * Sets games for the class Competition.
     *
     * @param games value of games
     */
    public void setGames(Set<Game> games)
    {
        this.games = games;
    }
}