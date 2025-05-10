package fr.diginamic.geoff.entity;

import jakarta.persistence.*;

@Entity
public class GameEvent
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_event_id")

    private Long x;
}