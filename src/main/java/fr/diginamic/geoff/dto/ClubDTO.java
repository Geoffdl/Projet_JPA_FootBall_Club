package fr.diginamic.geoff.dto;

import java.time.Year;

/**
 * Contains all related elements from the csv file
 */
public class ClubDTO
{
    private Long clubId;
    private String clubCode;
    private String name;
    private String domesticCompetitionId;
    private Double totalMarketValue;
    private int squadSize;
    private double averageAge;
    private int foreignersNumber;
    private double foreignerPercentage;
    private int nationalTeamPlayers;
    private String stadiumName;
    private int stadiumSeats;
    private double netTransferRecord;
    private String coachName;
    private Year lastSeason;
    private String url;


    public ClubDTO()
    {
    }

    /**
     * Gets clubId for the class ClubDTO
     *
     * @return value of clubId
     */
    public Long getClubId()
    {
        return clubId;
    }

    /**
     * Sets clubId for the class ClubDTO.
     *
     * @param clubId value of clubId
     */
    public void setClubId(Long clubId)
    {
        this.clubId = clubId;
    }

    /**
     * Gets clubCode for the class ClubDTO
     *
     * @return value of clubCode
     */
    public String getClubCode()
    {
        return clubCode;
    }

    /**
     * Sets clubCode for the class ClubDTO.
     *
     * @param clubCode value of clubCode
     */
    public void setClubCode(String clubCode)
    {
        this.clubCode = clubCode;
    }

    /**
     * Gets name for the class ClubDTO
     *
     * @return value of name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets name for the class ClubDTO.
     *
     * @param name value of name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets domesticCompetitionId for the class ClubDTO
     *
     * @return value of domesticCompetitionId
     */
    public String getDomesticCompetitionId()
    {
        return domesticCompetitionId;
    }

    /**
     * Sets domesticCompetitionId for the class ClubDTO.
     *
     * @param domesticCompetitionId value of domesticCompetitionId
     */
    public void setDomesticCompetitionId(String domesticCompetitionId)
    {
        this.domesticCompetitionId = domesticCompetitionId;
    }

    /**
     * Gets totalMarketValue for the class ClubDTO
     *
     * @return value of totalMarketValue
     */
    public double getTotalMarketValue()
    {
        return totalMarketValue;
    }

    /**
     * Sets totalMarketValue for the class ClubDTO.
     *
     * @param totalMarketValue value of totalMarketValue
     */
    public void setTotalMarketValue(double totalMarketValue)
    {
        this.totalMarketValue = totalMarketValue;
    }

    /**
     * Gets squadSize for the class ClubDTO
     *
     * @return value of squadSize
     */
    public int getSquadSize()
    {
        return squadSize;
    }

    /**
     * Sets squadSize for the class ClubDTO.
     *
     * @param squadSize value of squadSize
     */
    public void setSquadSize(int squadSize)
    {
        this.squadSize = squadSize;
    }

    /**
     * Gets averageAge for the class ClubDTO
     *
     * @return value of averageAge
     */
    public double getAverageAge()
    {
        return averageAge;
    }

    /**
     * Sets averageAge for the class ClubDTO.
     *
     * @param averageAge value of averageAge
     */
    public void setAverageAge(double averageAge)
    {
        this.averageAge = averageAge;
    }

    /**
     * Gets foreignersNumber for the class ClubDTO
     *
     * @return value of foreignersNumber
     */
    public int getForeignersNumber()
    {
        return foreignersNumber;
    }

    /**
     * Sets foreignersNumber for the class ClubDTO.
     *
     * @param foreignersNumber value of foreignersNumber
     */
    public void setForeignersNumber(int foreignersNumber)
    {
        this.foreignersNumber = foreignersNumber;
    }

    /**
     * Gets foreignerPercentage for the class ClubDTO
     *
     * @return value of foreignerPercentage
     */
    public double getForeignerPercentage()
    {
        return foreignerPercentage;
    }

    /**
     * Sets foreignerPercentage for the class ClubDTO.
     *
     * @param foreignerPercentage value of foreignerPercentage
     */
    public void setForeignerPercentage(double foreignerPercentage)
    {
        this.foreignerPercentage = foreignerPercentage;
    }

    /**
     * Gets nationalTeamPlayers for the class ClubDTO
     *
     * @return value of nationalTeamPlayers
     */
    public int getNationalTeamPlayers()
    {
        return nationalTeamPlayers;
    }

    /**
     * Sets nationalTeamPlayers for the class ClubDTO.
     *
     * @param nationalTeamPlayers value of nationalTeamPlayers
     */
    public void setNationalTeamPlayers(int nationalTeamPlayers)
    {
        this.nationalTeamPlayers = nationalTeamPlayers;
    }

    /**
     * Gets stadiumName for the class ClubDTO
     *
     * @return value of stadiumName
     */
    public String getStadiumName()
    {
        return stadiumName;
    }

    /**
     * Sets stadiumName for the class ClubDTO.
     *
     * @param stadiumName value of stadiumName
     */
    public void setStadiumName(String stadiumName)
    {
        this.stadiumName = stadiumName;
    }

    /**
     * Gets stadiumSeats for the class ClubDTO
     *
     * @return value of stadiumSeats
     */
    public int getStadiumSeats()
    {
        return stadiumSeats;
    }

    /**
     * Sets stadiumSeats for the class ClubDTO.
     *
     * @param stadiumSeats value of stadiumSeats
     */
    public void setStadiumSeats(int stadiumSeats)
    {
        this.stadiumSeats = stadiumSeats;
    }

    /**
     * Gets netTransferRecord for the class ClubDTO
     *
     * @return value of netTransferRecord
     */
    public Double getNetTransferRecord()
    {
        return netTransferRecord;
    }

    /**
     * Sets netTransferRecord for the class ClubDTO.
     *
     * @param netTransferRecord value of netTransferRecord
     */
    public void setNetTransferRecord(Double netTransferRecord)
    {
        this.netTransferRecord = netTransferRecord;
    }

    /**
     * Gets coachName for the class ClubDTO
     *
     * @return value of coachName
     */
    public String getCoachName()
    {
        return coachName;
    }

    /**
     * Sets coachName for the class ClubDTO.
     *
     * @param coachName value of coachName
     */
    public void setCoachName(String coachName)
    {
        this.coachName = coachName;
    }

    /**
     * Gets lastSeason for the class ClubDTO
     *
     * @return value of lastSeason
     */
    public Year getLastSeason()
    {
        return lastSeason;
    }

    /**
     * Sets lastSeason for the class ClubDTO.
     *
     * @param lastSeason value of lastSeason
     */
    public void setLastSeason(Year lastSeason)
    {
        this.lastSeason = lastSeason;
    }

    /**
     * Gets url for the class ClubDTO
     *
     * @return value of url
     */
    public String getUrl()
    {
        return url;
    }

    /**
     * Sets url for the class ClubDTO.
     *
     * @param url value of url
     */
    public void setUrl(String url)
    {
        this.url = url;
    }
}