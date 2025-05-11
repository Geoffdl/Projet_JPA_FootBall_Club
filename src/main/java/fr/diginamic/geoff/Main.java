package fr.diginamic.geoff;

import fr.diginamic.geoff.utils.DTOListCreator;
import fr.diginamic.geoff.service.EntityCreationService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main
{
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args)
    {
        System.out.println("Hello, World!");

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

    private static EntityCreationService initializeServices(EntityManager em)
    {
        DTOListCreator dtoListCreator = new DTOListCreator();
        return new EntityCreationService(em, dtoListCreator);
    }

}