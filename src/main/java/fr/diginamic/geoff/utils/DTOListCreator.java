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
 * Orchestrates the parsing of a csv file into a list of DTO entities
 */
public class DTOListCreator
{

    private static final Logger LOGGER = LoggerFactory.getLogger(DTOListCreator.class);


    /**
     * Generic method
     * Generate list of DTO using IO library
     *
     * @param fileUrl    string absolute path of the file
     * @param dtoBuilder an implementation of of the builder Interface for the target entity type
     * @param <T>        target entity type
     * @return a list of dto
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
     * Generic method
     * Generate list of DTO using OpenCsv
     *
     * @param fileUrl    string absolute path of the file
     * @param dtoBuilder an implementation of of the builder Interface for the target entity type
     * @param <T>        target entity type
     * @return a list of dto
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
     * Returns a list of DTO
     *
     * @param fileUrl absolute path
     * @return list of DTO
     */
    public List<AppearanceDTO> createListOfAppearanceDTO(String fileUrl)
    {
        return createListOfDTO(fileUrl, new AppearanceDTOBuilder());
    }

    /**
     * Returns a list of DTO
     *
     * @param fileUrl absolute path
     * @return list of DTO
     */
    public List<ClubDTO> createListOfClubDTO(String fileUrl)
    {
        return createListOfDTO(fileUrl, new ClubDTOBuilder());
    }

    /**
     * Returns a list of DTO
     *
     * @param fileUrl absolute path
     * @return list of DTO
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
     * Returns a list of DTO
     *
     * @param fileUrl absolute path
     * @return list of DTO
     */
    public List<GameEventDTO> createListOfGameEventDTO(String fileUrl)
    {
        return createListOfDTOWithOpenCsv(fileUrl, new GameEventDTOBuilder());
    }

    /**
     * Returns a list of DTO
     *
     * @param fileUrl absolute path
     * @return list of DTO
     */
    public List<GameLineupDTO> createListOfGameLineupDTO(String fileUrl)
    {
        return createListOfDTO(fileUrl, new GameLineupDTOBuilder());
    }

    /**
     * Returns a list of DTO
     *
     * @param fileUrl absolute path
     * @return list of DTO
     */
    public List<PlayerDTO> createListOfPlayerDTO(String fileUrl)
    {
        return createListOfDTO(fileUrl, new PlayerDTOBuilder());
    }

    /**
     * Returns a list of DTO
     *
     * @param fileUrl absolute path
     * @return list of DTO
     */
    public List<PlayerValuationDTO> createListOfPlayerValuation(String fileUrl)
    {
        return createListOfDTO(fileUrl, new PlayerValuationDTOBuilder());
    }

}