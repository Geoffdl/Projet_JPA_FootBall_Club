package fr.diginamic.geoff.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;

public class PlayerDTO
{
    private int playerId;
    private String firstName;
    private String lastName;
    private String name;
    private Year lastSeason;
    private int currentClubId;
    private String playerCode;
    private String countryOfBirth;
    private String cityOfBirth;
    private String countryOfCitizenship;
    private LocalDate dateOfBirth;
    private String subPosition;
    private String position;
    private String foot;
    private int heightInCm;
    private int marketValueInEur;
    private double highestMaketValue;
    private LocalDateTime contractExpirationDate;
    private String agentName;
    private String imageUrl;
    private String url;
    private String currentClubDomesticCompetitionId;
    private String currentClubName;


    public PlayerDTO()
    {
    }

    /**
     * Gets url for the class PlayerDTO
     *
     * @return value of url
     */
    public String getUrl()
    {
        return url;
    }

    /**
     * Sets url for the class PlayerDTO.
     *
     * @param url value of url
     */
    public void setUrl(String url)
    {
        this.url = url;
    }

    /**
     * Gets playerId for the class PlayerDTO
     *
     * @return value of playerId
     */
    public int getPlayerId()
    {
        return playerId;
    }

    /**
     * Sets playerId for the class PlayerDTO.
     *
     * @param playerId value of playerId
     */
    public void setPlayerId(int playerId)
    {
        this.playerId = playerId;
    }

    /**
     * Gets firstName for the class PlayerDTO
     *
     * @return value of firstName
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Sets firstName for the class PlayerDTO.
     *
     * @param firstName value of firstName
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Gets lastName for the class PlayerDTO
     *
     * @return value of lastName
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Sets lastName for the class PlayerDTO.
     *
     * @param lastName value of lastName
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Gets name for the class PlayerDTO
     *
     * @return value of name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets name for the class PlayerDTO.
     *
     * @param name value of name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets lastSeason for the class PlayerDTO
     *
     * @return value of lastSeason
     */
    public Year getLastSeason()
    {
        return lastSeason;
    }

    /**
     * Sets lastSeason for the class PlayerDTO.
     *
     * @param lastSeason value of lastSeason
     */
    public void setLastSeason(Year lastSeason)
    {
        this.lastSeason = lastSeason;
    }

    /**
     * Gets currentClubId for the class PlayerDTO
     *
     * @return value of currentClubId
     */
    public int getCurrentClubId()
    {
        return currentClubId;
    }

    /**
     * Sets currentClubId for the class PlayerDTO.
     *
     * @param currentClubId value of currentClubId
     */
    public void setCurrentClubId(int currentClubId)
    {
        this.currentClubId = currentClubId;
    }

    /**
     * Gets playerCode for the class PlayerDTO
     *
     * @return value of playerCode
     */
    public String getPlayerCode()
    {
        return playerCode;
    }

    /**
     * Sets playerCode for the class PlayerDTO.
     *
     * @param playerCode value of playerCode
     */
    public void setPlayerCode(String playerCode)
    {
        this.playerCode = playerCode;
    }

    /**
     * Gets countryOfBirth for the class PlayerDTO
     *
     * @return value of countryOfBirth
     */
    public String getCountryOfBirth()
    {
        return countryOfBirth;
    }

    /**
     * Sets countryOfBirth for the class PlayerDTO.
     *
     * @param countryOfBirth value of countryOfBirth
     */
    public void setCountryOfBirth(String countryOfBirth)
    {
        this.countryOfBirth = countryOfBirth;
    }

    /**
     * Gets cityOfBirth for the class PlayerDTO
     *
     * @return value of cityOfBirth
     */
    public String getCityOfBirth()
    {
        return cityOfBirth;
    }

    /**
     * Sets cityOfBirth for the class PlayerDTO.
     *
     * @param cityOfBirth value of cityOfBirth
     */
    public void setCityOfBirth(String cityOfBirth)
    {
        this.cityOfBirth = cityOfBirth;
    }

    /**
     * Gets countryOfCitizenship for the class PlayerDTO
     *
     * @return value of countryOfCitizenship
     */
    public String getCountryOfCitizenship()
    {
        return countryOfCitizenship;
    }

    /**
     * Sets countryOfCitizenship for the class PlayerDTO.
     *
     * @param countryOfCitizenship value of countryOfCitizenship
     */
    public void setCountryOfCitizenship(String countryOfCitizenship)
    {
        this.countryOfCitizenship = countryOfCitizenship;
    }

    /**
     * Gets dateOfBirth for the class PlayerDTO
     *
     * @return value of dateOfBirth
     */
    public LocalDate getDateOfBirth()
    {
        return dateOfBirth;
    }

