package fr.diginamic.geoff.entity.lookup;

/**
 * enumeration for position attribute
 */
public enum Position
{

    ATTACK("Attack"),
    ATTACKING_MIDFIELD("Attacking Midfield"),
    CENTRAL_MIDFIELD("Central Midfield"),
    CENTRE_BACK("Centre-Back"),
    CENTRE_FORWARD("Centre-Forward"),
    DEFENSIVE_MIDFIELD("DefensiveMidfield"),
    GOALKEEPER("Goalkeeper"),
    LEFT_MIDFIELD("Left Midfield"),
    LEFT_WINGER("Left Winger"),
    LEFT_BACK("Left-Back"),
    MIDFIELD("midfield"),
    RIGHT_MIDFIELD("Right Midfield"),
    RIGHT_WINGER("Right Winger"),
    RIGHT_BACK("Right-Back"),
    SECOND_STRIKER("Second Striker"),
    SWEEPER("Sweeper"),
    UNKNOWN("");

    private final String csvValue;

    Position(String csvValue)
    {
        this.csvValue = csvValue;
    }

    public String getCsvValue()
    {
        return csvValue;
    }

    /**
     * takes in a string from dto object and returns matching event type
     *
     * @param value string from dto
     * @return event type
     */
    public static Position fromCsvValue(String value)
    {
        for (Position type : values())
        {
            if (type.csvValue.equals(value.trim()))
            {
                return type;
            }
        }
        return Position.UNKNOWN;
    }
}