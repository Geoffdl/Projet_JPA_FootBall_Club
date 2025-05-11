package fr.diginamic.geoff.builder;

import fr.diginamic.geoff.dto.PlayerDTO;
import fr.diginamic.geoff.exception.CsvFormatException;
import fr.diginamic.geoff.utils.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Year;
import java.util.List;

import static fr.diginamic.geoff.utils.DTOUtils.splitDataSourceIntoArray;


public class PlayerDTOBuilder implements DTOBuilder<PlayerDTO>
{

    public PlayerDTOBuilder()
    {
    }

    @Override
    public void setAttributes(PlayerDTO playerDTO, String line)
    {
        String[] parts = splitDataSourceIntoArray(line.trim(), PlayerDTO.class.getDeclaredFields().length);



        playerDTO.setPlayerId(Deserializer.stringToLong(parts[0]));
        playerDTO.setFirstName(parts[1]);
        playerDTO.setLastName(parts[2]);
        playerDTO.setName(parts[3]);
        playerDTO.setLastSeason(Year.of(Deserializer.stringToInt(parts[4])));
        playerDTO.setCurrentClubId(Deserializer.stringToLong(parts[5]));
        playerDTO.setPlayerCode(parts[6]);
        playerDTO.setCountryOfBirth(parts[7]);
        playerDTO.setCityOfBirth(parts[8]);
        playerDTO.setCountryOfCitizenship(parts[9]);
        playerDTO.setDateOfBirth(Deserializer.stringToLocalDate(parts[10]));
        playerDTO.setSubPosition(parts[11]);
        playerDTO.setPosition(parts[12]);
        playerDTO.setFoot(parts[13]);
        playerDTO.setHeightInCm(Deserializer.stringToInt(parts[14]));
        playerDTO.setMarketValueInEur(Deserializer.stringToInt(parts[15]));
        playerDTO.setHighestMarketValue(Deserializer.stringToInt(parts[16]));
        playerDTO.setContractExpirationDate(Deserializer.stringToLocalDateTime(parts[17]));
        playerDTO.setAgentName(parts[18]);
        playerDTO.setImageUrl(parts[19]);
        playerDTO.setUrl(parts[20]);
        playerDTO.setCurrentClubDomesticCompetitionId(parts[21]);
        playerDTO.setCurrentClubName(parts[22]);
    }

    @Override
    public PlayerDTO createInstance()
    {
        return new PlayerDTO();
    }
}