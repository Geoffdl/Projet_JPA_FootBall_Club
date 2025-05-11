package fr.diginamic.geoff.dto;

import java.time.LocalDate;
import java.time.Year;

public class GameDTO
{
    private Long gameId;
    private String competitionId;
    private Year season;
    private String round;
    private LocalDate date;
    private Long homeClubId;
    private Long awayClubId;
    private Integer homeClubGoals;
    private Integer awayClubGoals;
    private Integer homeClubPosition;
    private Integer awayClubPosition;
    private String homeClubManagerName;
    private String awayClubManagerName;
    private String stadiumName;
    private Integer attendance;
    private String refereeName;
    private String url;
    private String homeClubFormation;
    private String awayClubFormation;
    private String homeClubName;
    private String awayClubName;
    private String aggregate;
    private String competitionType;

    public GameDTO()
    {
    }

    /**
     * Gets gameId for the class GameDTO
     *
     * @return value of gameId
     */
    public Long getGameId()
    {
        return gameId;
    }

    /**
     * Sets gameId for the class GameDTO.
     *
     * @param gameId value of gameId
     */
    public void setGameId(Long gameId)
    {
        this.gameId = gameId;
    }

    /**
     * Gets competitionId for the class GameDTO
     *
     * @return value of competitionId
     */
    public String getCompetitionId()
    {
        return competitionId;
    }

    /**
     * Sets competitionId for the class GameDTO.
     *
     * @param competitionId value of competitionId
     */
    public void setCompetitionId(String competitionId)
    {
        this.competitionId = competitionId;
    }

    /**
     * Gets season for the class GameDTO
     *
     * @return value of season
     */
    public Year getSeason()
    {
        return season;
    }

    /**
     * Sets season for the class GameDTO.
     *
     * @param season value of season
     */
    public void setSeason(Year season)
    {
        this.season = season;
    }

    /**
     * Gets round for the class GameDTO
     *
     * @return value of round
     */
    public String getRound()
    {
        return round;
    }

    /**
     * Sets round for the class GameDTO.
     *
     * @param round value of round
     */
    public void setRound(String round)
    {
        this.round = round;
    }

    /**
     * Gets date for the class GameDTO
     *
     * @return value of date
     */
    public LocalDate getDate()
    {
        return date;
    }

    /**
     * Sets date for the class GameDTO.
     *
     * @param date value of date
     */
    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    /**
     * Gets homeClubId for the class GameDTO
     *
     * @return value of homeClubId
     */
    public Long getHomeClubId()
    {
        return homeClubId;
    }

    /**
     * Sets homeClubId for the class GameDTO.
     *
     * @param homeClubId value of homeClubId
     */
    public void setHomeClubId(Long homeClubId)
    {
        this.homeClubId = homeClubId;
    }

    /**
     * Gets awayClubId for the class GameDTO
     *
     * @return value of awayClubId
     */
    public Long getAwayClubId()
    {
        return awayClubId;
    }

    /**
     * Sets awayClubId for the class GameDTO.
     *
     * @param awayClubId value of awayClubId
     */
    public void setAwayClubId(Long awayClubId)
    {
        this.awayClubId = awayClubId;
    }

    /**
     * Gets homeClubGoals for the class GameDTO
     *
     * @return value of homeClubGoals
     */
    public Integer getHomeClubGoals()
    {
        return homeClubGoals;
    }

    /**
     * Sets homeClubGoals for the class GameDTO.
     *
     * @param homeClubGoals value of homeClubGoals
     */
    public void setHomeClubGoals(Integer homeClubGoals)
    {
        this.homeClubGoals = homeClubGoals;
    }

    /**
     * Gets awayClubGoals for the class GameDTO
     *
     * @return value of awayClubGoals
     */
    public Integer getAwayClubGoals()
    {
        return awayClubGoals;
    }

    /**
     * Sets awayClubGoals for the class GameDTO.
     *
     * @param awayClubGoals value of awayClubGoals
     */
    public void setAwayClubGoals(Integer awayClubGoals)
    {
        this.awayClubGoals = awayClubGoals;
    }

    /**
     * Gets homeClubPosition for the class GameDTO
     *
     * @return value of homeClubPosition
     */
    public Integer getHomeClubPosition()
    {
        return homeClubPosition;
    }

    /**
     * Sets homeClubPosition for the class GameDTO.
     *
     * @param homeClubPosition value of homeClubPosition
     */
    public void setHomeClubPosition(Integer homeClubPosition)
    {
        this.homeClubPosition = homeClubPosition;
    }

    /**
     * Gets awayClubPosition for the class GameDTO
     *
     * @return value of awayClubPosition
     */
    public Integer getAwayClubPosition()
    {
        return awayClubPosition;
    }

    /**
     * Sets awayClubPosition for the class GameDTO.
     *
     * @param awayClubPosition value of awayClubPosition
     */
    public void setAwayClubPosition(Integer awayClubPosition)
    {
        this.awayClubPosition = awayClubPosition;
    }

