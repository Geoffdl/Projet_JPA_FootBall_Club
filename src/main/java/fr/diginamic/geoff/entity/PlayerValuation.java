package fr.diginamic.geoff.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "player_valuation")
public class PlayerValuation
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_valuation_id")
    private Long playerValuationId;

    @Column(name = "datetime")
    private LocalDateTime valuationDateTime;

    @Column(name = "marker_value_in_euro")
    private double marketValue;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    public PlayerValuation()
    {
    }

    /**
     * Gets playerValuationId for the class PlayerValuation
     *
     * @return value of playerValuationId
     */
    public Long getPlayerValuationId()
    {
        return playerValuationId;
    }

    /**
     * Gets valuationDateTime for the class PlayerValuation
     *
     * @return value of valuationDateTime
     */
    public LocalDateTime getValuationDateTime()
    {
        return valuationDateTime;
    }

    /**
     * Sets valuationDateTime for the class PlayerValuation.
     *
     * @param valuationDateTime value of valuationDateTime
     */
    public void setValuationDateTime(LocalDateTime valuationDateTime)
    {
        this.valuationDateTime = valuationDateTime;
    }

    /**
     * Gets marketValue for the class PlayerValuation
     *
     * @return value of marketValue
     */
    public double getMarketValue()
    {
        return marketValue;
    }

    /**
     * Sets marketValue for the class PlayerValuation.
     *
     * @param marketValue value of marketValue
     */
    public void setMarketValue(double marketValue)
    {
        this.marketValue = marketValue;
    }

    /**
     * Gets player for the class PlayerValuation
     *
     * @return value of player
     */
    public Player getPlayer()
    {
        return player;
    }

    /**
     * Sets player for the class PlayerValuation.
     *
     * @param player value of player
     */
    public void setPlayer(Player player)
    {
        this.player = player;
    }
}