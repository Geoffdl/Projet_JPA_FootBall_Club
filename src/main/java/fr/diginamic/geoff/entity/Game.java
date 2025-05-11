package fr.diginamic.geoff.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Game
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Long gameId;

    @Column(name = "source_id", unique = true)
    private Long sourceId;

    @Column(name = "game_date")
    private LocalDate gameDate;
    @Column(name = "attendance")
    private Integer attendanceCount;
    @Column(name = "referee")
    private String refereeName;
    @Column(name = "home_team_score")
    private Integer homeTeamScore;
    @Column(name = "away_team_score")
    private Integer awayTeamScore;

    @OneToMany(mappedBy = "game")
    private Set<ClubGame> clubGames = new HashSet<>();


    @ManyToOne
    @JoinColumn(name = "stadium_id", referencedColumnName = "stadium_id")
    private Stadium stadium;
    @ManyToOne
    @JoinColumn(name = "round_id", referencedColumnName = "round_id")
    private CompetitionRound round;


    @OneToMany(mappedBy = "game")
    private Set<GameEvent> gameEvents = new HashSet<>();;
    @OneToMany(mappedBy = "game")
    private Set<GameAppearance> gameAppearances = new HashSet<>();;
    @OneToMany(mappedBy = "game")
    private Set<GameLineup> gameLineups = new HashSet<>();

    public Game()
    {
    }

    /**
     * Gets sourceId for the class Game
     *
     * @return value of sourceId
     */
    public Long getSourceId()
    {
        return sourceId;
    }

    /**
     * Sets sourceId for the class Game.
     *
     * @param sourceId value of sourceId
     */
    public void setSourceId(Long sourceId)
    {
        this.sourceId = sourceId;
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
    public Integer getAttendanceCount()
    {
        return attendanceCount;
    }

    /**
     * Sets attendanceCount for the class Game.
     *
     * @param attendanceCount value of attendanceCount
     */
    public void setAttendanceCount(Integer attendanceCount)
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
    public Integer getHomeTeamScore()
    {
        return homeTeamScore;
    }

    /**
     * Sets homeTeamScore for the class Game.
     *
     * @param homeTeamScore value of homeTeamScore
     */
    public void setHomeTeamScore(Integer homeTeamScore)
    {
        this.homeTeamScore = homeTeamScore;
    }

    /**
     * Gets awayTeamScore for the class Game
     *
     * @return value of awayTeamScore
     */
    public Integer getAwayTeamScore()
    {
        return awayTeamScore;
    }

    /**
     * Sets awayTeamScore for the class Game.
     *
     * @param awayTeamScore value of awayTeamScore
     */
    public void setAwayTeamScore(Integer awayTeamScore)
    {
        this.awayTeamScore = awayTeamScore;
    }

    /**
     * Gets clubGames for the class Game
     *
     * @return value of clubGames
     */
    public Set<ClubGame> getClubGames()
    {
        return clubGames;
    }

    /**
     * Sets clubGames for the class Game.
     *
     * @param clubGames value of clubGames
     */
    public void setClubGames(Set<ClubGame> clubGames)
    {
        this.clubGames = clubGames;
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

    /**
     * Gets gameLineups for the class Game
     *
     * @return value of gameLineups
     */
    public Set<GameLineup> getGameLineups()
    {
        return gameLineups;
    }

    /**
     * Sets gameLineups for the class Game.
     *
     * @param gameLineups value of gameLineups
     */
    public void setGameLineups(Set<GameLineup> gameLineups)
    {
        this.gameLineups = gameLineups;
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

}