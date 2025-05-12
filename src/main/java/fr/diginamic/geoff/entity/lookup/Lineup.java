package fr.diginamic.geoff.entity.lookup;

public enum Lineup
{
    STARTING("starting_lineup"),
    SUBSTITUTE("substitutes"),
    UNKNOWN("");

    private final String csvValue;

    Lineup(String csvValue)
    {
        this.csvValue = csvValue;
    }

    public static Lineup fromCsvValue(String value)
    {
        for (Lineup type : values())
        {
            if (type.csvValue.equals(value.trim()))
            {
                return type;
            }
        }
        return Lineup.UNKNOWN;
    }
}