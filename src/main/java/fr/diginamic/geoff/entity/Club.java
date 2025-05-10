package fr.diginamic.geoff.entity;

import jakarta.persistence.*;

@Entity
public class Club
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "club_id")

    private Long x;
}