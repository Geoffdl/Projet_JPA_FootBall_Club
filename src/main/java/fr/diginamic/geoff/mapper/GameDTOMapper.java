package fr.diginamic.geoff.mapper;

import fr.diginamic.geoff.dto.GameDTO;
import fr.diginamic.geoff.entity.*;
import fr.diginamic.geoff.entity.compositeid.ClubGameId;
import fr.diginamic.geoff.entity.lookup.Side;

/**
 *
 */
public class GameDTOMapper
{
    private final GameDTO dto;

    public GameDTOMapper(GameDTO dto)
    {
        this.dto = dto;
    }

    public Game mapToGame(Game game)
    {
        game.setSourceId(dto.getGameId());
        game.setGameDate(dto.getDate());
        game.setRound(dto.getRound());
        game.setSeason(dto.getSeason());
        game.setAttendanceCount(dto.getAttendance());
        game.setRefereeName(dto.getRefereeName());
        game.setHomeTeamScore(dto.getHomeClubGoals());
        game.setAwayTeamScore(dto.getAwayClubGoals());

        return game;
    }

    public ClubGame mapToClubGame(ClubGame clubGame, boolean isHome, Club club, Game game)
    {
        Long sourceclubId;
        if (isHome)
        {
            sourceclubId = dto.getHomeClubId();
        } else
        {
            sourceclubId = dto.getAwayClubId();
        }
        ClubGameId id = new ClubGameId(club.getClubId(), game.getGameId());
        clubGame.setClubGameId(id);
        clubGame.setSourceGameId(dto.getGameId());
        if (isHome)
        {
            clubGame.setSourceClubId(dto.getHomeClubId());
            clubGame.setSide(Side.HOME);
            clubGame.setManagerName(dto.getHomeClubManagerName());
            clubGame.setTacticalFormation(dto.getHomeClubFormation());
        } else
        {
            clubGame.setSourceClubId(dto.getAwayClubId());
            clubGame.setManagerName(dto.getAwayClubManagerName());
            clubGame.setTacticalFormation(dto.getAwayClubFormation());
            clubGame.setSide(Side.AWAY);
        }
        clubGame.setClub(club);
        clubGame.setGame(game);
        return clubGame;
    }

    public Stadium mapToStadium(Stadium stadium)
    {
        stadium.setName(dto.getStadiumName());

        return stadium;
    }

//    public CompetitionRound mapToCompetitionRound(CompetitionRound round)
//    {
//        round.setRound(dto.getRound());
//        round.setSeason(dto.getSeason());
//        return round;
//    }

    public Competition mapToCompetition(Competition competition)
    {
        competition.setSourceId(dto.getCompetitionId());
        competition.setCompetitionType(dto.getCompetitionType());
        return competition;
    }

    public Club mapToClub(Club club, boolean isHome)
    {
        if (isHome)
        {
            club.setSourceId(dto.getHomeClubId());
        } else
        {
            club.setSourceId(dto.getAwayClubId());
        }
        return club;
    }

}