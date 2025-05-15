package fr.diginamic.geoff.entity.compositeid;

import jakarta.persistence.Embeddable;

import java.util.Objects;

/**
 * composite key matching Games and Clubs
 */
@Embeddable
public class ClubGameId
{

    private Long clubId;

    private Long gameId;

    public ClubGameId()
    {
    }

    public ClubGameId(Long clubId, Long gameId)
    {
        this.clubId = clubId;
        this.gameId = gameId;
    }

    /**
     * Gets clubId for the class ClubGameId
     *
     * @return value of clubId
     */
    public Long getClubId()
    {
        return clubId;
    }

    /**
     * Sets clubId for the class ClubGameId.
     *
     * @param clubId value of clubId
     */
    public void setClubId(Long clubId)
    {
        this.clubId = clubId;
    }

    /**
     * Gets gameId for the class ClubGameId
     *
     * @return value of gameId
     */
    public Long getGameId()
    {
        return gameId;
    }

    /**
     * Sets gameId for the class ClubGameId.
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
        if (!(object instanceof ClubGameId that)) return false;
        return Objects.equals(clubId, that.clubId) && Objects.equals(gameId, that.gameId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(clubId, gameId);
    }
}