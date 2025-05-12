package fr.diginamic.geoff.parser;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvDataParser
{

    private static final Logger LOGGER = LoggerFactory.getLogger(CsvDataParser.class);


    public static List<String> readFile(String fileUrl)
    {
        Path path = Paths.get(fileUrl);

        try
        {
            return Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e)
        {
            LOGGER.error("Couldn't read file {} : {}", path.getFileName(), e.getMessage());
        }
        return List.of();
    }

    public static List<String> readFileWithReader(String fileUrl)
    {
        List<String> lines = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(fileUrl, StandardCharsets.UTF_8)))
        {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null)
            {
                // Join CSV fields into a single line (escaped properly if needed)
                String reconstructedLine = String.join(",", nextLine);
                lines.add(reconstructedLine);
            }
        } catch (IOException | CsvValidationException e)
        {
            LOGGER.error("Couldn't read file {} : {}", fileUrl, e.getMessage());
        }

        return lines;


    }
}