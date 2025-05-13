package fr.diginamic.geoff.entity;

import fr.diginamic.geoff.entity.compositeid.ClubGameId;
import fr.diginamic.geoff.entity.lookup.Side;
import jakarta.persistence.*;

@Entity
@Table(name = "club_game")
public class ClubGame
{
    @EmbeddedId
    private ClubGameId clubGameId;

    @Enumerated(EnumType.STRING)
    private Side side;

    @Column(name = "manager_name")
    private String managerName;

    @Column(name = "tactical_formation")
    private String tacticalFormation;

    @Column(name = "source_club_id")
    private Long sourceClubId;
    @Column(name = "source_game_id")
    private Long sourceGameId;

    @ManyToOne
    @MapsId("gameId")
    private Game game;

    @ManyToOne
    @MapsId("clubId")
    private Club club;


    public ClubGame()
    {
    }

    /**
     * Gets clubGameId for the class ClubGame
     *
     * @return value of clubGameId
     */
    public ClubGameId getClubGameId()
    {
        return clubGameId;
    }

    /**
     * Sets clubGameId for the class ClubGame.
     *
     * @param clubGameId value of clubGameId
     */
    public void setClubGameId(ClubGameId clubGameId)
    {
        this.clubGameId = clubGameId;
    }

    /**
     * Gets side for the class ClubGame
     *
     * @return value of side
     */
    public Side getSide()
    {
        return side;
    }

    /**
     * Sets side for the class ClubGame.
     *
     * @param side value of side
     */
    public void setSide(Side side)
    {
        this.side = side;
    }

    /**
     * Gets managerName for the class ClubGame
     *
     * @return value of managerName
     */
    public String getManagerName()
    {
        return managerName;
    }

    /**
     * Sets managerName for the class ClubGame.
     *
     * @param managerName value of managerName
     */
    public void setManagerName(String managerName)
    {
        this.managerName = managerName;
    }

    /**
     * Gets tacticalFormation for the class ClubGame
     *
     * @return value of tacticalFormation
     */
    public String getTacticalFormation()
    {
        return tacticalFormation;
    }

    /**
     * Sets tacticalFormation for the class ClubGame.
     *
     * @param tacticalFormation value of tacticalFormation
     */
    public void setTacticalFormation(String tacticalFormation)
    {
        this.tacticalFormation = tacticalFormation;
    }

    /**
     * Gets game for the class ClubGame
     *
     * @return value of game
     */
    public Game getGame()
    {
        return game;
    }

    /**
     * Sets game for the class ClubGame.
     *
     * @param game value of game
     */
    public void setGame(Game game)
    {
        this.game = game;
    }

    /**
     * Gets club for the class ClubGame
     *
     * @return value of club
     */
    public Club getClub()
    {
        return club;
    }

    /**
     * Sets club for the class ClubGame.
     *
     * @param club value of club
     */
    public void setClub(Club club)
    {
        this.club = club;
    }

    /**
     * Gets sourceClubId for the class ClubGame
     *
     * @return value of sourceClubId
     */
    public Long getSourceClubId()
    {
        return sourceClubId;
    }

    /**
     * Sets sourceClubId for the class ClubGame.
     *
     * @param sourceClubId value of sourceClubId
     */
    public void setSourceClubId(Long sourceClubId)
    {
        this.sourceClubId = sourceClubId;
    }

    /**
     * Gets sourceGameId for the class ClubGame
     *
     * @return value of sourceGameId
     */
    public Long getSourceGameId()
    {
        return sourceGameId;
    }

    /**
     * Sets sourceGameId for the class ClubGame.
     *
     * @param sourceGameId value of sourceGameId
     */
    public void setSourceGameId(Long sourceGameId)
    {
        this.sourceGameId = sourceGameId;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("ClubGame{");
        sb.append("clubGameId=").append(clubGameId);
        sb.append(", side=").append(side);
        sb.append(", managerName='").append(managerName).append('\'');
        sb.append(", tacticalFormation='").append(tacticalFormation).append('\'');
        sb.append(", game=").append(game);
        sb.append(", club=").append(club);
        sb.append('}');
        return sb.toString();
    }
}