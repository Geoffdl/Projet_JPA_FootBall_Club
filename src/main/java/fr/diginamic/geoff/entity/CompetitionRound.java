package fr.diginamic.geoff.entity;

import jakarta.persistence.*;

import java.time.Year;
import java.util.Set;

@Entity
@Table(name = "competition_round")
public class CompetitionRound
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "round_id")
    private Long roundId;

    private Year season;
    private String round;

    @OneToMany(mappedBy = "round")
    private Set<Game> games;
    @ManyToOne
    @JoinColumn(name = "competition_id", referencedColumnName = "competition_id")
    private Competition competition;

    public CompetitionRound()
    {
    }

    public CompetitionRound(Year season, String round, Set<Game> games, Competition competition)
    {
        this.season = season;
        this.round = round;
        this.games = games;
        this.competition = competition;
    }

    /**
     * Gets roundId for the class Round
     *
     * @return value of roundId
     */
    public Long getRoundId()
    {
        return roundId;
    }

    /**
     * Gets season for the class Round
     *
     * @return value of season
     */
    public Year getSeason()
    {
        return season;
    }

    /**
     * Sets season for the class Round.
     *
     * @param season value of season
     */
    public void setSeason(Year season)
    {
        this.season = season;
    }

    /**
     * Gets round for the class Round
     *
     * @return value of round
     */
    public String getRound()
    {
        return round;
    }

    /**
     * Sets round for the class Round.
     *
     * @param round value of round
     */
    public void setRound(String round)
    {
        this.round = round;
    }

    /**
     * Gets games for the class Round
     *
     * @return value of games
     */
    public Set<Game> getGames()
    {
        return games;
    }

    /**
     * Sets games for the class Round.
     *
     * @param games value of games
     */
    public void setGames(Set<Game> games)
    {
        this.games = games;
    }

    /**
     * Gets competition for the class Round
     *
     * @return value of competition
     */
    public Competition getCompetition()
    {
        return competition;
    }

    /**
     * Sets competition for the class Round.
     *
     * @param competition value of competition
     */
    public void setCompetition(Competition competition)
    {
        this.competition = competition;
    }
}