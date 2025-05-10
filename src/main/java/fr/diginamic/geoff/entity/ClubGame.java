package fr.diginamic.geoff.entity;

import fr.diginamic.geoff.entity.lookup.Side;
import jakarta.persistence.*;

import java.util.Enumeration;
import java.util.Set;

@Entity
@Table(name = "club_game")
public class ClubGame
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "club_game_id")
    private Long clubGameId;

    @Enumerated(EnumType.STRING)
    private Side side;

    @Column(name = "manager_name")
    private String managerName;

    @Column(name = "tactical_formation")
    private String tacticalFormation;

    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "club_id", referencedColumnName = "club_id")
    private Club club;


    public ClubGame()
    {
    }


}