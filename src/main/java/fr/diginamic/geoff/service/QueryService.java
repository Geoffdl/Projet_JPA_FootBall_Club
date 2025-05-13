package fr.diginamic.geoff.service;

import fr.diginamic.geoff.entity.Player;
import fr.diginamic.geoff.utils.InputHelper;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Scanner;

public class QueryService
{
    EntityManager em;
    Scanner sc;

    public QueryService(EntityManager em, Scanner sc)
    {
        this.em = em;

    }

    public QueryService(Scanner sc)
    {

    }

    public void bestStrikersByYear()
    {
        System.out.println("Enter year: ");
        int year = InputHelper.askUser(sc);

        List<Player> result = em.createQuery("SELECT p, SUM(a.goals) as total_goals FROM Player p JOIN p.appearances a LEFT JOIN a.game g WHERE FUNCTION('YEAR', g.gameDate) = :year GROUP BY p ORDER BY total_goals DESC")
                .setParameter("year", year).setMaxResults(20).getResultList();
    }

    public void bestStrikerForContestByYear() {}

    public void bestStrikerByClubByYear() {}

    public void allMatchsBetweenTwoTeamsWithWinPercentage() {}

}