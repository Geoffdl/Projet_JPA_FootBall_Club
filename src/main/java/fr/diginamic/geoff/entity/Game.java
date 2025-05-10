package fr.diginamic.geoff.entity;

import jakarta.persistence.*;

@Entity
public class Game
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")

    private Long x;
}