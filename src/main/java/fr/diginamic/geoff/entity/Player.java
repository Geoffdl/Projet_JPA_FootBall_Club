package fr.diginamic.geoff.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "players",
        indexes = {@Index(name = "idx_player_code", columnList = "player_code")})
public class Player
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Long playerId;

    @Column(name = "source_id", unique = true)
    private Long sourceId;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "player_code")
    private String playerCode;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "city_of_birth")
    private String cityOfBirth;
    @Column(name = "agent_name")
    private String agentName;
    @Column(name = "height")
    private Integer height;
    @Column(name = "shooting_foot")
    private String shootingFoot;
    @Column(name = "position_favored")
    private String positionFavored;
    @Column(name = "contract_expiration_date")
    private LocalDateTime contractExpirationDate;

    @ManyToOne
    @JoinColumn(name = "club_id", referencedColumnName = "club_id")
    private Club currentClub;
    //    @ManyToOne
//    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
//    private City cityOfBirth;
    @ManyToOne
    @JoinColumn(name = "country_citizenship_id", referencedColumnName = "country_id")
    private Country countryOfCitizenship;
    @ManyToOne
    @JoinColumn(name = "country_birth_id", referencedColumnName = "country_id")
    private Country countryOfBirth;
    @ManyToOne
    @JoinColumn(name = "picture_url_id")
    private Url pictureUrl;
    @OneToOne
    @JoinColumn(name = "url_id", referencedColumnName = "url_id")
    private Url dataUrl;
