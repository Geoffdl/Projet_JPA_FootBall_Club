package fr.diginamic.geoff.builder;

import fr.diginamic.geoff.dto.GameLineupDTO;
import fr.diginamic.geoff.exception.CsvFormatException;

import static fr.diginamic.geoff.utils.DTOUtils.splitDataSourceIntoArray;
import static fr.diginamic.geoff.utils.Deserializer.*;

public class GameLineupDTOBuilder implements DTOBuilder<GameLineupDTO>
{
    @Override
    public void setAttributes(GameLineupDTO entity, String line) throws CsvFormatException
    {
        String[] parts = splitDataSourceIntoArray(line, GameLineupDTO.class.getDeclaredFields().length);

        entity.setGameLineUpsId(parts[0]);
        entity.setGameId(stringToLong(parts[1]));
        entity.setClubId(stringToInt(parts[2]));
        entity.setType(parts[3]);
        entity.setNumber(stringToInt(parts[4]));
        entity.setPlayerId(stringToLong(parts[5]));
        entity.setPlayerName(parts[6]);
        entity.setTeamCaptain(stringToBoolean(parts[7]));
        entity.setPosition(parts[8]);


    }

    @Override
    public GameLineupDTO createInstance()
    {
        return new GameLineupDTO();
    }
}