package fr.diginamic.geoff.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "club",
        indexes = {@Index(name = "idx_club_name", columnList = "club_name")})
public class Club
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "club_id")
    private Long clubId;

    @Column(name = "source_id", unique = true)
    private Long sourceId;

    @Column(name = "club_code")
    private String clubCode;
    @Column(name = "club_name")
    private String clubName;
    @Column(name = "transfer_record")
    private Double transferRecord;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    private Country country;
    @OneToOne
    private Url url;
    @ManyToMany
    @JoinTable(
            name = "club_competition",
            joinColumns = @JoinColumn(name = "club_id"),
            inverseJoinColumns = @JoinColumn(name = "competition_id")
    )
    private Set<Competition> competitions = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "home_stadium_id")
    private Stadium homeStadium;

    @OneToMany(mappedBy = "currentClub")
    private Set<Player> players = new HashSet<>();
    @OneToMany(mappedBy = "club")
    private Set<ClubGame> clubGames = new HashSet<>();

    public Club()
    {
    }

    /**
     * Gets clubId for the class Club
     *
     * @return value of clubId
     */
    public Long getClubId()
    {
        return clubId;
    }

    /**
     * Gets sourceId for the class Club
     *
     * @return value of sourceId
     */
    public Long getSourceId()
    {
        return sourceId;
    }

    /**
     * Sets sourceId for the class Club.
     *
     * @param sourceId value of sourceId
     */
    public void setSourceId(Long sourceId)
    {
        this.sourceId = sourceId;
    }

    /**
     * Gets clubCode for the class Club
     *
     * @return value of clubCode
     */
    public String getClubCode()
    {
        return clubCode;
    }

    /**
     * Sets clubCode for the class Club.
     *
     * @param clubCode value of clubCode
     */
    public void setClubCode(String clubCode)
    {
        this.clubCode = clubCode;
    }

    /**
     * Gets clubName for the class Club
     *
     * @return value of clubName
     */
    public String getClubName()
    {
        return clubName;
    }

    /**
     * Sets clubName for the class Club.
     *
     * @param clubName value of clubName
     */
    public void setClubName(String clubName)
    {
        this.clubName = clubName;
    }

    /**
     * Gets transferRecord for the class Club
     *
     * @return value of transferRecord
     */
    public Double getTransferRecord()
    {
        return transferRecord;
    }

    /**
     * Sets transferRecord for the class Club.
     *
     * @param transferRecord value of transferRecord
     */
    public void setTransferRecord(Double transferRecord)
    {
        this.transferRecord = transferRecord;
    }

    /**
     * Gets country for the class Club
     *
     * @return value of country
     */
    public Country getCountry()
    {
        return country;
    }

    /**
     * Sets country for the class Club.
     *
     * @param country value of country
     */
    public void setCountry(Country country)
    {
        this.country = country;
    }

    /**
     * Gets url for the class Club
     *
     * @return value of url
     */
    public Url getUrl()
    {
        return url;
    }

    /**
     * Sets url for the class Club.
     *
     * @param url value of url
     */
    public void setUrl(Url url)
    {
        this.url = url;
    }

    /**
     * Gets competitions for the class Club
     *
     * @return value of competitions
     */
    public Set<Competition> getCompetitions()
    {
        return competitions;
    }

    /**
     * Sets competitions for the class Club.
     *
     * @param competitions value of competitions
     */
    public void setCompetitions(Set<Competition> competitions)
    {
        this.competitions = competitions;
    }

    /**
     * Gets homeStadium for the class Club
     *
     * @return value of homeStadium
     */
    public Stadium getHomeStadium()
    {
        return homeStadium;
    }

    /**
     * Sets homeStadium for the class Club.
     *
     * @param homeStadium value of homeStadium
     */
    public void setHomeStadium(Stadium homeStadium)
    {
        this.homeStadium = homeStadium;
    }

    /**
     * Gets players for the class Club
     *
     * @return value of players
     */
    public Set<Player> getPlayers()
    {
        return players;
    }

    /**
     * Sets players for the class Club.
     *
     * @param players value of players
     */
    public void setPlayers(Set<Player> players)
    {
        this.players = players;
    }

    /**
     * Gets clubGames for the class Club
     *
     * @return value of clubGames
     */
    public Set<ClubGame> getClubGames()
    {
        return clubGames;
    }

    /**
     * Sets clubGames for the class Club.
     *
     * @param clubGames value of clubGames
     */
    public void setClubGames(Set<ClubGame> clubGames)
    {
        this.clubGames = clubGames;
    }
}