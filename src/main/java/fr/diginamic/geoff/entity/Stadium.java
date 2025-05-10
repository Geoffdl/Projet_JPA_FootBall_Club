package fr.diginamic.geoff.entity;

import jakarta.persistence.*;

@Entity
public class Stadium
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stadium_id")

    private Long x;
}