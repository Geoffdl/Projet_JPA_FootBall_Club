package fr.diginamic.geoff.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;

import static java.lang.Integer.parseInt;

/**
 * Contains a sample of helper methods to convert Strings into another Type
 */
public class Deserializer
{
    /**
     * String to Int
     *
     * @param part element of a String
     * @return int
     */
    public static int stringToInt(String part)
    {
        if (part == null || part.trim().isEmpty())
        {
            return 0;
        }
        return parseInt(part);
    }

    /**
     * String to long
     *
     * @param part element of a String
     * @return Long
     */
    public static Long stringToLong(String part)
    {
        if (part == null || part.trim().isEmpty())
        {
            return 0L;
        }
        return Long.parseLong(part);
    }

    /**
     * String to Double
     *
     * @param part element of a String
     * @return Double
     */
    public static Double stringToDouble(String part)
    {
        if (part == null || part.trim().isEmpty())
        {
            return (double) 0;
        }
        return Double.parseDouble(part);
    }

    /**
     * String to LocalDate
     *
     * @param part element of a String
     * @return LocalDate
     */
    public static LocalDate stringToLocalDate(String part)
    {
        if (part == null || part.trim().isEmpty())
        {
            return LocalDate.of(1900, 1, 1);
        }
        return LocalDate.parse(part.trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    /**
     * String to LocaleDatetime
     *
     * @param part element of a String
     * @return LocalDateTime
     */
    public static LocalDateTime stringToLocalDateTime(String part)
    {
        if (part == null || part.trim().isEmpty())
        {
            return LocalDateTime.of(1900, 1, 1, 0, 0, 0);
        }
        return LocalDateTime.parse(part.trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * String to Year
     *
     * @param part element of a String
     * @return Year
     */
    public static Year stringToYear(String part)
    {
        if (part == null || part.trim().isEmpty())
        {
            return Year.of(1900);
        }
        return Year.of(stringToInt(part));
    }

    /**
     * String to Boolean
     *
     * @param part element of a String
     * @return Boolean
     */
    public static boolean stringToBoolean(String part)
    {
        if (part == null || part.trim().isEmpty())
        {
            return false;
        }
        return stringToInt(part) != 0;
    }
}