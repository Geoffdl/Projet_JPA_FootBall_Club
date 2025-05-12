package fr.diginamic.geoff.entity.lookup;

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