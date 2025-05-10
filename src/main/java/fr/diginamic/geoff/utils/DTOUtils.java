package fr.diginamic.geoff.utils;

import fr.diginamic.geoff.exception.CsvFormatException;

public class DTOUtils
{
    public static String[] splitDataSourceIntoArray(String line, int expectedLength) throws CsvFormatException {

        line = line.trim();
        String[] parts = line.split(",");
        if (parts.length != expectedLength)
        {
            throw new CsvFormatException(String.format("Attribute mismatch expected size %d, actual %d", expectedLength, parts.length));

        }
        return parts;
    }

    public static String cleanUpForIntConversion(String part){
        part = part.replace("€", "");
        part = part.replace("m", "");
        part = part.replace("k", "");
        part = part.replace("+", "");
        part = part.replace("+", "");

        return part;
    }
}