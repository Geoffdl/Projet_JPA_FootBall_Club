package fr.diginamic.geoff.service.entity;

import jakarta.persistence.EntityManager;

/**
 * This class orchestrates Dao and mappers to generate entities and persist them in the database
 * It implements a caching method using a sourceId from the data and an instance of the object, either created or fetched from the database if existing
 */
public class PlayerValuationService
{
    public PlayerValuationService(EntityManager em) {}
}