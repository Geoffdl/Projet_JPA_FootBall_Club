package fr.diginamic.geoff.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Club
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "club_id")
    private Long clubId;

    @Column(name = "club_code")
    private String clubCode;
    @Column(name = "club_name")
    private String clubName;
    @Column(name = "transfer_record")
    private int transferRecord;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    private Country country;
    @OneToOne
    private Url url;
    @ManyToOne
    @JoinColumn(name = "domestic_competition_id", referencedColumnName = "competition_id")
    private Competition domesticCompetition;
    @ManyToOne
    @JoinColumn(name = "home_stadium_id", referencedColumnName = "stadium_id")
    private Stadium homeStadium;

    @OneToMany(mappedBy = "currentClub")
    private Set<Player> players;
    @OneToMany(mappedBy = "club")
    private Set<ClubGame> clubGames;

    public Club()
    {
    }

    public Club(String clubCode, String clubName, int transferRecord, Country country, Url url, Competition domesticCompetition, Stadium homeStadium, Set<Player> players, Set<ClubGame> clubGames)
    {
        this.clubCode = clubCode;
        this.clubName = clubName;
        this.transferRecord = transferRecord;
        this.country = country;
        this.url = url;
        this.domesticCompetition = domesticCompetition;
        this.homeStadium = homeStadium;
        this.players = players;
        this.clubGames = clubGames;
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
    public int getTransferRecord()
    {
        return transferRecord;
    }

    /**
     * Sets transferRecord for the class Club.
     *
     * @param transferRecord value of transferRecord
     */
    public void setTransferRecord(int transferRecord)
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
     * Gets domesticCompetition for the class Club
     *
     * @return value of domesticCompetition
     */
    public Competition getDomesticCompetition()
    {
        return domesticCompetition;
    }

    /**
     * Sets domesticCompetition for the class Club.
     *
     * @param domesticCompetition value of domesticCompetition
     */
    public void setDomesticCompetition(Competition domesticCompetition)
    {
        this.domesticCompetition = domesticCompetition;
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