package fr.diginamic.geoff.entity;

import jakarta.persistence.*;

@Entity
public class Competition
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "competition_id")

    private Long x;
}