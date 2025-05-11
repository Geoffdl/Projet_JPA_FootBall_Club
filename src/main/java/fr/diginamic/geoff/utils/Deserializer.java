package fr.diginamic.geoff.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;

import static java.lang.Integer.parseInt;

public class Deserializer
{
    public static int stringToInt(String part)
    {
        if (part == null || part.trim().isEmpty())
        {
            return 0;
        }
        ;
        return parseInt(part);
    }

    public static Long stringToLong(String part)
    {
        if (part == null || part.trim().isEmpty())
        {
            return 0L;
        }
        ;
        return Long.parseLong(part);
    }

    public static double stringToDouble(String part)
    {
        if (part == null || part.trim().isEmpty())
        {
            return 0;
        }
        ;
        return Double.parseDouble(part);
    }

    public static LocalDate stringToLocalDate(String part)
    {
        if (part == null || part.trim().isEmpty())
        {
            return LocalDate.of(1900, 1, 1);
        }
        ;

        return LocalDate.parse(part.trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }


    public static LocalDateTime stringToLocalDateTime(String part)
    {
        if (part == null || part.trim().isEmpty())
        {
            return LocalDateTime.of(1900, 1, 1, 0, 0, 0);
        }
        ;

        return LocalDateTime.parse(part.trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public static Year stringToYear(String part)
    {
        if (part == null || part.trim().isEmpty())
        {
            return Year.of(1900);
        }
        ;

        return Year.of(stringToInt(part));
    }

    public static boolean stringToBoolean(String part)
    {
        if (part == null || part.trim().isEmpty())
        {
            return false;
        }
        ;

        return stringToInt(part) != 0;

    }
}