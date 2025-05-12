package fr.diginamic.geoff.utils;

import fr.diginamic.geoff.exception.CsvFormatException;

public class DTOUtils
{
    /**
     * @param line
     * @param expectedLength
     * @return
     * @throws CsvFormatException
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
     * @param part
     * @return
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