package fr.diginamic.geoff.entity;

import fr.diginamic.geoff.entity.compositeid.GamePlayerId;
import jakarta.persistence.*;

@Entity
@Table(name = "game_appearance")
public class GameAppearance
{
    @EmbeddedId
    private GamePlayerId gameAppearanceId;

    @Column(name = "source_id", unique = true)
    private Long sourceId;

    private Integer yellowCards;
    private Integer redCards;
    private Integer goals;
    private Integer assists;
    private Integer minutesPlayed;

    @ManyToOne
    @MapsId("gameId")
    private Game game;
    @ManyToOne
    @MapsId("playerId")
    private Player player;

    public GameAppearance()
    {
    }

    /**
     * Gets gameAppearanceId for the class GameAppearance
     *
     * @return value of gameAppearanceId
     */
    public GamePlayerId getGameAppearanceId()
    {
        return gameAppearanceId;
    }

    /**
     * Sets gameAppearanceId for the class GameAppearance.
     *
     * @param gameAppearanceId value of gameAppearanceId
     */
    public void setGameAppearanceId(GamePlayerId gameAppearanceId)
    {
        this.gameAppearanceId = gameAppearanceId;
    }

    /**
     * Gets sourceId for the class GameAppearance
     *
     * @return value of sourceId
     */
    public Long getSourceId()
    {
        return sourceId;
    }

    /**
     * Sets sourceId for the class GameAppearance.
     *
     * @param sourceId value of sourceId
     */
    public void setSourceId(Long sourceId)
    {
        this.sourceId = sourceId;
    }

    /**
     * Gets yellowCards for the class GameAppearance
     *
     * @return value of yellowCards
     */
    public Integer getYellowCards()
    {
        return yellowCards;
    }

    /**
     * Sets yellowCards for the class GameAppearance.
     *
     * @param yellowCards value of yellowCards
     */
    public void setYellowCards(Integer yellowCards)
    {
        this.yellowCards = yellowCards;
    }

    /**
     * Gets redCards for the class GameAppearance
     *
     * @return value of redCards
     */
    public Integer getRedCards()
    {
        return redCards;
    }

    /**
     * Sets redCards for the class GameAppearance.
     *
     * @param redCards value of redCards
     */
    public void setRedCards(Integer redCards)
    {
        this.redCards = redCards;
    }

    /**
     * Gets goals for the class GameAppearance
     *
     * @return value of goals
     */
    public Integer getGoals()
    {
        return goals;
    }

    /**
     * Sets goals for the class GameAppearance.
     *
     * @param goals value of goals
     */
    public void setGoals(Integer goals)
    {
        this.goals = goals;
    }

    /**
     * Gets assists for the class GameAppearance
     *
     * @return value of assists
     */
    public Integer getAssists()
    {
        return assists;
    }

    /**
     * Sets assists for the class GameAppearance.
     *
     * @param assists value of assists
     */
    public void setAssists(Integer assists)
    {
        this.assists = assists;
    }

    /**
     * Gets minutesPlayed for the class GameAppearance
     *
     * @return value of minutesPlayed
     */
    public Integer getMinutesPlayed()
    {
        return minutesPlayed;
    }

    /**
     * Sets minutesPlayed for the class GameAppearance.
     *
     * @param minutesPlayed value of minutesPlayed
     */
    public void setMinutesPlayed(Integer minutesPlayed)
    {
        this.minutesPlayed = minutesPlayed;
    }

    /**
     * Gets game for the class GameAppearance
     *
     * @return value of game
     */
    public Game getGame()
    {
        return game;
    }

    /**
     * Sets game for the class GameAppearance.
     *
     * @param game value of game
     */
    public void setGame(Game game)
    {
        this.game = game;
    }

    /**
     * Gets player for the class GameAppearance
     *
     * @return value of player
     */
    public Player getPlayer()
    {
        return player;
    }

    /**
     * Sets player for the class GameAppearance.
     *
     * @param player value of player
     */
    public void setPlayer(Player player)
    {
        this.player = player;
    }
}