package fr.diginamic.geoff.entity.lookup;

/**
 * enumeration for game lineup attribute
 */
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


    /**
     * takes in a string from dto object and returns matching event type
     *
     * @param value string from dto
     * @return event type
     */
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