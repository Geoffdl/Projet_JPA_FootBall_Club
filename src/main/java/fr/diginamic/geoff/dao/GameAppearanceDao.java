package fr.diginamic.geoff.dao;

import jakarta.persistence.EntityManager;

public class GameAppearanceDao
{
    EntityManager em;

    public GameAppearanceDao(EntityManager em)
    {
        this.em = em;
    }
}