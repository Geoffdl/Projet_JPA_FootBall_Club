package fr.diginamic.geoff.entity;

import jakarta.persistence.*;

@Entity
public class GameLineup
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_lineup_id")
    private Long id;
}