package fr.diginamic.geoff.entity.compositeid;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

/**
 * Composite key matching games and players
 */
@Embeddable
public class GamePlayerId
{
    @Column(name = "player_id")
    private Long playerId;
    @Column(name = "game_id")
    private Long gameId;

    public GamePlayerId()
    {
    }

    public GamePlayerId(Long playerId, Long gameId)
    {
        this.playerId = playerId;
        this.gameId = gameId;
    }

    /**
     * Gets playerId for the class GamePlayerId
     *
     * @return value of playerId
     */
    public Long getPlayerId()
    {
        return playerId;
    }

    /**
     * Sets playerId for the class GamePlayerId.
     *
     * @param playerId value of playerId
     */
    public void setPlayerId(Long playerId)
    {
        this.playerId = playerId;
    }

    /**
     * Gets gameId for the class GamePlayerId
     *
     * @return value of gameId
     */
    public Long getGameId()
    {
        return gameId;
    }

    /**
     * Sets gameId for the class GamePlayerId.
     *
     * @param gameId value of gameId
     */
    public void setGameId(Long gameId)
    {
        this.gameId = gameId;
    }

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