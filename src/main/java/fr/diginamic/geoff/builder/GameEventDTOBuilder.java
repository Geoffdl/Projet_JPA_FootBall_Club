package fr.diginamic.geoff.builder;

import fr.diginamic.geoff.dto.GameEventDTO;
import fr.diginamic.geoff.exception.CsvFormatException;

import static fr.diginamic.geoff.utils.Deserializer.*;

public class GameEventDTOBuilder implements CsvArrayDTOBuilder<GameEventDTO>
{

    @Override
    public void setAttributes(GameEventDTO entity, String[] parts) throws CsvFormatException
    {
        if (parts.length < 10)
        {
            throw new CsvFormatException("Expected 10 columns but got " + parts.length);
        }

        entity.setGameEventId(parts[0]);
        entity.setDate(stringToLocalDate(parts[1]));
        entity.setGameId(stringToLong(parts[2]));
        entity.setMinute(stringToInt(parts[3]));
        entity.setType(parts[4]);
        entity.setClubId(stringToLong(parts[5]));
        entity.setPlayerId(stringToLong(parts[6]));
        entity.setDescription(parts[7]);
        entity.setPlayerInId(stringToLong(parts[8]));
        entity.setPlayerAssistId(stringToLong(parts[9]));
    }

    @Override
    public GameEventDTO createInstance()
    {
        return new GameEventDTO();
    }

    @Override
    public void setAttributes(GameEventDTO entity, String line) throws CsvFormatException
    {
        // Not used — this builder expects String[]
        throw new UnsupportedOperationException("Use OpenCSV parsing for GameEventDTO.");
    }
}