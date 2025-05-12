package fr.diginamic.geoff.builder;

import fr.diginamic.geoff.dto.AppearanceDTO;
import fr.diginamic.geoff.exception.CsvFormatException;

import static fr.diginamic.geoff.utils.DTOUtils.splitDataSourceIntoArray;
import static fr.diginamic.geoff.utils.Deserializer.*;

public class AppearanceDTOBuilder implements DTOBuilder<AppearanceDTO>
{
    @Override
    public void setAttributes(AppearanceDTO entity, String line) throws CsvFormatException
    {
        String[] parts = splitDataSourceIntoArray(line, AppearanceDTO.class.getDeclaredFields().length);

        entity.setAppearanceId(stringToLong(parts[0].replace("_", "")));
        entity.setGameId(stringToLong(parts[1]));
        entity.setPlayerId(stringToLong(parts[2]));
        entity.setPlayerClubId(stringToInt(parts[3]));
        entity.setPlayerCurrentClubId(stringToInt(parts[4]));
        entity.setDate(stringToLocalDate(parts[5]));
        entity.setPlayerName(parts[6]);
        entity.setCompetitionId(parts[7]);
        entity.setYellowCard(stringToInt(parts[8]));
        entity.setRedCard(stringToInt(parts[9]));
        entity.setGoals(stringToInt(parts[10]));
        entity.setAssists(stringToInt(parts[11]));
        entity.setMinutesPlayed(stringToInt(parts[12]));

    }

    @Override
    public AppearanceDTO createInstance()
    {
        return new AppearanceDTO();
    }
}