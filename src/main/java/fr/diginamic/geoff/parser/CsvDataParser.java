package fr.diginamic.geoff.parser;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
}