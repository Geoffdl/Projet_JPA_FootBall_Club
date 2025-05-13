package fr.diginamic.geoff.builder;

import fr.diginamic.geoff.dto.PlayerValuationDTO;
import fr.diginamic.geoff.exception.CsvFormatException;

import java.time.Year;

import static fr.diginamic.geoff.utils.DTOUtils.splitDataSourceIntoArray;
import static fr.diginamic.geoff.utils.Deserializer.*;

/**
 * Fills dto with parsed data from the csv file
 */
public class PlayerValuationDTOBuilder implements DTOBuilder<PlayerValuationDTO>
{
    @Override
    public void setAttributes(PlayerValuationDTO entity, String line) throws CsvFormatException
    {
        String[] parts = splitDataSourceIntoArray(line, PlayerValuationDTO.class.getDeclaredFields().length);

        entity.setPlayerId(stringToInt(parts[0]));
        entity.setLastSeason(Year.of(stringToInt(parts[1])));
        entity.setDatetime(stringToLocalDateTime(parts[2]));
        entity.setDate(stringToLocalDate(parts[3]));
        entity.setMarketValue(stringToDouble(parts[4]));
        entity.setN(stringToInt(parts[5]));
        entity.setCurrentClubId(stringToInt(parts[6]));
        entity.setPlayerClubDomesticCompetitionId(parts[7]);

    }

    @Override
    public PlayerValuationDTO createInstance()
    {
        return new PlayerValuationDTO();
    }
}