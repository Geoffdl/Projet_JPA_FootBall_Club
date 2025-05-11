package fr.diginamic.geoff.dto;

public class CompetitionDTO
{
    private String competitionId;
    private String competitionCode;
    private String name;
    private String subType;
    private String type;
    private Long countryId;
    private String countryName;
    private String domesticLeagueCode;
    private String confederation;
    private String url;

    public CompetitionDTO()
    {
    }

    public CompetitionDTO(String competitionId, String competitionCode, String name, String subType, String type, Long countryId, String countryName, String domesticLeagueCode, String confederation, String url)
    {
        this.competitionId = competitionId;
        this.competitionCode = competitionCode;
        this.name = name;
        this.subType = subType;
        this.type = type;
        this.countryId = countryId;
        this.countryName = countryName;
        this.domesticLeagueCode = domesticLeagueCode;
        this.confederation = confederation;
        this.url = url;
    }

    /**
     * Gets competitionId for the class CompetitionDTO
     *
     * @return value of competitionId
     */
    public String getCompetitionId()
    {
        return competitionId;
    }

    /**
     * Sets competitionId for the class CompetitionDTO.
     *
     * @param competitionId value of competitionId
     */
    public void setCompetitionId(String competitionId)
    {
        this.competitionId = competitionId;
    }

    /**
     * Gets competitionCode for the class CompetitionDTO
     *
     * @return value of competitionCode
     */
    public String getCompetitionCode()
    {
        return competitionCode;
    }

    /**
     * Sets competitionCode for the class CompetitionDTO.
     *
     * @param competitionCode value of competitionCode
     */
    public void setCompetitionCode(String competitionCode)
    {
        this.competitionCode = competitionCode;
    }

    /**
     * Gets name for the class CompetitionDTO
     *
     * @return value of name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets name for the class CompetitionDTO.
     *
     * @param name value of name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets subType for the class CompetitionDTO
     *
     * @return value of subType
     */
    public String getSubType()
    {
        return subType;
    }

    /**
     * Sets subType for the class CompetitionDTO.
     *
     * @param subType value of subType
     */
    public void setSubType(String subType)
    {
        this.subType = subType;
    }

    /**
     * Gets type for the class CompetitionDTO
     *
     * @return value of type
     */
    public String getType()
    {
        return type;
    }

    /**
     * Sets type for the class CompetitionDTO.
     *
     * @param type value of type
     */
    public void setType(String type)
    {
        this.type = type;
    }

    /**
     * Gets countryId for the class CompetitionDTO
     *
     * @return value of countryId
     */
    public Long getCountryId()
    {
        return countryId;
    }

    /**
     * Sets countryId for the class CompetitionDTO.
     *
     * @param countryId value of countryId
     */
    public void setCountryId(Long countryId)
    {
        this.countryId = countryId;
    }

    /**
     * Gets countryName for the class CompetitionDTO
     *
     * @return value of countryName
     */
    public String getCountryName()
    {
        return countryName;
    }

    /**
     * Sets countryName for the class CompetitionDTO.
     *
     * @param countryName value of countryName
     */
    public void setCountryName(String countryName)
    {
        this.countryName = countryName;
    }

    /**
     * Gets domesticLeagueCode for the class CompetitionDTO
     *
     * @return value of domesticLeagueCode
     */
    public String getDomesticLeagueCode()
    {
        return domesticLeagueCode;
    }

    /**
     * Sets domesticLeagueCode for the class CompetitionDTO.
     *
     * @param domesticLeagueCode value of domesticLeagueCode
     */
    public void setDomesticLeagueCode(String domesticLeagueCode)
    {
        this.domesticLeagueCode = domesticLeagueCode;
    }

    /**
     * Gets confederation for the class CompetitionDTO
     *
     * @return value of confederation
     */
    public String getConfederation()
    {
        return confederation;
    }

    /**
     * Sets confederation for the class CompetitionDTO.
     *
     * @param confederation value of confederation
     */
    public void setConfederation(String confederation)
    {
        this.confederation = confederation;
    }

    /**
     * Gets url for the class CompetitionDTO
     *
     * @return value of url
     */
    public String getUrl()
    {
        return url;
    }

    /**
     * Sets url for the class CompetitionDTO.
     *
     * @param url value of url
     */
    public void setUrl(String url)
    {
        this.url = url;
    }
}