package fr.diginamic.geoff.entity.compositeid;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

/**
 * Composite key matching Games and Players
 */
@Embeddable
public class ClubPlayerId
{
    @Column(name = "player_id")
    private Long playerId;
    @Column(name = "club_id")
    private Long clubId;

    public ClubPlayerId()
    {
    }

    public ClubPlayerId(Long playerId, Long clubId)
    {
        this.playerId = playerId;
        this.clubId = clubId;
    }

    /**
     * Gets playerId for the class ClubPlayerId
     *
     * @return value of playerId
     */
    public Long getPlayerId()
    {
        return playerId;
    }

    /**
     * Sets playerId for the class ClubPlayerId.
     *
     * @param playerId value of playerId
     */
    public void setPlayerId(Long playerId)
    {
        this.playerId = playerId;
    }

    /**
     * Gets clubId for the class ClubPlayerId
     *
     * @return value of clubId
     */
    public Long getClubId()
    {
        return clubId;
    }

    /**
     * Sets clubId for the class ClubPlayerId.
     *
     * @param clubId value of clubId
     */
    public void setClubId(Long clubId)
    {
        this.clubId = clubId;
    }

    @Override
    public boolean equals(Object object)
    {
        if (!(object instanceof ClubPlayerId that)) return false;
        return Objects.equals(playerId, that.playerId) && Objects.equals(clubId, that.clubId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(playerId, clubId);
    }
}