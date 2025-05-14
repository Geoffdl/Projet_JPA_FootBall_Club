package fr.diginamic.geoff.mapper;

import fr.diginamic.geoff.dto.GameEventDTO;
import fr.diginamic.geoff.entity.GameEvent;
import fr.diginamic.geoff.entity.lookup.EventType;

/**
 * Sets base attributes to new JPA entities from source dto
 */
public class GameEventDtoMapper
{
    private final GameEventDTO dto;

    public GameEventDtoMapper(GameEventDTO dto)
    {
        this.dto = dto;
    }

    public GameEvent mapToGameEvent(GameEvent gameEvent)
    {
        gameEvent.setSourceId(dto.getGameEventId());

        gameEvent.setEventMinute(dto.getMinute());
        gameEvent.setEventType(EventType.fromCsvValue(dto.getType()));
        gameEvent.setDescription(dto.getDescription());

        return gameEvent;
    }
}