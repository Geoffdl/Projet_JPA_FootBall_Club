package fr.diginamic.geoff.utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import fr.diginamic.geoff.builder.*;
import fr.diginamic.geoff.dto.*;
import fr.diginamic.geoff.exception.CsvFormatException;
import fr.diginamic.geoff.parser.CsvDataParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
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

    /**
     * @param fileUrl
     * @param dtoBuilder
     * @param <T>
     * @return
     */
    private <T> List<T> createListOfDTOWithOpenCsv(String fileUrl, CsvArrayDTOBuilder<T> dtoBuilder)
    {
        try (CSVReader reader = new CSVReader(new FileReader(fileUrl, StandardCharsets.UTF_8)))
        {
            List<String[]> rows = reader.readAll();
            return dtoBuilder.buildDTOListFromArray(rows);
        } catch (IOException | CsvException e)
        {
            LOGGER.error("Couldn't read file {} : {}", fileUrl, e.getMessage());
            return List.of();
        }
    }


    /**
     * @param fileUrl
     * @return
     */
    public List<AppearanceDTO> createListOfAppearanceDTO(String fileUrl)
    {
        return createListOfDTO(fileUrl, new AppearanceDTOBuilder());
    }

    /**
     * @param fileUrl
     * @return
     */
    public List<ClubDTO> createListOfClubDTO(String fileUrl)
    {
        return createListOfDTO(fileUrl, new ClubDTOBuilder());
    }

    /**
     * @param fileUrl
     * @return
     */
    public List<CompetitionDTO> createListOfCompetitionDTO(String fileUrl)
    {
        return createListOfDTO(fileUrl, new CompetitionDTOBuilder());
    }

    public List<GameDTO> createListOfGameDTO(String fileUrl)
    {
        return createListOfDTO(fileUrl, new GameDTOBuilder());
    }

    /**
     * @param fileUrl
     * @return
     */
    public List<GameEventDTO> createListOfGameEventDTO(String fileUrl)
    {
        return createListOfDTOWithOpenCsv(fileUrl, new GameEventDTOBuilder());
    }

    /**
     * @param fileUrl
     * @return
     */
    public List<GameLineupDTO> createListOfGameLineupDTO(String fileUrl)
    {
        return createListOfDTO(fileUrl, new GameLineupDTOBuilder());
    }

    /**
     * @param fileUrl
     * @return
     */
    public List<PlayerDTO> createListOfPlayerDTO(String fileUrl)
    {
        return createListOfDTO(fileUrl, new PlayerDTOBuilder());
    }

    /**
     * @param fileUrl
     * @return
     */
    public List<PlayerValuationDTO> createListOfPlayerValuation(String fileUrl)
    {
        return createListOfDTO(fileUrl, new PlayerValuationDTOBuilder());
    }

}