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

}