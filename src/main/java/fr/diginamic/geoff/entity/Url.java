package fr.diginamic.geoff.entity;

import jakarta.persistence.*;

@Entity
public class Url
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "url_id")

    private Long x;
}