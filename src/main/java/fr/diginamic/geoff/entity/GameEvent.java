package fr.diginamic.geoff.entity;

import fr.diginamic.geoff.entity.lookup.EventType;
import jakarta.persistence.*;

@Entity
@Table(name = "game_event")
public class GameEvent
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "source_id", unique = true)
    private String sourceId;

    @Column(name = "event_minute")
    private int eventMinute;

    @Enumerated(EnumType.STRING)
    @Column(name = "event_type")
    private EventType eventType;
    private String description;

    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "game_id")
    private Game game;
    @ManyToOne
    @JoinColumn(name = "player_id", referencedColumnName = "player_id")
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

    /**
     * Gets id for the class GameEvent
     *
     * @return value of id
     */
    public Long getId()
    {
        return id;
    }


    /**
     * Gets sourceId for the class GameEvent
     *
     * @return value of sourceId
     */
    public String getSourceId()
    {
        return sourceId;
    }

    /**
     * Sets sourceId for the class GameEvent.
     *
     * @param sourceId value of sourceId
     */
    public void setSourceId(String sourceId)
    {
        this.sourceId = sourceId;
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