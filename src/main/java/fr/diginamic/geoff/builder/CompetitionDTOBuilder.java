package fr.diginamic.geoff.builder;

import fr.diginamic.geoff.dto.CompetitionDTO;
import fr.diginamic.geoff.exception.CsvFormatException;

import static fr.diginamic.geoff.utils.DTOUtils.splitDataSourceIntoArray;
import static fr.diginamic.geoff.utils.Deserializer.stringToLong;

public class CompetitionDTOBuilder implements DTOBuilder<CompetitionDTO>
{
    public CompetitionDTOBuilder()
    {
    }

    @Override
    public void setAttributes(CompetitionDTO entity, String line) throws CsvFormatException
    {
        String[] parts = splitDataSourceIntoArray(line, CompetitionDTO.class.getDeclaredFields().length);

        entity.setCompetitionId(parts[0]);
        entity.setCompetitionCode(parts[1]);
        entity.setName(parts[2]);
        entity.setSubType(parts[3]);
        entity.setType(parts[4]);
        entity.setCountryId(stringToLong(parts[5]));
        entity.setCountryName(parts[6]);
        entity.setDomesticLeagueCode(parts[7]);
        entity.setConfederation(parts[8]);
        entity.setConfederation(parts[9]);
    }

    @Override
    public CompetitionDTO createInstance()
    {
        return new CompetitionDTO();
    }
}