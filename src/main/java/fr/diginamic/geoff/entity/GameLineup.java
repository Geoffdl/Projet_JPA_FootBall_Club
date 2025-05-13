package fr.diginamic.geoff.entity;

import fr.diginamic.geoff.entity.compositeid.GamePlayerId;
import fr.diginamic.geoff.entity.lookup.Lineup;
import fr.diginamic.geoff.entity.lookup.Position;
import jakarta.persistence.*;

@Entity
@Table(name = "game_lineup")
public class GameLineup
{
    @EmbeddedId
    private GamePlayerId gameLineupId;

    @Column(name = "source_id", unique = true)
    private String sourceId;

    @Column(name = "player_number")
    private int playerNumber;
    @Column(name = "is_team_captain")
    private boolean isTeamCaptain;

    @Enumerated(EnumType.STRING)
    @Column(name = "starting_lineup")
    private Lineup startingLineup;
    @Enumerated(EnumType.STRING)
    private Position position;

    @ManyToOne
    @MapsId("playerId")
    private Player player;
    @ManyToOne
    @MapsId("gameId")
    private Game game;

    public GameLineup()
    {
    }

    /**
     * Gets gameLineupId for the class GameLineup
     *
     * @return value of gameLineupId
     */
    public GamePlayerId getGameLineupId()
    {
        return gameLineupId;
    }

    /**
     * Sets gameLineupId for the class GameLineup.
     *
     * @param gameLineupId value of gameLineupId
     */
    public void setGameLineupId(GamePlayerId gameLineupId)
    {
        this.gameLineupId = gameLineupId;
    }

    /**
     * Gets sourceId for the class GameLineup
     *
     * @return value of sourceId
     */
    public String getSourceId()
    {
        return sourceId;
    }

    /**
     * Sets sourceId for the class GameLineup.
     *
     * @param sourceId value of sourceId
     */
    public void setSourceId(String sourceId)
    {
        this.sourceId = sourceId;
    }

    /**
     * Gets startingLineup for the class GameLineup
     *
     * @return value of startingLineup
     */
    public Lineup getStartingLineup()
    {
        return startingLineup;
    }

    /**
     * Sets startingLineup for the class GameLineup.
     *
     * @param startingLineup value of startingLineup
     */
    public void setStartingLineup(Lineup startingLineup)
    {
        this.startingLineup = startingLineup;
    }

    /**
     * Gets playerNumber for the class GameLineup
     *
     * @return value of playerNumber
     */
    public int getPlayerNumber()
    {
        return playerNumber;
    }

    /**
     * Sets playerNumber for the class GameLineup.
     *
     * @param playerNumber value of playerNumber
     */
    public void setPlayerNumber(int playerNumber)
    {
        this.playerNumber = playerNumber;
    }

    /**
     * Gets isTeamCaptain for the class GameLineup
     *
     * @return value of isTeamCaptain
     */
    public boolean isTeamCaptain()
    {
        return isTeamCaptain;
    }

    /**
     * Sets isTeamCaptain for the class GameLineup.
     *
     * @param teamCaptain value of isTeamCaptain
     */
    public void setTeamCaptain(boolean teamCaptain)
    {
        isTeamCaptain = teamCaptain;
    }

    /**
     * Gets position for the class GameLineup
     *
     * @return value of position
     */
    public Position getPosition()
    {
        return position;
    }

    /**
     * Sets position for the class GameLineup.
     *
     * @param position value of position
     */
    public void setPosition(Position position)
    {
        this.position = position;
    }

    /**
     * Gets player for the class GameLineup
     *
     * @return value of player
     */
    public Player getPlayer()
    {
        return player;
    }

    /**
     * Sets player for the class GameLineup.
     *
     * @param player value of player
     */
    public void setPlayer(Player player)
    {
        this.player = player;
    }

    /**
     * Gets game for the class GameLineup
     *
     * @return value of game
     */
    public Game getGame()
    {
        return game;
    }

    /**
     * Sets game for the class GameLineup.
     *
     * @param game value of game
     */
    public void setGame(Game game)
    {
        this.game = game;
    }
}