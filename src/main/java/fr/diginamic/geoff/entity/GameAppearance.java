package fr.diginamic.geoff.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "game_appearance")
public class GameAppearance
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_appearance_id")
    private Long gameAppearanceId;

    private int yellowCards;
    private int redCards;
    private int goals;
    private int assists;
    private int minutes_played;

    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "game_id")
    private Game game;
    @ManyToOne
    @JoinColumn(name = "player_id", referencedColumnName = "player_id")
    private Player player;

    public GameAppearance()
    {
    }

    public GameAppearance(int yellowCards, int redCards, int goals, int assists, int minutes_played, Game game, Player player)
    {
        this.yellowCards = yellowCards;
        this.redCards = redCards;
        this.goals = goals;
        this.assists = assists;
        this.minutes_played = minutes_played;
        this.game = game;
        this.player = player;
    }

    /**
     * Gets gameAppearanceId for the class GameAppearance
     *
     * @return value of gameAppearanceId
     */
    public Long getGameAppearanceId()
    {
        return gameAppearanceId;
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