package fr.diginamic.geoff.entity;

import jakarta.persistence.*;

@Entity
public class ClubGame
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "club_game_id")

    private Long x;
}