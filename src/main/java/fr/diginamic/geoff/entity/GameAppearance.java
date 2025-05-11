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

    private int yellowCards;
    private int redCards;
    private int goals;
    private int assists;
    private int minutes_played;

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
    public int getYellowCards()
    {
        return yellowCards;
    }

    /**
     * Sets yellowCards for the class GameAppearance.
     *
     * @param yellowCards value of yellowCards
     */
    public void setYellowCards(int yellowCards)
    {
        this.yellowCards = yellowCards;
    }

    /**
     * Gets redCards for the class GameAppearance
     *
     * @return value of redCards
     */
    public int getRedCards()
    {
        return redCards;
    }

    /**
     * Sets redCards for the class GameAppearance.
     *
     * @param redCards value of redCards
     */
    public void setRedCards(int redCards)
    {
        this.redCards = redCards;
    }

    /**
     * Gets goals for the class GameAppearance
     *
     * @return value of goals
     */
    public int getGoals()
    {
        return goals;
    }

    /**
     * Sets goals for the class GameAppearance.
     *
     * @param goals value of goals
     */
    public void setGoals(int goals)
    {
        this.goals = goals;
    }

    /**
     * Gets assists for the class GameAppearance
     *
     * @return value of assists
     */
    public int getAssists()
    {
        return assists;
    }

    /**
     * Sets assists for the class GameAppearance.
     *
     * @param assists value of assists
     */
    public void setAssists(int assists)
    {
        this.assists = assists;
    }

    /**
     * Gets minutes_played for the class GameAppearance
     *
     * @return value of minutes_played
     */
    public int getMinutes_played()
    {
        return minutes_played;
    }

    /**
     * Sets minutes_played for the class GameAppearance.
     *
     * @param minutes_played value of minutes_played
     */
    public void setMinutes_played(int minutes_played)
    {
        this.minutes_played = minutes_played;
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