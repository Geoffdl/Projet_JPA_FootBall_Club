package fr.diginamic.geoff.utils;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;

class DeserializerTest
{

    @Test
    void testStringToInt()
    {
        assertEquals(123, Deserializer.stringToInt("123"));
        assertEquals(0, Deserializer.stringToInt(""));
        assertEquals(0, Deserializer.stringToInt(null));
        assertEquals(-5, Deserializer.stringToInt("-5"));
    }

    @Test
    void testStringToLong()
    {
        assertEquals(123L, Deserializer.stringToLong("123"));
        assertEquals(0L, Deserializer.stringToLong(""));
        assertEquals(0L, Deserializer.stringToLong(null));
        assertEquals(-5L, Deserializer.stringToLong("-5"));
    }

    @Test
    void testStringToDouble()
    {
        assertEquals(123.45, Deserializer.stringToDouble("123.45"));
        assertEquals(0.0, Deserializer.stringToDouble(""));
        assertEquals(0.0, Deserializer.stringToDouble(null));
        assertEquals(-5.5, Deserializer.stringToDouble("-5.5"));
    }

    @Test
    void testStringToLocalDate()
    {
        assertEquals(LocalDate.of(2020, 1, 2), Deserializer.stringToLocalDate("2020-01-02"));
        assertEquals(LocalDate.of(1900, 1, 1), Deserializer.stringToLocalDate(""));
        assertEquals(LocalDate.of(1900, 1, 1), Deserializer.stringToLocalDate(null));
    }

    @Test
    void testStringToLocalDateTime()
    {
        assertEquals(LocalDateTime.of(2020, 1, 2, 12, 30, 45), Deserializer.stringToLocalDateTime("2020-01-02 12:30:45"));
        assertEquals(LocalDateTime.of(1900, 1, 1, 0, 0, 0), Deserializer.stringToLocalDateTime(""));
        assertEquals(LocalDateTime.of(1900, 1, 1, 0, 0, 0), Deserializer.stringToLocalDateTime(null));
    }

    @Test
    void testStringToYear()
    {
        assertEquals(Year.of(2020), Deserializer.stringToYear("2020"));
        assertEquals(Year.of(1900), Deserializer.stringToYear(""));
        assertEquals(Year.of(1900), Deserializer.stringToYear(null));
    }

    @Test
    void testStringToBoolean()
    {
        assertTrue(Deserializer.stringToBoolean("1"));
        assertFalse(Deserializer.stringToBoolean("0"));
        assertFalse(Deserializer.stringToBoolean(""));
        assertFalse(Deserializer.stringToBoolean(null));
        assertTrue(Deserializer.stringToBoolean("100"));
        assertFalse(Deserializer.stringToBoolean("-0"));
    }
}