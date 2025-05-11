package fr.diginamic.geoff.mapper;

import fr.diginamic.geoff.dto.CompetitionDTO;
import fr.diginamic.geoff.entity.Competition;
import fr.diginamic.geoff.entity.Country;
import fr.diginamic.geoff.entity.Url;
import fr.diginamic.geoff.entity.lookup.EntityType;

/**
 *
 */
public class CompetitionDTOMapper
{
    private final CompetitionDTO dto;

    public CompetitionDTOMapper(CompetitionDTO dto)
    {
        this.dto = dto;
    }

    public Competition mapToCompetition(Competition competition)
    {
        competition.setSourceId(dto.getCompetitionId());
        competition.setCompetitionCode(dto.getCompetitionCode());
        competition.setCompetitionName(dto.getName());
        competition.setCompetitionSubtype(dto.getSubType());
        competition.setCompetitionType(dto.getType());
        competition.setDomesticLeagueCode(dto.getDomesticLeagueCode());
        competition.setConfederation(dto.getConfederation());
        return competition;

    }

    public Country mapToCountry(Country country)
    {
        country.setSourceId(dto.getCountryId());
        country.setNom(dto.getCountryName());
        return country;
    }

    public Url mapToUrl(Url url)
    {
        url.setUrl(dto.getUrl());
        url.setEntityType(EntityType.COUNTRY);
        return url;
    }
}