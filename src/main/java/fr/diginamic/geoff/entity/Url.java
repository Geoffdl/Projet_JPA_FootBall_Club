package fr.diginamic.geoff.entity;

import fr.diginamic.geoff.entity.lookup.EntityType;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Url
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "url_id")
    private Long url_id;

    private String url;

    @Enumerated(EnumType.STRING)
    private EntityType entityType;

    @OneToOne(mappedBy = "url")
    private Club club;
    @OneToMany(mappedBy = "pictureUrl")
    private Set<Player> playerPicture;
    @OneToOne(mappedBy = "dataUrl")
    private Player playerData;
    @OneToOne(mappedBy = "url")
    private Competition competition;

    public Url()
    {
    }

    /**
     * Gets url_id for the class Url
     *
     * @return value of url_id
     */
    public Long getUrl_id()
    {
        return url_id;
    }

    /**
     * Gets url for the class Url
     *
     * @return value of url
     */
    public String getUrl()
    {
        return url;
    }

    /**
     * Sets url for the class Url.
     *
     * @param url value of url
     */
    public void setUrl(String url)
    {
        this.url = url;
    }

    /**
     * Gets entityType for the class Url
     *
     * @return value of entityType
     */
    public EntityType getEntityType()
    {
        return entityType;
    }

    /**
     * Sets entityType for the class Url.
     *
     * @param entityType value of entityType
     */
    public void setEntityType(EntityType entityType)
    {
        this.entityType = entityType;
    }

    /**
     * Gets club for the class Url
     *
     * @return value of club
     */
    public Club getClub()
    {
        return club;
    }

    /**
     * Sets club for the class Url.
     *
     * @param club value of club
     */
    public void setClub(Club club)
    {
        this.club = club;
    }

    /**
     * Gets playerPicture for the class Url
     *
     * @return value of playerPicture
     */
    public Set<Player> getPlayerPicture()
    {
        return playerPicture;
    }

    /**
     * Sets playerPicture for the class Url.
     *
     * @param playerPicture value of playerPicture
     */
    public void setPlayerPicture(Set<Player> playerPicture)
    {
        this.playerPicture = playerPicture;
    }

    /**
     * Gets playerData for the class Url
     *
     * @return value of playerData
     */
    public Player getPlayerData()
    {
        return playerData;
    }

    /**
     * Sets playerData for the class Url.
     *
     * @param playerData value of playerData
     */
    public void setPlayerData(Player playerData)
    {
        this.playerData = playerData;
    }

    /**
     * Gets competition for the class Url
     *
     * @return value of competition
     */
    public Competition getCompetition()
    {
        return competition;
    }

    /**
     * Sets competition for the class Url.
     *
     * @param competition value of competition
     */
    public void setCompetition(Competition competition)
    {
        this.competition = competition;
    }
}