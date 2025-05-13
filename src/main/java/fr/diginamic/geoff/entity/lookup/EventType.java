package fr.diginamic.geoff.entity.lookup;

/**
 * enumeration for game event types
 */
public enum EventType
{
    EVENT("Events"),
    GOAL("Goals"),
    SUBSTITUTION("Substitutions"),
    CARDS("Cards");

    private final String csvValue;

    EventType(String csvValue)
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
    public static EventType fromCsvValue(String value)
    {
        for (EventType type : values())
        {
            if (type.csvValue.equals(value.trim()))
            {
                return type;
            }
        }
        return EventType.EVENT;
    }
}