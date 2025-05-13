package fr.diginamic.geoff.service;

import fr.diginamic.geoff.utils.InputHelper;
import jakarta.persistence.EntityManager;

import java.util.Scanner;

public class MenuService
{
    private final Scanner sc;
    private final EntityManager em;

    public MenuService(EntityManager em, Scanner sc)
    {
        this.sc = sc;
        this.em = em;
    }

    public void start()
    {
        while (true)
        {
            welcome();
            int choice = InputHelper.askUser(sc);

            switch (choice)
            {
                case 1:
                    EntityCreationServiceInitializer dataPersister = new EntityCreationServiceInitializer(em);
                    dataPersister.initiatePersistence();
                    break;
                case 2:
                    openQueryMenu();
                    break;
                case 3:
                    goodBye();
                    return;
            }

        }
    }


    private void openQueryMenu()
    {
        QueryService queryService = new QueryService(em, sc);
        while (true)
        {
            displayOptions();
            int choice = InputHelper.askUser(sc);

            switch (choice)
            {
                case 1:
                    queryService.bestStrikersByYear();
                    break;
                case 2:
                    queryService.bestStrikerForContestByYear();
                    break;
                case 3:
                    queryService.bestStrikerByClubByYear();
                    break;
                case 4:
                    queryService.allMatchsBetweenTwoTeamsWithWinPercentage();
                    break;
                case 5:
                    return;
            }

        }
    }

    private void goodBye()
    {
        System.out.println("\nThank you for using Football Manager!");
        System.out.println("Goodbye!");
    }

    private void displayOptions()
    {
        System.out.println("\n========== Query Menu ==========");
        System.out.println("1. Best strikers by year");
        System.out.println("2. Best striker for contest by year");
        System.out.println("3. Best striker by club by year");
        System.out.println("4. All matches between two teams with win percentage");
        System.out.println("5. Back to main menu");
        System.out.print("Your choice: ");
    }

    private void welcome()
    {
        System.out.println("=====================================");
        System.out.println("      Welcome to Football Manager     ");
        System.out.println("=====================================");
        System.out.println("Please choose an option:");
        System.out.println("1. Import and persist data");
        System.out.println("2. Query the database");
        System.out.println("3. Exit");
        System.out.print("Your choice: ");
    }
}