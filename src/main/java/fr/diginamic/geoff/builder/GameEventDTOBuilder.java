package fr.diginamic.geoff.builder;

import fr.diginamic.geoff.dto.GameEventDTO;
import fr.diginamic.geoff.exception.CsvFormatException;

import static fr.diginamic.geoff.utils.DTOUtils.*;
import static fr.diginamic.geoff.utils.Deserializer.*;

public class GameEventDTOBuilder implements DTOBuilder<GameEventDTO>
{
    @Override
    public void setAttributes(GameEventDTO entity, String line) throws CsvFormatException
    {
        String[] parts = splitDataSourceIntoArray(line, GameEventDTO.class.getDeclaredFields().length);

        entity.setGameEventId(parts[0]);
        entity.setDate(stringToLocalDate(parts[1]));
        entity.setGameId(stringToInt(parts[2]));
        entity.setMinute(stringToInt(parts[3]));
        entity.setType(parts[4]);
        entity.setClubId(stringToInt(parts[5]));
        entity.setPlayerId(stringToInt(parts[6]));
        entity.setDescription(parts[7]);
        entity.setPlayerInId(stringToInt(parts[8]));
        entity.setPlayerAssistId(stringToInt(parts[9]));
    }

    @Override
    public GameEventDTO createInstance()
    {
        return new GameEventDTO();
    }
}