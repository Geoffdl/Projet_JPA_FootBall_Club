package fr.diginamic.geoff.service;

import fr.diginamic.geoff.utils.DTOListCreator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EntityCreationServiceInitializer
{
    private static final Logger LOGGER = LoggerFactory.getLogger(EntityCreationServiceInitializer.class);

    public EntityCreationServiceInitializer()
    {
    }

    public void initiatePersistence()
    {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("soccer");
             EntityManager em = emf.createEntityManager();)
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