package fr.diginamic.geoff.entity;

import fr.diginamic.geoff.entity.lookup.Lineup;
import jakarta.persistence.*;

@Entity
@Table(name = "game_lineup")
public class GameLineup
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_lineup_id")
    private Long gameLineupId;

    private Lineup startingLineup;
    private int playerNumber;
    private boolean isTeamCaptain;
    private String position;

    @ManyToOne
    @JoinColumn(name = "player_id", referencedColumnName = "player_id")
    private Player player;
    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "game_id")
    private Game game;
}