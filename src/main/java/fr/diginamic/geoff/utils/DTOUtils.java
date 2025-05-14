package fr.diginamic.geoff.utils;

import fr.diginamic.geoff.exception.CsvFormatException;

public class DTOUtils
{
    /**
     * Splits a line from a csv into an array of elements
     *
     * @param line           line from csv file
     * @param expectedLength the number of fields in the target entity
     * @return an array of elements
     * @throws CsvFormatException if result isn't the expected size
     */
    public static String[] splitDataSourceIntoArray(String line, int expectedLength) throws CsvFormatException
    {

        line = line.replaceAll("\"[^\"]+,[^\"]+\"", "");
        line = line.trim();
        String[] parts = line.split(",");
        if (parts.length != expectedLength)
        {
            throw new CsvFormatException(String.format("Attribute mismatch expected size %d, actual %d", expectedLength, parts.length));

        }
        return parts;
    }

    /**
     * cleans up a string for number conversion
     *
     * @param part part of a line
     * @return a string ready for conversion
     */
    public static String cleanUpForIntConversion(String part)
    {
        part = part.replace("€", "")
                .replace("m", "")
                .replace("k", "")
                .replace("+", "")
                .replace(",", ".")
                .trim();
        return part;
    }


}