package fr.diginamic.geoff;

import fr.diginamic.geoff.service.MenuService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main
{
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soccer");
        Scanner sc = new Scanner(System.in);

        try (EntityManager em = emf.createEntityManager();)
        {
            MenuService menuService = new MenuService(em, sc);
            menuService.start();

        } catch (Exception e)
        {
            LOGGER.error("error {}", e.getMessage());
        } finally
        {
            emf.close();
        }
    }

}