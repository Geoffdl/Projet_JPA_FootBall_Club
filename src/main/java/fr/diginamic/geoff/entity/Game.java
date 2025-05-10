package fr.diginamic.geoff.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
public class Game
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Long gameId;

    private LocalDate gameDate;
    private int attendanceCount;
    private String refereeName;
    private int homeTeamScore;
    private int awayTeamScore;

    @ManyToOne
    @JoinColumn(name = "home_team_id", referencedColumnName = "club_game_id")
    private ClubGame homeTeam;
    @ManyToOne
    @JoinColumn(name = "away_team_id", referencedColumnName = "club_game_id")
    private ClubGame awayTeam;
    @ManyToOne
    @JoinColumn(name = "stadiumd_id", referencedColumnName = "stadium_id")
    private Stadium stadium;
    @ManyToOne
    @JoinColumn(name = "round_id", referencedColumnName = "round_id")
    private CompetitionRound round;


    @OneToMany(mappedBy = "game")
    private Set<GameEvent> gameEvents;
    @OneToMany(mappedBy = "game")
    private Set<GameAppearance> gameAppearances;

    public Game()
    {
    }

    public Game(LocalDate gameDate, int attendanceCount, String refereeName, int homeTeamScore, int awayTeamScore, ClubGame homeTeam, ClubGame awayTeam, Stadium stadium, CompetitionRound round, Set<GameEvent> gameEvents, Set<GameAppearance> gameAppearances)
    {
        this.gameDate = gameDate;
        this.attendanceCount = attendanceCount;
        this.refereeName = refereeName;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.stadium = stadium;
        this.round = round;
        this.gameEvents = gameEvents;
        this.gameAppearances = gameAppearances;
    }

    /**
     * Gets gameId for the class Game
     *
     * @return value of gameId
     */
    public Long getGameId()
    {
        return gameId;
    }

    /**
     * Gets gameDate for the class Game
     *
     * @return value of gameDate
     */
    public LocalDate getGameDate()
    {
        return gameDate;
    }

    /**
     * Sets gameDate for the class Game.
     *
     * @param gameDate value of gameDate
     */
    public void setGameDate(LocalDate gameDate)
    {
        this.gameDate = gameDate;
    }

    /**
     * Gets attendanceCount for the class Game
     *
     * @return value of attendanceCount
     */
    public int getAttendanceCount()
    {
        return attendanceCount;
    }

    /**
     * Sets attendanceCount for the class Game.
     *
     * @param attendanceCount value of attendanceCount
     */
    public void setAttendanceCount(int attendanceCount)
    {
        this.attendanceCount = attendanceCount;
    }

    /**
     * Gets refereeName for the class Game
     *
     * @return value of refereeName
     */
    public String getRefereeName()
    {
        return refereeName;
    }

    /**
     * Sets refereeName for the class Game.
     *
     * @param refereeName value of refereeName
     */
    public void setRefereeName(String refereeName)
    {
        this.refereeName = refereeName;
    }

    /**
     * Gets homeTeamScore for the class Game
     *
     * @return value of homeTeamScore
     */
    public int getHomeTeamScore()
    {
        return homeTeamScore;
    }

    /**
     * Sets homeTeamScore for the class Game.
     *
     * @param homeTeamScore value of homeTeamScore
     */
    public void setHomeTeamScore(int homeTeamScore)
    {
        this.homeTeamScore = homeTeamScore;
    }

    /**
     * Gets awayTeamScore for the class Game
     *
     * @return value of awayTeamScore
     */
    public int getAwayTeamScore()
    {
        return awayTeamScore;
    }

    /**
     * Sets awayTeamScore for the class Game.
     *
     * @param awayTeamScore value of awayTeamScore
     */
    public void setAwayTeamScore(int awayTeamScore)
    {
        this.awayTeamScore = awayTeamScore;
    }

    /**
     * Gets homeTeam for the class Game
     *
     * @return value of homeTeam
     */
    public ClubGame getHomeTeam()
    {
        return homeTeam;
    }

    /**
     * Sets homeTeam for the class Game.
     *
     * @param homeTeam value of homeTeam
     */
    public void setHomeTeam(ClubGame homeTeam)
    {
        this.homeTeam = homeTeam;
    }

    /**
     * Gets awayTeam for the class Game
     *
     * @return value of awayTeam
     */
    public ClubGame getAwayTeam()
    {
        return awayTeam;
    }

    /**
     * Sets awayTeam for the class Game.
     *
     * @param awayTeam value of awayTeam
     */
    public void setAwayTeam(ClubGame awayTeam)
    {
        this.awayTeam = awayTeam;
    }

    /**
     * Gets stadium for the class Game
     *
     * @return value of stadium
     */
    public Stadium getStadium()
    {
        return stadium;
    }

    /**
     * Sets stadium for the class Game.
     *
     * @param stadium value of stadium
     */
    public void setStadium(Stadium stadium)
    {
        this.stadium = stadium;
    }

    /**
     * Gets round for the class Game
     *
     * @return value of round
     */
    public CompetitionRound getRound()
    {
        return round;
    }

    /**
     * Sets round for the class Game.
     *
     * @param round value of round
     */
    public void setRound(CompetitionRound round)
    {
        this.round = round;
    }

    /**
     * Gets gameEvents for the class Game
     *
     * @return value of gameEvents
     */
    public Set<GameEvent> getGameEvents()
    {
        return gameEvents;
    }

    /**
     * Sets gameEvents for the class Game.
     *
     * @param gameEvents value of gameEvents
     */
    public void setGameEvents(Set<GameEvent> gameEvents)
    {
        this.gameEvents = gameEvents;
    }

    /**
     * Gets gameAppearances for the class Game
     *
     * @return value of gameAppearances
     */
    public Set<GameAppearance> getGameAppearances()
    {
        return gameAppearances;
    }

    /**
     * Sets gameAppearances for the class Game.
     *
     * @param gameAppearances value of gameAppearances
     */
    public void setGameAppearances(Set<GameAppearance> gameAppearances)
    {
        this.gameAppearances = gameAppearances;
    }
}