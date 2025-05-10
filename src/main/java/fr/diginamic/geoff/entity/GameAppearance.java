package fr.diginamic.geoff.entity;

import jakarta.persistence.*;

@Entity
public class GameAppearance
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_appearance_id")
    private Long x;
}