//    @ManyToOne
//    @JoinColumn(name = "agent_id", referencedColumnName = "agent_id")
//    private Agent agent;

    @OneToMany(mappedBy = "playerMain")
    private Set<GameEvent> gameEventsMain = new HashSet<>();
    @OneToMany(mappedBy = "playerIn")
    private Set<GameEvent> gameEventsIn = new HashSet<>();
    @OneToMany(mappedBy = "playerAssist")
    private Set<GameEvent> gameEventsAssist = new HashSet<>();

    @OneToMany(mappedBy = "player")
    private Set<GameAppearance> appearances = new HashSet<>();
    @OneToMany(mappedBy = "player")
    private Set<PlayerValuation> valuations = new HashSet<>();
    @OneToMany(mappedBy = "player")
    private Set<GameLineup> gameLineups = new HashSet<>();

    public Player()
    {
    }

    /**
     * Gets playerId for the class Player
     *
     * @return value of playerId
     */
    public Long getPlayerId()
    {
        return playerId;
    }

    /**
     * Gets sourceId for the class Player
     *
     * @return value of sourceId
     */
    public Long getSourceId()
    {
        return sourceId;
    }

    /**
     * Sets sourceId for the class Player.
     *
     * @param sourceId value of sourceId
     */
    public void setSourceId(Long sourceId)
    {
        this.sourceId = sourceId;
    }

    /**
     * Gets firstName for the class Player
     *
     * @return value of firstName
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Sets firstName for the class Player.
     *
     * @param firstName value of firstName
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Gets lastName for the class Player
     *
     * @return value of lastName
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Sets lastName for the class Player.
     *
     * @param lastName value of lastName
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Gets playerCode for the class Player
     *
     * @return value of playerCode
     */
    public String getPlayerCode()
    {
        return playerCode;
    }

    /**
     * Sets playerCode for the class Player.
     *
     * @param playerCode value of playerCode
     */
    public void setPlayerCode(String playerCode)
    {
        this.playerCode = playerCode;
    }

    /**
     * Gets dateOfBirth for the class Player
     *
     * @return value of dateOfBirth
     */
    public LocalDate getDateOfBirth()
    {
        return dateOfBirth;
    }

    /**
     * Sets dateOfBirth for the class Player.
     *
     * @param dateOfBirth value of dateOfBirth
     */
    public void setDateOfBirth(LocalDate dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets height for the class Player
     *
     * @return value of height
     */
    public Integer getHeight()
    {
        return height;
    }

    /**
     * Sets height for the class Player.
     *
     * @param height value of height
     */
    public void setHeight(Integer height)
    {
        this.height = height;
    }

    /**
     * Gets shootingFoot for the class Player
     *
     * @return value of shootingFoot
     */
    public String getShootingFoot()
    {
        return shootingFoot;
    }

    /**
     * Sets shootingFoot for the class Player.
     *
     * @param shootingFoot value of shootingFoot
     */
    public void setShootingFoot(String shootingFoot)
    {
        this.shootingFoot = shootingFoot;
    }

    /**
     * Gets positionFavored for the class Player
     *
     * @return value of positionFavored
     */
    public String getPositionFavored()
    {
        return positionFavored;
    }

    /**
     * Sets positionFavored for the class Player.
     *
     * @param positionFavored value of positionFavored
     */
    public void setPositionFavored(String positionFavored)
    {
        this.positionFavored = positionFavored;
    }

    /**
     * Gets contractExpirationDate for the class Player
     *
     * @return value of contractExpirationDate
     */
    public LocalDateTime getContractExpirationDate()
    {
        return contractExpirationDate;
    }

    /**
     * Sets contractExpirationDate for the class Player.
     *
     * @param contractExpirationDate value of contractExpirationDate
     */
    public void setContractExpirationDate(LocalDateTime contractExpirationDate)
    {
        this.contractExpirationDate = contractExpirationDate;
    }

    /**
     * Gets currentClub for the class Player
     *
     * @return value of currentClub
     */
    public Club getCurrentClub()
    {
        return currentClub;
    }

    /**
     * Sets currentClub for the class Player.
     *
     * @param currentClub value of currentClub
     */
    public void setCurrentClub(Club currentClub)
    {
        this.currentClub = currentClub;
    }

//    /**
//     * Gets cityOfBirth for the class Player
//     *
//     * @return value of cityOfBirth
//     */
//    public City getCityOfBirth()
//    {
//        return cityOfBirth;
//    }
//
//    /**
//     * Sets cityOfBirth for the class Player.
//     *
//     * @param cityOfBirth value of cityOfBirth
//     */
//    public void setCityOfBirth(City cityOfBirth)
//    {
//        this.cityOfBirth = cityOfBirth;
//    }

    /**
     * Gets countryOfCitizenship for the class Player
     *
     * @return value of countryOfCitizenship
     */
    public Country getCountryOfCitizenship()
    {
        return countryOfCitizenship;
    }

    /**
     * Sets countryOfCitizenship for the class Player.
     *
     * @param countryOfCitizenship value of countryOfCitizenship
     */
    public void setCountryOfCitizenship(Country countryOfCitizenship)
    {
        this.countryOfCitizenship = countryOfCitizenship;
    }

    /**
     * Gets countryOfBirth for the class Player
     *
     * @return value of countryOfBirth
     */
    public Country getCountryOfBirth()
    {
        return countryOfBirth;
    }

    /**
     * Sets countryOfBirth for the class Player.
     *
     * @param countryOfBirth value of countryOfBirth
     */
    public void setCountryOfBirth(Country countryOfBirth)
    {
        this.countryOfBirth = countryOfBirth;
    }

    /**
     * Gets pictureUrl for the class Player
     *
     * @return value of pictureUrl
     */
    public Url getPictureUrl()
    {
        return pictureUrl;
    }

    /**
     * Sets pictureUrl for the class Player.
     *
     * @param pictureUrl value of pictureUrl
     */
    public void setPictureUrl(Url pictureUrl)
    {
        this.pictureUrl = pictureUrl;
    }

    /**
     * Gets dataUrl for the class Player
     *
     * @return value of dataUrl
     */
    public Url getDataUrl()
    {
        return dataUrl;
    }

    /**
     * Sets dataUrl for the class Player.
     *
     * @param dataUrl value of dataUrl
     */
    public void setDataUrl(Url dataUrl)
    {
        this.dataUrl = dataUrl;
    }
//
//    /**
//     * Gets agent for the class Player
//     *
//     * @return value of agent
//     */
//    public Agent getAgent()
//    {
//        return agent;
//    }
//
//    /**
//     * Sets agent for the class Player.
//     *
//     * @param agent value of agent
//     */
//    public void setAgent(Agent agent)
//    {
//        this.agent = agent;
//    }

    /**
     * Gets gameEventsMain for the class Player
     *
     * @return value of gameEventsMain
     */
    public Set<GameEvent> getGameEventsMain()
    {
        return gameEventsMain;
    }

    /**
     * Sets gameEventsMain for the class Player.
     *
     * @param gameEventsMain value of gameEventsMain
     */
    public void setGameEventsMain(Set<GameEvent> gameEventsMain)
    {
        this.gameEventsMain = gameEventsMain;
    }

    /**
     * Gets gameEventsIn for the class Player
     *
     * @return value of gameEventsIn
     */
    public Set<GameEvent> getGameEventsIn()
    {
        return gameEventsIn;
    }

    /**
     * Sets gameEventsIn for the class Player.
     *
     * @param gameEventsIn value of gameEventsIn
     */
    public void setGameEventsIn(Set<GameEvent> gameEventsIn)
    {
        this.gameEventsIn = gameEventsIn;
    }

    /**
     * Gets gameEventsAssist for the class Player
     *
     * @return value of gameEventsAssist
     */
    public Set<GameEvent> getGameEventsAssist()
    {
        return gameEventsAssist;
    }

    /**
     * Sets gameEventsAssist for the class Player.
     *
     * @param gameEventsAssist value of gameEventsAssist
     */
    public void setGameEventsAssist(Set<GameEvent> gameEventsAssist)
    {
        this.gameEventsAssist = gameEventsAssist;
    }

    /**
     * Gets appearances for the class Player
     *
     * @return value of appearances
     */
    public Set<GameAppearance> getAppearances()
    {
        return appearances;
    }

    /**
     * Sets appearances for the class Player.
     *
     * @param appearances value of appearances
     */
    public void setAppearances(Set<GameAppearance> appearances)
    {
        this.appearances = appearances;
    }

    /**
     * Gets valuations for the class Player
     *
     * @return value of valuations
     */
    public Set<PlayerValuation> getValuations()
    {
        return valuations;
    }

    /**
     * Sets valuations for the class Player.
     *
     * @param valuations value of valuations
     */
    public void setValuations(Set<PlayerValuation> valuations)
    {
        this.valuations = valuations;
    }

    /**
     * Gets gameLineups for the class Player
     *
     * @return value of gameLineups
     */
    public Set<GameLineup> getGameLineups()
    {
        return gameLineups;
    }

    /**
     * Sets gameLineups for the class Player.
     *
     * @param gameLineups value of gameLineups
     */
    public void setGameLineups(Set<GameLineup> gameLineups)
    {
        this.gameLineups = gameLineups;
    }

    /**
     * Gets cityOfBirth for the class Player
     *
     * @return value of cityOfBirth
     */
    public String getCityOfBirth()
    {
        return cityOfBirth;
    }

    /**
     * Sets cityOfBirth for the class Player.
     *
     * @param cityOfBirth value of cityOfBirth
     */
    public void setCityOfBirth(String cityOfBirth)
    {
        this.cityOfBirth = cityOfBirth;
    }

    /**
     * Gets agentName for the class Player
     *
     * @return value of agentName
     */
    public String getAgentName()
    {
        return agentName;
    }

    /**
     * Sets agentName for the class Player.
     *
     * @param agentName value of agentName
     */
    public void setAgentName(String agentName)
    {
        this.agentName = agentName;
    }
}