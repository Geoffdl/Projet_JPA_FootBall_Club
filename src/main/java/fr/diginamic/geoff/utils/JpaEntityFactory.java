package fr.diginamic.geoff.utils;

import fr.diginamic.geoff.dto.GameDTO;
import fr.diginamic.geoff.dto.PlayerDTO;
import fr.diginamic.geoff.entity.*;
import fr.diginamic.geoff.mapper.GameDTOMapper;
import fr.diginamic.geoff.mapper.PlayerDTOMapper;

public class JpaEntityFactory
{

    public Player createPlayer(PlayerDTO playerDTO)
    {
        Player player = new Player();
        PlayerDTOMapper mapper = new PlayerDTOMapper(playerDTO);
        return mapper.mapToPlayer(player);
    }

    public Agent createAgent(PlayerDTO playerDTO)
    {
        Agent agent = new Agent();
        PlayerDTOMapper mapper = new PlayerDTOMapper(playerDTO);
        return mapper.mapToAgent(agent);
    }

    public City createCity(PlayerDTO playerDTO)
    {
        City city = new City();
        PlayerDTOMapper mapper = new PlayerDTOMapper(playerDTO);
        return mapper.mapToCity(city);
    }

    public Url createUrl(PlayerDTO playerDTO)
    {
        Url url = new Url();
        PlayerDTOMapper mapper = new PlayerDTOMapper(playerDTO);
        return mapper.mapToUrl(url);
    }

    public Club createClub(PlayerDTO playerDTO)
    {
        Club club = new Club();
        PlayerDTOMapper mapper = new PlayerDTOMapper(playerDTO);
        return mapper.mapToClub(club);
    }

    public Club createClubFromGame(GameDTO gameDTO, boolean isHome)
    {
        Club club = new Club();
        if (isHome)
        {
            club.setSourceId(gameDTO.getHomeClubId());
            return club;
        }
        club.setSourceId(gameDTO.getAwayClubId());
        return club;
    }

    public Country createCountryBirth(PlayerDTO dto)
    {
        Country country = new Country();
        PlayerDTOMapper mapper = new PlayerDTOMapper(dto);
        return mapper.mapToCountryBirth(country);
    }

    public Country createCountryCitizenship(PlayerDTO dto)
    {
        Country country = new Country();
        PlayerDTOMapper mapper = new PlayerDTOMapper(dto);
        return mapper.mapToCountryCitizenship(country);
    }

    public Game createGame(GameDTO dto)
    {
        Game game = new Game();
        GameDTOMapper mapper = new GameDTOMapper(dto);
        return mapper.mapToGame(game);
    }


    public ClubGame createClubGame(GameDTO dto, boolean isHome, Club club, Game game)
    {
        ClubGame clubGame = new ClubGame();
        GameDTOMapper mapper = new GameDTOMapper(dto);
        return mapper.mapToClubGame(clubGame, isHome, club, game);
    }

    public Stadium createStadium(GameDTO dto)
    {
        Stadium stadium = new Stadium();
        GameDTOMapper mapper = new GameDTOMapper(dto);
        return mapper.mapToStadium(stadium);
    }

    public CompetitionRound createCompetitionRound(GameDTO dto)
    {
        CompetitionRound competitionRound = new CompetitionRound();
        GameDTOMapper mapper = new GameDTOMapper(dto);
        return mapper.mapToCompetitionRound(competitionRound);
    }

    public Competition createCompetition(GameDTO dto)
    {
        Competition competition = new Competition();
        GameDTOMapper mapper = new GameDTOMapper(dto);
        return mapper.mapToCompetition(competition);
    }
}