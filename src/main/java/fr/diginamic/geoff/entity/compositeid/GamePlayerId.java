package fr.diginamic.geoff.entity.compositeid;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GamePlayerId
{
    @Column(name = "player_id")
    private Long playerId;
    @Column(name = "game_id")
    private Long gameId;

    @Override
    public boolean equals(Object object)
    {
        if (!(object instanceof GamePlayerId that)) return false;
        return Objects.equals(playerId, that.playerId) && Objects.equals(gameId, that.gameId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(playerId, gameId);
    }
}