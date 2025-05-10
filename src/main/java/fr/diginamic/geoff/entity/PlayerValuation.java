package fr.diginamic.geoff.entity;

import jakarta.persistence.*;

@Entity
public class PlayerValuation
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_valuation_id")

    private Long x;
}