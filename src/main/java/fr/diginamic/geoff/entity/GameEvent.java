package fr.diginamic.geoff.entity;

import fr.diginamic.geoff.entity.lookup.EventType;
import jakarta.persistence.*;

@Entity
@Table(name = "game_event")
public class GameEvent
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_event_id")
    private Long gameEventId;

    private int eventMinute;
    private EventType eventType;
    private String description;

    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "game_id")
    private Game game;
    @ManyToOne
    @JoinColumn(name = "main_player_id", referencedColumnName = "player_id")
    private Player playerMain;
    @ManyToOne
    @JoinColumn(name = "player_in_id", referencedColumnName = "player_id")
    private Player playerIn;
    @ManyToOne
    @JoinColumn(name = "player_assist_id", referencedColumnName = "player_id")
    private Player playerAssist;


    public GameEvent()
    {
    }

    public GameEvent(int eventMinute, EventType eventType, String description, Game game, Player playerMain, Player playerIn, Player playerAssist)
    {
        this.eventMinute = eventMinute;
        this.eventType = eventType;
        this.description = description;
        this.game = game;
        this.playerMain = playerMain;
        this.playerIn = playerIn;
        this.playerAssist = playerAssist;
    }

    /**
     * Gets gameEventId for the class GameEvent
     *
     * @return value of gameEventId
     */
    public Long getGameEventId()
    {
        return gameEventId;
    }

    /**
     * Gets eventMinute for the class GameEvent
     *
     * @return value of eventMinute
     */
    public int getEventMinute()
    {
        return eventMinute;
    }

    /**
     * Sets eventMinute for the class GameEvent.
     *
     * @param eventMinute value of eventMinute
     */
    public void setEventMinute(int eventMinute)
    {
        this.eventMinute = eventMinute;
    }

    /**
     * Gets eventType for the class GameEvent
     *
     * @return value of eventType
     */
    public EventType getEventType()
    {
        return eventType;
    }

    /**
     * Sets eventType for the class GameEvent.
     *
     * @param eventType value of eventType
     */
    public void setEventType(EventType eventType)
    {
        this.eventType = eventType;
    }

    /**
     * Gets description for the class GameEvent
     *
     * @return value of description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Sets description for the class GameEvent.
     *
     * @param description value of description
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Gets game for the class GameEvent
     *
     * @return value of game
     */
    public Game getGame()
    {
        return game;
    }

    /**
     * Sets game for the class GameEvent.
     *
     * @param game value of game
     */
    public void setGame(Game game)
    {
        this.game = game;
    }

    /**
     * Gets playerMain for the class GameEvent
     *
     * @return value of playerMain
     */
    public Player getPlayerMain()
    {
        return playerMain;
    }

    /**
     * Sets playerMain for the class GameEvent.
     *
     * @param playerMain value of playerMain
     */
    public void setPlayerMain(Player playerMain)
    {
        this.playerMain = playerMain;
    }

    /**
     * Gets playerIn for the class GameEvent
     *
     * @return value of playerIn
     */
    public Player getPlayerIn()
    {
        return playerIn;
    }

    /**
     * Sets playerIn for the class GameEvent.
     *
     * @param playerIn value of playerIn
     */
    public void setPlayerIn(Player playerIn)
    {
        this.playerIn = playerIn;
    }

    /**
     * Gets playerAssist for the class GameEvent
     *
     * @return value of playerAssist
     */
    public Player getPlayerAssist()
    {
        return playerAssist;
    }

    /**
     * Sets playerAssist for the class GameEvent.
     *
     * @param playerAssist value of playerAssist
     */
    public void setPlayerAssist(Player playerAssist)
    {
        this.playerAssist = playerAssist;
    }
}