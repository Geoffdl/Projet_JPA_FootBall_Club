package fr.diginamic.geoff;

import fr.diginamic.geoff.builder.ClubDTOBuilder;
import fr.diginamic.geoff.builder.DTOBuilder;
import fr.diginamic.geoff.entity.Player;
import fr.diginamic.geoff.service.AgentService;
import fr.diginamic.geoff.service.DTOCreationService;
import fr.diginamic.geoff.service.EntityCreationService;
import fr.diginamic.geoff.service.PlayerService;
import fr.diginamic.geoff.utils.JpaEntityFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

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
        DTOCreationService dtoCreationService = new DTOCreationService();
        return new EntityCreationService(em, dtoCreationService);
    }

}