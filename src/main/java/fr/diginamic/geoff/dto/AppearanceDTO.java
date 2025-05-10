package fr.diginamic.geoff.dto;

import java.time.LocalDate;

public class AppearanceDTO
{
    private double appearanceId;
    private int gameId;
    private int playerId;
    private int playerClubId;
    private int playerCurrentClubId;
    private LocalDate date;
    private String playerName;
    private String competitionId;
    private int yellowCard;
    private int redCard;
    private int goals;
    private int assists;
    private int minutesPlayed;

    public AppearanceDTO()
    {
    }

    /**
     * Gets appearanceId for the class AppearanceDTO
     *
     * @return value of appearanceId
     */
    public double getAppearanceId()
    {
        return appearanceId;
    }

    /**
     * Sets appearanceId for the class AppearanceDTO.
     *
     * @param appearanceId value of appearanceId
     */
    public void setAppearanceId(double appearanceId)
    {
        this.appearanceId = appearanceId;
    }

    /**
     * Gets gameId for the class AppearanceDTO
     *
     * @return value of gameId
     */
    public int getGameId()
    {
        return gameId;
    }

    /**
     * Sets gameId for the class AppearanceDTO.
     *
     * @param gameId value of gameId
     */
    public void setGameId(int gameId)
    {
        this.gameId = gameId;
    }

    /**
     * Gets playerId for the class AppearanceDTO
     *
     * @return value of playerId
     */
    public int getPlayerId()
    {
        return playerId;
    }

    /**
     * Sets playerId for the class AppearanceDTO.
     *
     * @param playerId value of playerId
     */
    public void setPlayerId(int playerId)
    {
        this.playerId = playerId;
    }

    /**
     * Gets playerClubId for the class AppearanceDTO
     *
     * @return value of playerClubId
     */
    public int getPlayerClubId()
    {
        return playerClubId;
    }

    /**
     * Sets playerClubId for the class AppearanceDTO.
     *
     * @param playerClubId value of playerClubId
     */
    public void setPlayerClubId(int playerClubId)
    {
        this.playerClubId = playerClubId;
    }

    /**
     * Gets playerCurrentClubId for the class AppearanceDTO
     *
     * @return value of playerCurrentClubId
     */
    public int getPlayerCurrentClubId()
    {
        return playerCurrentClubId;
    }

    /**
     * Sets playerCurrentClubId for the class AppearanceDTO.
     *
     * @param playerCurrentClubId value of playerCurrentClubId
     */
    public void setPlayerCurrentClubId(int playerCurrentClubId)
    {
        this.playerCurrentClubId = playerCurrentClubId;
    }

    /**
     * Gets date for the class AppearanceDTO
     *
     * @return value of date
     */
    public LocalDate getDate()
    {
        return date;
    }

    /**
     * Sets date for the class AppearanceDTO.
     *
     * @param date value of date
     */
    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    /**
     * Gets playerName for the class AppearanceDTO
     *
     * @return value of playerName
     */
    public String getPlayerName()
    {
        return playerName;
    }

    /**
     * Sets playerName for the class AppearanceDTO.
     *
     * @param playerName value of playerName
     */
    public void setPlayerName(String playerName)
    {
        this.playerName = playerName;
    }

    /**
     * Gets competitionId for the class AppearanceDTO
     *
     * @return value of competitionId
     */
    public String getCompetitionId()
    {
        return competitionId;
    }

    /**
     * Sets competitionId for the class AppearanceDTO.
     *
     * @param competitionId value of competitionId
     */
    public void setCompetitionId(String competitionId)
    {
        this.competitionId = competitionId;
    }

    /**
     * Gets yellowCard for the class AppearanceDTO
     *
     * @return value of yellowCard
     */
    public int getYellowCard()
    {
        return yellowCard;
    }

    /**
     * Sets yellowCard for the class AppearanceDTO.
     *
     * @param yellowCard value of yellowCard
     */
    public void setYellowCard(int yellowCard)
    {
        this.yellowCard = yellowCard;
    }

    /**
     * Gets redCard for the class AppearanceDTO
     *
     * @return value of redCard
     */
    public int getRedCard()
    {
        return redCard;
    }

    /**
     * Sets redCard for the class AppearanceDTO.
     *
     * @param redCard value of redCard
     */
    public void setRedCard(int redCard)
    {
        this.redCard = redCard;
    }

    /**
     * Gets goals for the class AppearanceDTO
     *
     * @return value of goals
     */
    public int getGoals()
    {
        return goals;
    }

    /**
     * Sets goals for the class AppearanceDTO.
     *
     * @param goals value of goals
     */
    public void setGoals(int goals)
    {
        this.goals = goals;
    }

    /**
     * Gets assists for the class AppearanceDTO
     *
     * @return value of assists
     */
    public int getAssists()
    {
        return assists;
    }

    /**
     * Sets assists for the class AppearanceDTO.
     *
     * @param assists value of assists
     */
    public void setAssists(int assists)
    {
        this.assists = assists;
    }

    /**
     * Gets minutesPlayed for the class AppearanceDTO
     *
     * @return value of minutesPlayed
     */
    public int getMinutesPlayed()
    {
        return minutesPlayed;
    }

    /**
     * Sets minutesPlayed for the class AppearanceDTO.
     *
     * @param minutesPlayed value of minutesPlayed
     */
    public void setMinutesPlayed(int minutesPlayed)
    {
        this.minutesPlayed = minutesPlayed;
    }
}