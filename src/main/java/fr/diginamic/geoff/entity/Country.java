package fr.diginamic.geoff.entity;

import jakarta.persistence.*;

@Entity
public class Country
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")

    private Long x;
}