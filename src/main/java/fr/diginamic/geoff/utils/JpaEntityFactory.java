package fr.diginamic.geoff.utils;

import fr.diginamic.geoff.dto.*;
import fr.diginamic.geoff.entity.*;
import fr.diginamic.geoff.mapper.*;

/**
 * Helper class that instantiates entities with the proper data source before being mapped through the matching dto mapper
 */
public class JpaEntityFactory
{

    /**
     * Create target Entity From Given DTO
     *
     * @param playerDTO source data
     * @return new instance of JPA entity
     */
    public static Player createPlayer(PlayerDTO playerDTO)
    {
        Player player = new Player();
        PlayerDTOMapper mapper = new PlayerDTOMapper(playerDTO);
        return mapper.mapToPlayer(player);
    }

    /**
     * Create target Entity From Given DTO
     *
     * @param playerDTO source data
     * @return new instance of JPA entity
     */
    public static Url createUrl(PlayerDTO playerDTO, boolean isImage)
    {
        Url url = new Url();
        PlayerDTOMapper mapper = new PlayerDTOMapper(playerDTO);
        return mapper.mapToUrl(url, isImage);
    }

    /**
     * Create target Entity From Given DTO
     *
     * @param playerDTO source data
     * @return new instance of JPA entity
     */
    public static Club createClub(PlayerDTO playerDTO)
    {
        Club club = new Club();
        PlayerDTOMapper mapper = new PlayerDTOMapper(playerDTO);
        return mapper.mapToClub(club);
    }

    /**
     * Create target Entity From Given DTO
     *
     * @param gameDTO source data
     * @return new instance of JPA entity
     */
    public static Club createClubFromGame(GameDTO gameDTO, boolean isHome)
    {
        Club club = new Club();
        if (isHome)
        {
            club.setSourceId(gameDTO.getHomeClubId());
            return club;
        } else
        {
            club.setSourceId(gameDTO.getAwayClubId());
        }
        return club;
    }

    /**
     * Create target Entity From Given DTO
     *
     * @param dto source data
     * @return new instance of JPA entity
     */
    public static Game createGame(GameDTO dto)
    {
        Game game = new Game();
        GameDTOMapper mapper = new GameDTOMapper(dto);
        return mapper.mapToGame(game);
    }

    /**
     * Create target Entity From Given DTO
     *
     * @param dto source data
     * @return new instance of JPA entity
     */
    public static ClubGame createClubGame(GameDTO dto, boolean isHome, Club club, Game game)
    {
        ClubGame clubGame = new ClubGame();
        GameDTOMapper mapper = new GameDTOMapper(dto);
        return mapper.mapToClubGame(clubGame, isHome, club, game);
    }

    /**
     * Create target Entity From Given DTO
     *
     * @param dto source data
     * @return new instance of JPA entity
     */
    public static Stadium createStadium(GameDTO dto)
    {
        Stadium stadium = new Stadium();
        GameDTOMapper mapper = new GameDTOMapper(dto);
        return mapper.mapToStadium(stadium);
    }

    /**
     * Create target Entity From Given DTO
     *
     * @param dto source data
     * @return new instance of JPA entity
     */
    public static Competition createCompetition(GameDTO dto)
    {
        Competition competition = new Competition();
        GameDTOMapper mapper = new GameDTOMapper(dto);
        return mapper.mapToCompetition(competition);
    }

    /**
     * Create target Entity From Given DTO
     *
     * @param dto source data
     * @return new instance of JPA entity
     */
    public static Competition createCompetitionFromCompetitionDto(CompetitionDTO dto)
    {
        Competition competition = new Competition();
        CompetitionDTOMapper mapper = new CompetitionDTOMapper(dto);
        return mapper.mapToCompetition(competition);
    }

    /**
     * Create target Entity From Given DTO
     *
     * @param dto source data
     * @return new instance of JPA entity
     */
    public static Country createCountryFromCompetition(CompetitionDTO dto)
    {
        Country country = new Country();
        CompetitionDTOMapper mapper = new CompetitionDTOMapper(dto);
        return mapper.mapToCountry(country);
    }

    /**
     * Create target Entity From Given DTO
     *
     * @param dto source data
     * @return new instance of JPA entity
     */
    public static Url createUrlFromCompetition(CompetitionDTO dto)
    {
        Url url = new Url();
        CompetitionDTOMapper mapper = new CompetitionDTOMapper(dto);
        return mapper.mapToUrl(url);
    }

    /**
     * Create target Entity From Given DTO
     *
     * @param dto source data
     * @return new instance of JPA entity
     */
    public static Club createClubFromClub(ClubDTO dto)
    {
        Club club = new Club();
        ClubDTOMapper mapper = new ClubDTOMapper(dto);
        return mapper.mapToClub(club);
    }

    /**
     * Create target Entity From Given DTO
     *
     * @param dto source data
     * @return new instance of JPA entity
     */
    public static Stadium createStadiumFromClub(ClubDTO dto)
    {
        Stadium stadium = new Stadium();
        ClubDTOMapper mapper = new ClubDTOMapper(dto);
        return mapper.mapToStadium(stadium);
    }

    /**
     * Create target Entity From Given DTO
     *
     * @param dto source data
     * @return new instance of JPA entity
     */
    public static Url createUrlFromClub(ClubDTO dto)
    {
        Url url = new Url();
        ClubDTOMapper mapper = new ClubDTOMapper(dto);
        return mapper.mapToUrl(url);
    }

    /**
     * Create target Entity From Given DTO
     *
     * @param dto source data
     * @return new instance of JPA entity
     */
    public static GameEvent createGameEvent(GameEventDTO dto)
    {
        GameEvent gameEvent = new GameEvent();
        GameEventDtoMapper mapper = new GameEventDtoMapper(dto);
        return mapper.mapToGameEvent(gameEvent);
    }

    /**
     * Create target Entity From Given DTO
     *
     * @param dto source data
     * @return new instance of JPA entity
     */
    public static GameLineup createGameLineup(GameLineupDTO dto, Game game, Player player)
    {
        GameLineup gameLineup = new GameLineup();
        GameLineupDTOMapper mapper = new GameLineupDTOMapper(dto);
        return mapper.mapToGameLineup(gameLineup, game, player);
    }

    /**
     * Create target Entity From Given DTO
     *
     * @param dto source data
     * @return new instance of JPA entity
     */
    public static GameAppearance createGameAppearance(AppearanceDTO dto, Game game, Player player)
    {
        GameAppearance gameAppearance = new GameAppearance();
        AppearanceDTOMapper mapper = new AppearanceDTOMapper(dto);
        return mapper.mapToGameAppearance(gameAppearance, game, player);
    }

    /**
     * Create target Entity From Given DTO
     *
     * @param dto source data
     * @return new instance of JPA entity
     */
    public static Country createCountry(PlayerDTO dto, boolean isBirth)
    {
        Country country = new Country();
        PlayerDTOMapper mapper = new PlayerDTOMapper(dto);
        if (isBirth)
        {
            return mapper.mapToCountryBirth(country);
        } else
        {
            return mapper.mapToCountryCitizenship(country);
        }
    }
}