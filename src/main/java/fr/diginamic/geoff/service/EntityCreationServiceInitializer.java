package fr.diginamic.geoff.service;

import fr.diginamic.geoff.utils.DTOListCreator;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EntityCreationServiceInitializer
{
    private static final Logger LOGGER = LoggerFactory.getLogger(EntityCreationServiceInitializer.class);
    private final EntityManager em;

    public EntityCreationServiceInitializer(EntityManager em)
    {
        this.em = em;
    }

    public void initiatePersistence()
    {
        try
        {
            EntityCreationService entityCreationService = initializeServices(em);
            entityCreationService.createEntities();
        } catch (Exception e)
        {
            LOGGER.error("error {}", e.getMessage());
        }
    }

    private EntityCreationService initializeServices(EntityManager em)
    {
        DTOListCreator dtoListCreator = new DTOListCreator();
        return new EntityCreationService(em, dtoListCreator);
    }
}