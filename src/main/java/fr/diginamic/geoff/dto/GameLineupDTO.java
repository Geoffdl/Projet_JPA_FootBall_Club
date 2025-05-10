package fr.diginamic.geoff.dto;

public class GameLineupDTO
{
    private String gameLineUpsId;
    private int gameId;
    private int clubId;
    private String type;
    private int number;
    private int playerId;
    private String playerName;
    private boolean teamCaptain;
    private String position;

    public GameLineupDTO()
    {
    }

    /**
     * Gets gameLineUpsId for the class GameLineupDTO
     *
     * @return value of gameLineUpsId
     */
    public String getGameLineUpsId()
    {
        return gameLineUpsId;
    }

    /**
     * Sets gameLineUpsId for the class GameLineupDTO.
     *
     * @param gameLineUpsId value of gameLineUpsId
     */
    public void setGameLineUpsId(String gameLineUpsId)
    {
        this.gameLineUpsId = gameLineUpsId;
    }

    /**
     * Gets gameId for the class GameLineupDTO
     *
     * @return value of gameId
     */
    public int getGameId()
    {
        return gameId;
    }

    /**
     * Sets gameId for the class GameLineupDTO.
     *
     * @param gameId value of gameId
     */
    public void setGameId(int gameId)
    {
        this.gameId = gameId;
    }

    /**
     * Gets clubId for the class GameLineupDTO
     *
     * @return value of clubId
     */
    public int getClubId()
    {
        return clubId;
    }

    /**
     * Sets clubId for the class GameLineupDTO.
     *
     * @param clubId value of clubId
     */
    public void setClubId(int clubId)
    {
        this.clubId = clubId;
    }

    /**
     * Gets type for the class GameLineupDTO
     *
     * @return value of type
     */
    public String getType()
    {
        return type;
    }

    /**
     * Sets type for the class GameLineupDTO.
     *
     * @param type value of type
     */
    public void setType(String type)
    {
        this.type = type;
    }

    /**
     * Gets number for the class GameLineupDTO
     *
     * @return value of number
     */
    public int getNumber()
    {
        return number;
    }

    /**
     * Sets number for the class GameLineupDTO.
     *
     * @param number value of number
     */
    public void setNumber(int number)
    {
        this.number = number;
    }

    /**
     * Gets playerId for the class GameLineupDTO
     *
     * @return value of playerId
     */
    public int getPlayerId()
    {
        return playerId;
    }

    /**
     * Sets playerId for the class GameLineupDTO.
     *
     * @param playerId value of playerId
     */
    public void setPlayerId(int playerId)
    {
        this.playerId = playerId;
    }

    /**
     * Gets playerName for the class GameLineupDTO
     *
     * @return value of playerName
     */
    public String getPlayerName()
    {
        return playerName;
    }

    /**
     * Sets playerName for the class GameLineupDTO.
     *
     * @param playerName value of playerName
     */
    public void setPlayerName(String playerName)
    {
        this.playerName = playerName;
    }

    /**
     * Gets teamCaptain for the class GameLineupDTO
     *
     * @return value of teamCaptain
     */
    public boolean isTeamCaptain()
    {
        return teamCaptain;
    }

    /**
     * Sets teamCaptain for the class GameLineupDTO.
     *
     * @param teamCaptain value of teamCaptain
     */
    public void setTeamCaptain(boolean teamCaptain)
    {
        this.teamCaptain = teamCaptain;
    }

    /**
     * Gets position for the class GameLineupDTO
     *
     * @return value of position
     */
    public String getPosition()
    {
        return position;
    }

    /**
     * Sets position for the class GameLineupDTO.
     *
     * @param position value of position
     */
    public void setPosition(String position)
    {
        this.position = position;
    }
}