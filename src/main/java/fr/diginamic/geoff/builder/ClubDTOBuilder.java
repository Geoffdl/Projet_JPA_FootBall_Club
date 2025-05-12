package fr.diginamic.geoff.builder;

import fr.diginamic.geoff.dto.ClubDTO;
import fr.diginamic.geoff.exception.CsvFormatException;
import fr.diginamic.geoff.utils.DTOUtils;

import java.time.Year;

import static fr.diginamic.geoff.utils.Deserializer.*;

public class ClubDTOBuilder implements DTOBuilder<ClubDTO>
{

    public ClubDTOBuilder()
    {

    }

    @Override
    public void setAttributes(ClubDTO entity, String line) throws CsvFormatException
    {


        String[] parts = DTOUtils.splitDataSourceIntoArray(line, ClubDTO.class.getDeclaredFields().length);

        entity.setClubId(stringToLong(parts[0]));
        entity.setClubCode(parts[1]);
        entity.setName(parts[2]);
        entity.setDomesticCompetitionId(parts[3]);
        entity.setTotalMarketValue(stringToInt(parts[4]));
        entity.setSquadSize(stringToInt(parts[5]));
        entity.setAverageAge(stringToDouble(parts[6]));
        entity.setForeignersNumber(stringToInt(parts[7]));
        entity.setForeignerPercentage(stringToDouble(parts[8]));
        entity.setNationalTeamPlayers(stringToInt(parts[9]));
        entity.setStadiumName(parts[10]);
        entity.setStadiumSeats(stringToInt(parts[11]));
        entity.setNetTransferRecord(stringToDouble(DTOUtils.cleanUpForIntConversion(parts[12])));
        entity.setCoachName(parts[13]);
        entity.setLastSeason(Year.of(stringToInt(parts[14])));
        entity.setUrl(parts[15]);
    }

    @Override
    public ClubDTO createInstance()
    {
        return new ClubDTO();
    }
}