    /**
     * Gets homeClubManagerName for the class GameDTO
     *
     * @return value of homeClubManagerName
     */
    public String getHomeClubManagerName()
    {
        return homeClubManagerName;
    }

    /**
     * Sets homeClubManagerName for the class GameDTO.
     *
     * @param homeClubManagerName value of homeClubManagerName
     */
    public void setHomeClubManagerName(String homeClubManagerName)
    {
        this.homeClubManagerName = homeClubManagerName;
    }

    /**
     * Gets awayClubManagerName for the class GameDTO
     *
     * @return value of awayClubManagerName
     */
    public String getAwayClubManagerName()
    {
        return awayClubManagerName;
    }

    /**
     * Sets awayClubManagerName for the class GameDTO.
     *
     * @param awayClubManagerName value of awayClubManagerName
     */
    public void setAwayClubManagerName(String awayClubManagerName)
    {
        this.awayClubManagerName = awayClubManagerName;
    }

    /**
     * Gets stadiumName for the class GameDTO
     *
     * @return value of stadiumName
     */
    public String getStadiumName()
    {
        return stadiumName;
    }

    /**
     * Sets stadiumName for the class GameDTO.
     *
     * @param stadiumName value of stadiumName
     */
    public void setStadiumName(String stadiumName)
    {
        this.stadiumName = stadiumName;
    }

    /**
     * Gets attendance for the class GameDTO
     *
     * @return value of attendance
     */
    public Integer getAttendance()
    {
        return attendance;
    }

    /**
     * Sets attendance for the class GameDTO.
     *
     * @param attendance value of attendance
     */
    public void setAttendance(Integer attendance)
    {
        this.attendance = attendance;
    }

    /**
     * Gets refereeName for the class GameDTO
     *
     * @return value of refereeName
     */
    public String getRefereeName()
    {
        return refereeName;
    }

    /**
     * Sets refereeName for the class GameDTO.
     *
     * @param refereeName value of refereeName
     */
    public void setRefereeName(String refereeName)
    {
        this.refereeName = refereeName;
    }

    /**
     * Gets url for the class GameDTO
     *
     * @return value of url
     */
    public String getUrl()
    {
        return url;
    }

    /**
     * Sets url for the class GameDTO.
     *
     * @param url value of url
     */
    public void setUrl(String url)
    {
        this.url = url;
    }

    /**
     * Gets homeClubFormation for the class GameDTO
     *
     * @return value of homeClubFormation
     */
    public String getHomeClubFormation()
    {
        return homeClubFormation;
    }

    /**
     * Sets homeClubFormation for the class GameDTO.
     *
     * @param homeClubFormation value of homeClubFormation
     */
    public void setHomeClubFormation(String homeClubFormation)
    {
        this.homeClubFormation = homeClubFormation;
    }

    /**
     * Gets awayClubFormation for the class GameDTO
     *
     * @return value of awayClubFormation
     */
    public String getAwayClubFormation()
    {
        return awayClubFormation;
    }

    /**
     * Sets awayClubFormation for the class GameDTO.
     *
     * @param awayClubFormation value of awayClubFormation
     */
    public void setAwayClubFormation(String awayClubFormation)
    {
        this.awayClubFormation = awayClubFormation;
    }

    /**
     * Gets homeClubName for the class GameDTO
     *
     * @return value of homeClubName
     */
    public String getHomeClubName()
    {
        return homeClubName;
    }

    /**
     * Sets homeClubName for the class GameDTO.
     *
     * @param homeClubName value of homeClubName
     */
    public void setHomeClubName(String homeClubName)
    {
        this.homeClubName = homeClubName;
    }

    /**
     * Gets awayClubName for the class GameDTO
     *
     * @return value of awayClubName
     */
    public String getAwayClubName()
    {
        return awayClubName;
    }

    /**
     * Sets awayClubName for the class GameDTO.
     *
     * @param awayClubName value of awayClubName
     */
    public void setAwayClubName(String awayClubName)
    {
        this.awayClubName = awayClubName;
    }

    /**
     * Gets aggregate for the class GameDTO
     *
     * @return value of aggregate
     */
    public String getAggregate()
    {
        return aggregate;
    }

    /**
     * Sets aggregate for the class GameDTO.
     *
     * @param aggregate value of aggregate
     */
    public void setAggregate(String aggregate)
    {
        this.aggregate = aggregate;
    }

    /**
     * Gets competitionType for the class GameDTO
     *
     * @return value of competitionType
     */
    public String getCompetitionType()
    {
        return competitionType;
    }

    /**
     * Sets competitionType for the class GameDTO.
     *
     * @param competitionType value of competitionType
     */
    public void setCompetitionType(String competitionType)
    {
        this.competitionType = competitionType;
    }
}