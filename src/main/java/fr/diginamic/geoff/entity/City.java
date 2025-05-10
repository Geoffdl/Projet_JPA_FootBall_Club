package fr.diginamic.geoff.entity;

import jakarta.persistence.*;

@Entity
public class City
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Long cityId;
}