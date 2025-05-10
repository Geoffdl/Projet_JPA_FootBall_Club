package fr.diginamic.geoff.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.lang.Integer.parseInt;

public class Deserializer
{
    public static int stringToInt(String part) {
        return parseInt(part);
    }

    public static LocalDate stringToLocalDate(String parts) {

        return LocalDate.parse(parts.trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }


    public static LocalDateTime stringToLocalDateTime(String part) {
        return LocalDateTime.parse(part.trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}