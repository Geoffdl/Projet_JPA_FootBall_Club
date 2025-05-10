package fr.diginamic.geoff.entity;

import jakarta.persistence.*;

@Entity
public class Agent
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agent_id")

    private Long x;
}