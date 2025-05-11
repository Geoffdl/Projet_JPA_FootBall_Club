package fr.diginamic.geoff.builder;

import fr.diginamic.geoff.dto.GameDTO;
import fr.diginamic.geoff.exception.CsvFormatException;
import fr.diginamic.geoff.utils.DTOUtils;

import static fr.diginamic.geoff.utils.Deserializer.*;

public class GameDTOBuilder implements DTOBuilder<GameDTO>
{
    @Override
    public void setAttributes(GameDTO entity, String line) throws CsvFormatException
    {
        String[] parts = DTOUtils.splitDataSourceIntoArray(line, GameDTO.class.getDeclaredFields().length);

        entity.setGameId(stringToLong(parts[0]));
        entity.setCompetitionId(parts[1]);
        entity.setSeason(stringToYear(parts[2]));
        entity.setRound(parts[3]);
        entity.setDate(stringToLocalDate(parts[4]));
        entity.setHomeClubId(stringToLong(parts[5]));
        entity.setAwayClubId(stringToLong(parts[6]));
        entity.setHomeClubGoals(stringToInt(parts[7]));
        entity.setAwayClubGoals(stringToInt(parts[8]));
        entity.setHomeClubPosition(stringToInt(parts[9]));
        entity.setAwayClubPosition(stringToInt(parts[10]));
        entity.setHomeClubManagerName(parts[11]);
        entity.setAwayClubManagerName(parts[12]);
        entity.setStadiumName(parts[13]);
        entity.setAttendance(stringToInt(parts[14]));
        entity.setRefereeName(parts[15]);
        entity.setUrl(parts[16]);
        entity.setHomeClubFormation(parts[17]);
        entity.setAwayClubFormation(parts[18]);
        entity.setHomeClubName(parts[19]);
        entity.setAwayClubName(parts[20]);
        entity.setAggregate(parts[21]);
        entity.setCompetitionType(parts[22]);
    }

    @Override
    public GameDTO createInstance()
    {
        return new GameDTO();
    }
}