package fr.diginamic.geoff.entity.compositeid;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class ClubPlayerId
{
    @Column(name = "player_id")
    private Long playerId;
    @Column(name = "club_id")
    private Long clubId;

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