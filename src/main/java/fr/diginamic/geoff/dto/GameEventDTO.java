package fr.diginamic.geoff.dto;

import java.time.LocalDate;

public class GameEventDTO
{
    private String gameEventId;
    private LocalDate date;
    private int gameId;
    private int minute;
    private String type;
    private int ClubId;
    private int playerId;
    private String description;
    private int playerInId;
    private int playerAssistId;

    public GameEventDTO()
    {
    }

    /**
     * Gets gameEventId for the class GameEventDTO
     *
     * @return value of gameEventId
     */
    public String getGameEventId()
    {
        return gameEventId;
    }

    /**
     * Sets gameEventId for the class GameEventDTO.
     *
     * @param gameEventId value of gameEventId
     */
    public void setGameEventId(String gameEventId)
    {
        this.gameEventId = gameEventId;
    }

    /**
     * Gets date for the class GameEventDTO
     *
     * @return value of date
     */
    public LocalDate getDate()
    {
        return date;
    }

    /**
     * Sets date for the class GameEventDTO.
     *
     * @param date value of date
     */
    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    /**
     * Gets gameId for the class GameEventDTO
     *
     * @return value of gameId
     */
    public int getGameId()
    {
        return gameId;
    }

    /**
     * Sets gameId for the class GameEventDTO.
     *
     * @param gameId value of gameId
     */
    public void setGameId(int gameId)
    {
        this.gameId = gameId;
    }

    /**
     * Gets minute for the class GameEventDTO
     *
     * @return value of minute
     */
    public int getMinute()
    {
        return minute;
    }

    /**
     * Sets minute for the class GameEventDTO.
     *
     * @param minute value of minute
     */
    public void setMinute(int minute)
    {
        this.minute = minute;
    }

    /**
     * Gets type for the class GameEventDTO
     *
     * @return value of type
     */
    public String getType()
    {
        return type;
    }

    /**
     * Sets type for the class GameEventDTO.
     *
     * @param type value of type
     */
    public void setType(String type)
    {
        this.type = type;
    }

    /**
     * Gets ClubId for the class GameEventDTO
     *
     * @return value of ClubId
     */
    public int getClubId()
    {
        return ClubId;
    }

    /**
     * Sets ClubId for the class GameEventDTO.
     *
     * @param ClubId value of ClubId
     */
    public void setClubId(int clubId)
    {
        ClubId = clubId;
    }

    /**
     * Gets playerId for the class GameEventDTO
     *
     * @return value of playerId
     */
    public int getPlayerId()
    {
        return playerId;
    }

    /**
     * Sets playerId for the class GameEventDTO.
     *
     * @param playerId value of playerId
     */
    public void setPlayerId(int playerId)
    {
        this.playerId = playerId;
    }

    /**
     * Gets description for the class GameEventDTO
     *
     * @return value of description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Sets description for the class GameEventDTO.
     *
     * @param description value of description
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Gets playerInId for the class GameEventDTO
     *
     * @return value of playerInId
     */
    public int getPlayerInId()
    {
        return playerInId;
    }

    /**
     * Sets playerInId for the class GameEventDTO.
     *
     * @param playerInId value of playerInId
     */
    public void setPlayerInId(int playerInId)
    {
        this.playerInId = playerInId;
    }

    /**
     * Gets playerAssistId for the class GameEventDTO
     *
     * @return value of playerAssistId
     */
    public int getPlayerAssistId()
    {
        return playerAssistId;
    }

    /**
     * Sets playerAssistId for the class GameEventDTO.
     *
     * @param playerAssistId value of playerAssistId
     */
    public void setPlayerAssistId(int playerAssistId)
    {
        this.playerAssistId = playerAssistId;
    }
}