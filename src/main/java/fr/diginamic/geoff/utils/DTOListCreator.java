package fr.diginamic.geoff.utils;

import fr.diginamic.geoff.builder.*;
import fr.diginamic.geoff.dto.*;
import fr.diginamic.geoff.exception.CsvFormatException;
import fr.diginamic.geoff.parser.CsvDataParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 *
 */
public class DTOListCreator
{

    private static final Logger LOGGER = LoggerFactory.getLogger(DTOListCreator.class);


    /**
     * @param fileUrl
     * @param dtoBuilder
     * @param <T>
     * @return
     */
    private <T> List<T> createListOfDTO(String fileUrl, DTOBuilder<T> dtoBuilder)
    {
        List<String> lines = CsvDataParser.readFile(fileUrl);
        try
        {
            return dtoBuilder.buildDTOList(lines);
        } catch (CsvFormatException e)
        {
            LOGGER.error("Couldn't parse the file {} : {}", fileUrl, e.getMessage());
            return null;
        }
    }


    public List<AppearanceDTO> createListOfAppearanceDTO(String fileUrl)
    {
        return createListOfDTO(fileUrl, new AppearanceDTOBuilder());
    }

    public List<ClubDTO> createListOfClubDTO(String fileUrl)
    {
        return createListOfDTO(fileUrl, new ClubDTOBuilder());
    }

    public List<CompetitionDTO> createListOfCompetitionDTO(String fileUrl)
    {
        return createListOfDTO(fileUrl, new CompetitionDTOBuilder());
    }

    public List<GameDTO> createListOfGameDTO(String fileUrl)
    {
        return createListOfDTO(fileUrl, new GameDTOBuilder());
    }

    public List<GameEventDTO> createListOfGameEventDTO(String fileUrl)
    {
        return createListOfDTO(fileUrl, new GameEventDTOBuilder());
    }

    public List<GameLineupDTO> createListOfGameLineupDTO(String fileUrl)
    {
        return createListOfDTO(fileUrl, new GameLineupDTOBuilder());
    }

    public List<PlayerDTO> createListOfPlayerDTO(String fileUrl)
    {
        return createListOfDTO(fileUrl, new PlayerDTOBuilder());
    }

    public List<PlayerValuationDTO> createListOfPlayerValuation(String fileUrl)
    {
        return createListOfDTO(fileUrl, new PlayerValuationDTOBuilder());
    }

}