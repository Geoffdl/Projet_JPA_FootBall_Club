package fr.diginamic.geoff.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "players")
public class Player
{
    @Id
    @Column(name = "player_id")
    private Long playerId;

    private String firstName;
    private String lastName;
    private String playerCode;
    private LocalDate dateOfBirth;
    private int height;
    private String shooting_foot;
    private String positionFavored;
    private LocalDate contractExpirationDate;

    @ManyToOne
    @JoinColumn(name = "club_id", referencedColumnName = "club_id")
    private Club currentClub;
    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    private City cityOfBirth;
    @ManyToOne
    @JoinColumn(name = "country_citizenship_id", referencedColumnName = "country_id")
    private Country countryOfCitizenship;
    @ManyToOne
    @JoinColumn(name = "country_birth_id", referencedColumnName = "country_id")
    private Country countryOfBirth;
    @ManyToOne
    @JoinColumn(name = "picture_url_id", referencedColumnName = "url_id")
    private Url pictureUrlId;
    @ManyToOne
    @JoinColumn(name = "url_id", referencedColumnName = "url_id")
    private Url dataUrlId;
    @ManyToOne
    @JoinColumn(name = "agent_id", referencedColumnName = "agent_id")
    private Agent agentId;

    @OneToMany(mappedBy = "player")
    private Set<GameEvent> gameEvents;
    @OneToMany(mappedBy = "player")
    private Set<GameAppearance> appearances;
    @OneToMany(mappedBy = "player")
    private Set<PlayerValuation> valuations;
    @OneToMany(mappedBy = "player")
    private Set<GameLineup> gameLineups;

    public Player()
    {
    }

    public Player(Long playerId, String firstName, String lastName, String playerCode, LocalDate dateOfBirth, int height, String shooting_foot, String positionFavored, LocalDate contractExpirationDate, Club currentClub, City cityOfBirth, Country countryOfCitizenship, Country countryOfBirth, Url pictureUrlId, Url dataUrlId, Agent agentId, Set<GameEvent> gameEvents, Set<GameAppearance> appearances, Set<PlayerValuation> valuations, Set<GameLineup> gameLineups)
    {
        this.playerId = playerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.playerCode = playerCode;
        this.dateOfBirth = dateOfBirth;
        this.height = height;
        this.shooting_foot = shooting_foot;
        this.positionFavored = positionFavored;
        this.contractExpirationDate = contractExpirationDate;
        this.currentClub = currentClub;
        this.cityOfBirth = cityOfBirth;
        this.countryOfCitizenship = countryOfCitizenship;
        this.countryOfBirth = countryOfBirth;
        this.pictureUrlId = pictureUrlId;
        this.dataUrlId = dataUrlId;
        this.agentId = agentId;
        this.gameEvents = gameEvents;
        this.appearances = appearances;
        this.valuations = valuations;
        this.gameLineups = gameLineups;
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
    public int getHeight()
    {
        return height;
    }

    /**
     * Sets height for the class Player.
     *
     * @param height value of height
     */
    public void setHeight(int height)
    {
        this.height = height;
    }

    /**
     * Gets shooting_foot for the class Player
     *
     * @return value of shooting_foot
     */
    public String getShooting_foot()
    {
        return shooting_foot;
    }

    /**
     * Sets shooting_foot for the class Player.
     *
     * @param shooting_foot value of shooting_foot
     */
    public void setShooting_foot(String shooting_foot)
    {
        this.shooting_foot = shooting_foot;
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
    public LocalDate getContractExpirationDate()
    {
        return contractExpirationDate;
    }

    /**
     * Sets contractExpirationDate for the class Player.
     *
     * @param contractExpirationDate value of contractExpirationDate
     */
    public void setContractExpirationDate(LocalDate contractExpirationDate)
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

    /**
     * Gets cityOfBirth for the class Player
     *
     * @return value of cityOfBirth
     */
    public City getCityOfBirth()
    {
        return cityOfBirth;
    }

    /**
     * Sets cityOfBirth for the class Player.
     *
     * @param cityOfBirth value of cityOfBirth
     */
    public void setCityOfBirth(City cityOfBirth)
    {
        this.cityOfBirth = cityOfBirth;
    }

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
     * Gets pictureUrlId for the class Player
     *
     * @return value of pictureUrlId
     */
    public Url getPictureUrlId()
    {
        return pictureUrlId;
    }

    /**
     * Sets pictureUrlId for the class Player.
     *
     * @param pictureUrlId value of pictureUrlId
     */
    public void setPictureUrlId(Url pictureUrlId)
    {
        this.pictureUrlId = pictureUrlId;
    }

    /**
     * Gets dataUrlId for the class Player
     *
     * @return value of dataUrlId
     */
    public Url getDataUrlId()
    {
        return dataUrlId;
    }

    /**
     * Sets dataUrlId for the class Player.
     *
     * @param dataUrlId value of dataUrlId
     */
    public void setDataUrlId(Url dataUrlId)
    {
        this.dataUrlId = dataUrlId;
    }

    /**
     * Gets agentId for the class Player
     *
     * @return value of agentId
     */
    public Agent getAgentId()
    {
        return agentId;
    }

    /**
     * Sets agentId for the class Player.
     *
     * @param agentId value of agentId
     */
    public void setAgentId(Agent agentId)
    {
        this.agentId = agentId;
    }

    /**
     * Gets gameEvents for the class Player
     *
     * @return value of gameEvents
     */
    public Set<GameEvent> getGameEvents()
    {
        return gameEvents;
    }

    /**
     * Sets gameEvents for the class Player.
     *
     * @param gameEvents value of gameEvents
     */
    public void setGameEvents(Set<GameEvent> gameEvents)
    {
        this.gameEvents = gameEvents;
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
}