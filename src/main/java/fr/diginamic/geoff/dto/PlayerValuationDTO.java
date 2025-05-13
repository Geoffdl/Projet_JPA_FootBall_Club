package fr.diginamic.geoff.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;

/**
 * Contains all related elements from the csv file
 */
public class PlayerValuationDTO
{
    private int playerId;
    private Year lastSeason;
    private LocalDateTime datetime;
    private LocalDate date;
    private LocalDate dateWeek;
    private double marketValue;
    private int n;
    private int currentClubId;
    private String playerClubDomesticCompetitionId;

    public PlayerValuationDTO()
    {
    }

    /**
     * Gets playerId for the class PlayerValuationDTO
     *
     * @return value of playerId
     */
    public int getPlayerId()
    {
        return playerId;
    }

    /**
     * Sets playerId for the class PlayerValuationDTO.
     *
     * @param playerId value of playerId
     */
    public void setPlayerId(int playerId)
    {
        this.playerId = playerId;
    }

    /**
     * Gets lastSeason for the class PlayerValuationDTO
     *
     * @return value of lastSeason
     */
    public Year getLastSeason()
    {
        return lastSeason;
    }

    /**
     * Sets lastSeason for the class PlayerValuationDTO.
     *
     * @param lastSeason value of lastSeason
     */
    public void setLastSeason(Year lastSeason)
    {
        this.lastSeason = lastSeason;
    }

    /**
     * Gets datetime for the class PlayerValuationDTO
     *
     * @return value of datetime
     */
    public LocalDateTime getDatetime()
    {
        return datetime;
    }

    /**
     * Sets datetime for the class PlayerValuationDTO.
     *
     * @param datetime value of datetime
     */
    public void setDatetime(LocalDateTime datetime)
    {
        this.datetime = datetime;
    }

    /**
     * Gets date for the class PlayerValuationDTO
     *
     * @return value of date
     */
    public LocalDate getDate()
    {
        return date;
    }

    /**
     * Sets date for the class PlayerValuationDTO.
     *
     * @param date value of date
     */
    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    /**
     * Gets dateWeek for the class PlayerValuationDTO
     *
     * @return value of dateWeek
     */
    public LocalDate getDateWeek()
    {
        return dateWeek;
    }

    /**
     * Sets dateWeek for the class PlayerValuationDTO.
     *
     * @param dateWeek value of dateWeek
     */
    public void setDateWeek(LocalDate dateWeek)
    {
        this.dateWeek = dateWeek;
    }

    /**
     * Gets marketValue for the class PlayerValuationDTO
     *
     * @return value of marketValue
     */
    public double getMarketValue()
    {
        return marketValue;
    }

    /**
     * Sets marketValue for the class PlayerValuationDTO.
     *
     * @param marketValue value of marketValue
     */
    public void setMarketValue(double marketValue)
    {
        this.marketValue = marketValue;
    }

    /**
     * Gets n for the class PlayerValuationDTO
     *
     * @return value of n
     */
    public int getN()
    {
        return n;
    }

    /**
     * Sets n for the class PlayerValuationDTO.
     *
     * @param n value of n
     */
    public void setN(int n)
    {
        this.n = n;
    }

    /**
     * Gets currentClubId for the class PlayerValuationDTO
     *
     * @return value of currentClubId
     */
    public int getCurrentClubId()
    {
        return currentClubId;
    }

    /**
     * Sets currentClubId for the class PlayerValuationDTO.
     *
     * @param currentClubId value of currentClubId
     */
    public void setCurrentClubId(int currentClubId)
    {
        this.currentClubId = currentClubId;
    }

    /**
     * Gets playerClubDomesticCompetitionId for the class PlayerValuationDTO
     *
     * @return value of playerClubDomesticCompetitionId
     */
    public String getPlayerClubDomesticCompetitionId()
    {
        return playerClubDomesticCompetitionId;
    }

    /**
     * Sets playerClubDomesticCompetitionId for the class PlayerValuationDTO.
     *
     * @param playerClubDomesticCompetitionId value of playerClubDomesticCompetitionId
     */
    public void setPlayerClubDomesticCompetitionId(String playerClubDomesticCompetitionId)
    {
        this.playerClubDomesticCompetitionId = playerClubDomesticCompetitionId;
    }
}