    /**
     * Sets dateOfBirth for the class PlayerDTO.
     *
     * @param dateOfBirth value of dateOfBirth
     */
    public void setDateOfBirth(LocalDate dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets subPosition for the class PlayerDTO
     *
     * @return value of subPosition
     */
    public String getSubPosition()
    {
        return subPosition;
    }

    /**
     * Sets subPosition for the class PlayerDTO.
     *
     * @param subPosition value of subPosition
     */
    public void setSubPosition(String subPosition)
    {
        this.subPosition = subPosition;
    }

    /**
     * Gets position for the class PlayerDTO
     *
     * @return value of position
     */
    public String getPosition()
    {
        return position;
    }

    /**
     * Sets position for the class PlayerDTO.
     *
     * @param position value of position
     */
    public void setPosition(String position)
    {
        this.position = position;
    }

    /**
     * Gets foot for the class PlayerDTO
     *
     * @return value of foot
     */
    public String getFoot()
    {
        return foot;
    }

    /**
     * Sets foot for the class PlayerDTO.
     *
     * @param foot value of foot
     */
    public void setFoot(String foot)
    {
        this.foot = foot;
    }

    /**
     * Gets heightInCm for the class PlayerDTO
     *
     * @return value of heightInCm
     */
    public int getHeightInCm()
    {
        return heightInCm;
    }

    /**
     * Sets heightInCm for the class PlayerDTO.
     *
     * @param heightInCm value of heightInCm
     */
    public void setHeightInCm(int heightInCm)
    {
        this.heightInCm = heightInCm;
    }

    /**
     * Gets marketValueInEur for the class PlayerDTO
     *
     * @return value of marketValueInEur
     */
    public int getMarketValueInEur()
    {
        return marketValueInEur;
    }

    /**
     * Sets marketValueInEur for the class PlayerDTO.
     *
     * @param marketValueInEur value of marketValueInEur
     */
    public void setMarketValueInEur(int marketValueInEur)
    {
        this.marketValueInEur = marketValueInEur;
    }

    /**
     * Gets highestMaketValue for the class PlayerDTO
     *
     * @return value of highestMaketValue
     */
    public double getHighestMaketValue()
    {
        return highestMaketValue;
    }

    /**
     * Sets highestMaketValue for the class PlayerDTO.
     *
     * @param highestMaketValue value of highestMaketValue
     */
    public void setHighestMaketValue(double highestMaketValue)
    {
        this.highestMaketValue = highestMaketValue;
    }

    /**
     * Gets contractExpirationDate for the class PlayerDTO
     *
     * @return value of contractExpirationDate
     */
    public LocalDateTime getContractExpirationDate()
    {
        return contractExpirationDate;
    }

    /**
     * Sets contractExpirationDate for the class PlayerDTO.
     *
     * @param contractExpirationDate value of contractExpirationDate
     */
    public void setContractExpirationDate(LocalDateTime contractExpirationDate)
    {
        this.contractExpirationDate = contractExpirationDate;
    }

    /**
     * Gets agentName for the class PlayerDTO
     *
     * @return value of agentName
     */
    public String getAgentName()
    {
        return agentName;
    }

    /**
     * Sets agentName for the class PlayerDTO.
     *
     * @param agentName value of agentName
     */
    public void setAgentName(String agentName)
    {
        this.agentName = agentName;
    }

    /**
     * Gets imageUrl for the class PlayerDTO
     *
     * @return value of imageUrl
     */
    public String getImageUrl()
    {
        return imageUrl;
    }

    /**
     * Sets imageUrl for the class PlayerDTO.
     *
     * @param imageUrl value of imageUrl
     */
    public void setImageUrl(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }

    /**
     * Gets currentClubDomesticCompetitionId for the class PlayerDTO
     *
     * @return value of currentClubDomesticCompetitionId
     */
    public String getCurrentClubDomesticCompetitionId()
    {
        return currentClubDomesticCompetitionId;
    }

    /**
     * Sets currentClubDomesticCompetitionId for the class PlayerDTO.
     *
     * @param currentClubDomesticCompetitionId value of currentClubDomesticCompetitionId
     */
    public void setCurrentClubDomesticCompetitionId(String currentClubDomesticCompetitionId)
    {
        this.currentClubDomesticCompetitionId = currentClubDomesticCompetitionId;
    }

    /**
     * Gets currentClub for the class PlayerDTO
     *
     * @return value of currentClub
     */
    public String getCurrentClubName()
    {
        return currentClubName;
    }

    /**
     * Sets currentClub for the class PlayerDTO.
     *
     * @param currentClubName value of currentClub
     */
    public void setCurrentClubName(String currentClubName)
    {
        this.currentClubName = currentClubName;
    }
}