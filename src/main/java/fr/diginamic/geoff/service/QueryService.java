package fr.diginamic.geoff.service;

import fr.diginamic.geoff.entity.ClubGame;
import fr.diginamic.geoff.entity.Game;
import fr.diginamic.geoff.entity.Player;
import fr.diginamic.geoff.entity.lookup.Side;
import fr.diginamic.geoff.utils.InputHelper;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Scanner;

/**
 * Service class containing a set of queries for the user to ask to the database
 */
public class QueryService
{
    EntityManager em;
    Scanner sc;

    public QueryService(EntityManager em, Scanner sc)
    {
        this.em = em;
        this.sc = sc;
    }

    /**
     * List of best strikers by given year
     */
    public void bestStrikersByYear()
    {
        System.out.print("\nEnter year: ");
        int year = InputHelper.askUser(sc);
        System.out.print("\nEnter result size: ");
        int qt = InputHelper.askUser(sc);
        System.out.printf("\n....searching for %d best strikers in %d", qt, year);

        List<Object[]> results = em.createQuery("SELECT p, SUM(a.goals) as total_goals FROM Player p JOIN p.appearances a LEFT JOIN a.game g WHERE FUNCTION('YEAR', g.gameDate) = :year GROUP BY p ORDER BY total_goals DESC", Object[].class).setParameter("year", year).setMaxResults(qt).getResultList();

        System.out.printf("\nBest strikers for year: %d", year);
        for (Object[] obj : results)
        {
            Player player = (Player) obj[0];
            Long goals = (Long) obj[1];
            System.out.printf("\n\t Player: %s \n  \t\t\t\t- Goals: %d", player.getPlayerCode(), goals);
        }
        System.out.println("\n");
    }

    /**
     * List of best strikers for a given contest for a given year
     */
    public void bestStrikerForContestByYear()
    {
        System.out.print("\nEnter competition name: ");
        String competition = sc.nextLine();
        System.out.print("\nEnter year: ");
        int year = InputHelper.askUser(sc);
        System.out.print("\nEnter result size: ");
        int qt = InputHelper.askUser(sc);
        System.out.printf("\n....searching for %d best strikers in %d for the competition %s\n...", qt, year, competition);

        List<Object[]> results = em.createQuery("SELECT p, SUM(a.goals) as totalGoals FROM Player p  join p.appearances a  JOIN a.game g  JOIN g.competition c " + "WHERE c.competitionName = :competition AND FUNCTION('YEAR', g.gameDate) = :year GROUP BY p ORDER BY totalGoals DESC LIMIT :qt", Object[].class).setParameter("competition", competition).setParameter("year", year).setParameter("qt", qt).getResultList();

        if (results.isEmpty())
        {
            System.out.println("\n0 match");
        }
        for (Object[] obj : results)
        {
            Player player = (Player) obj[0];
            Long goals = (Long) obj[1];
            if (player != null)
            {
                System.out.printf("\n\t Player: %s \n  \t\t\t\t- Goals: %d", player.getPlayerCode(), goals);
            }

        }

    }

    /**
     * list of best strikers for a given club for a given year
     */
    public void bestStrikerByClubByYear()
    {

        System.out.print("\nEnter club name: ");
        String club = sc.nextLine();
        System.out.print("\nEnter year: ");
        int year = InputHelper.askUser(sc);
        System.out.print("\nEnter result size: ");
        int qt = InputHelper.askUser(sc);
        System.out.printf("\n....searching for %d best strikers in %d for the competition %s\n...", qt, year, club);

        List<Object[]> results = em.createQuery("SELECT c.clubName, p, SUM(a.goals) as totalGoals FROM Player p JOIN p.appearances a JOIN a.game g JOIN p.currentClub c WHERE c.clubName = :club AND FUNCTION('YEAR', g.gameDate) = :year GROUP BY  p ORDER BY totalGoals DESC LIMIT :qt", Object[].class).setParameter("club", club).setParameter("year", year).setParameter("qt", qt).getResultList();

        if (results.isEmpty())
        {
            System.out.println("\n0 match");
        }
        for (Object[] obj : results)
        {
            String clubName = (String) obj[0];
            Player player = (Player) obj[1];
            Long goals = (Long) obj[2];
            if (player != null)
            {
                System.out.printf("\n\t club: %s\n\t\t Player: %s \n  \t\t\t\t- Goals: %d", clubName, player.getPlayerCode(), goals);
            }
        }
    }

    /**
     * list of matches between two teams and their track record
     */
    public void allMatchsBetweenTwoTeamsWithWinPercentage()
    {
        System.out.print("\nEnter first club name: ");
        String club1 = sc.nextLine();
        System.out.print("\nEnter second club name: ");
        String club2 = sc.nextLine();

        List<Game> games = em.createQuery("SELECT DISTINCT g FROM Game g JOIN g.clubGames cg1 JOIN g.clubGames cg2 " + "WHERE cg1.club.clubName = :club1 AND cg2.club.clubName = :club2 AND cg1.side <> cg2.side", Game.class).setParameter("club1", club1).setParameter("club2", club2).getResultList();

        int club1Wins = 0, club2Wins = 0, draws = 0;

        for (Game g : games)
        {
            ClubGame home = g.getClubGames().stream().filter(cg -> cg.getSide() == Side.HOME).findFirst().orElse(null);
            ClubGame away = g.getClubGames().stream().filter(cg -> cg.getSide() == Side.AWAY).findFirst().orElse(null);

            if (home == null || away == null) continue;

            int homeScore = g.getHomeTeamScore();
            int awayScore = g.getAwayTeamScore();

            if (home.getClub().getClubName().equals(club1))
            {
                if (homeScore > awayScore) club1Wins++;
                else if (homeScore < awayScore) club2Wins++;
                else draws++;
            } else
            {
                if (awayScore > homeScore) club1Wins++;
                else if (awayScore < homeScore) club2Wins++;
                else draws++;
            }
        }

        int total = club1Wins + club2Wins + draws;
        float c1WinRate = ((float) club1Wins / total) * 100;
        float c2WinRate = ((float) club2Wins / total) * 100;
        System.out.printf("\nTotal matches: %d", total);
        System.out.printf("\n%s wins total: %d (%f)", club1Wins, total, c1WinRate);
        System.out.printf("\n%s wins total: %d (%f)", club2Wins, total, c2WinRate);
        System.out.printf("Draws: %d", draws);
    }

}