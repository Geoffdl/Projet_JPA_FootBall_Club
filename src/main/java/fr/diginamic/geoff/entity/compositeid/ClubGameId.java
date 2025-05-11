package fr.diginamic.geoff.entity.compositeid;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class ClubGameId
{
    @Column(name = "club_id")
    private Long clubId;
    @Column(name = "game_id")
    private Long gameId;

    @Override
    public boolean equals(Object object)
    {
        if (!(object instanceof ClubGameId that)) return false;
        return Objects.equals(clubId, that.clubId) && Objects.equals(gameId, that.gameId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(clubId, gameId);
    }
}