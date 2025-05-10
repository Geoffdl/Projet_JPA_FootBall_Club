package fr.diginamic.geoff.entity;

import jakarta.persistence.*;

@Entity
public class Round
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "round_id")

    private Long x;
}