package fr.diginamic.geoff.service;

import fr.diginamic.geoff.dto.*;
import fr.diginamic.geoff.entity.*;
import fr.diginamic.geoff.service.entity.*;
import fr.diginamic.geoff.utils.DTOListCreator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class EntityCreationService
{

    private static final Logger LOGGER = LoggerFactory.getLogger(EntityCreationService.class);

    private final EntityManager em;
    // data initializer
    private final DTOListCreator dtoListCreator;
    //services
    private final PlayerService playerService;
    private final CountryService countryService;
    private final UrlService urlService;
    private final ClubService clubService;
    private final ClubGameService clubGameService;
    private final CompetitionService competitionService;
    private final CompetitionRoundService competitionRoundService;
    private final GameService gameService;
    private final GameAppearanceService gameAppearanceService;
    private final GameEventService gameEventService;
    private final GameLineupService gameLineUpService;
    private final StadiumService stadiumService;
    private final PlayerValuationService playerValuationService;

    private List<PlayerDTO> playerDTOList;
    private List<GameDTO> gameDTOList;
    private List<CompetitionDTO> competitionDTOList;
    private List<ClubDTO> clubDTOList;
    private List<PlayerValuationDTO> playerValuationList;
    private List<GameEventDTO> gameEventDTOList;
    private List<GameLineupDTO> gameLineupDTOList;
    private List<AppearanceDTO> appearanceDTOList;


    public EntityCreationService(EntityManager em, DTOListCreator dtoListCreator)
    {
        this.em = em;
        this.dtoListCreator = dtoListCreator;

        this.countryService = new CountryService(em);
        this.urlService = new UrlService(em);
        this.clubService = new ClubService(em);
        this.clubGameService = new ClubGameService(em);

        this.playerService = new PlayerService(em);
        this.competitionService = new CompetitionService(em);
        this.competitionRoundService = new CompetitionRoundService(em);
        this.gameService = new GameService(em);
        this.gameAppearanceService = new GameAppearanceService(em);
        this.gameLineUpService = new GameLineupService(em);
        this.gameEventService = new GameEventService(em);
        this.stadiumService = new StadiumService(em);
        this.playerValuationService = new PlayerValuationService(em);
    }

    public void createEntities()
    {
        // get data from dump
        initializeDtoLists();

        //for testing purposes
//        limitListSize();

        //creation sequence
        treatPlayerDTO();
        treatGameDTO();
        treatCompetitionDTO();
        treatClubDTO();

        loadPlayersAndGames();
        treatGameLineup();
        treatAppearance();
        treatGameEvent();
    }

    private void loadPlayersAndGames()
    {
        LOGGER.info(".....\tcaching players and games");
        playerService.loadExistingPlayers();
        gameService.loadExistingGames();
    }

    private void treatAppearance()
    {
        LOGGER.info("----------------------- Starting persistence from AppearanceDTO -----------------------");
        LOGGER.info(".....\tcaching existing data");
        gameAppearanceService.loadExisting();
        LOGGER.info(".....\tinserting");
        AtomicInteger count = new AtomicInteger();
        runInTransaction(() ->
        {
            for (AppearanceDTO dto : appearanceDTOList)
            {
                Player player = playerService.findForAppearance(dto);
                Game game = gameService.findForAppearance(dto);
                if (player != null && game != null)
                {
                    GameAppearance gameAppearance = gameAppearanceService.findOrCreate(dto, game, player);
                    em.persist(gameAppearance);
                    count.getAndIncrement();
                }
            }
        }, em);
        LOGGER.info("Finished persistence of {} gameAppearances", count);
        LOGGER.info(".....\tclearing cache");
        gameAppearanceService.clear();
    }

    private void treatGameLineup()
    {
        LOGGER.info("----------------------- Starting persistence from GameLineupDTO -----------------------");
        LOGGER.info(".....\tcaching existing data");

        gameLineUpService.loadExisting();
        LOGGER.info(".....\tinserting");
        AtomicInteger count = new AtomicInteger();
        runInTransaction(() ->
        {
            for (GameLineupDTO dto : gameLineupDTOList)
            {
                Player player = playerService.findForGameLineup(dto);
                Game game = gameService.findForGameLineup(dto);
                if (player != null && game != null)
                {
                    GameLineup gameLineup = gameLineUpService.findOrCreate(dto, game, player);
                    em.persist(gameLineup);
                }
                count.getAndIncrement();
            }
        }, em);
        LOGGER.info("Finished persistence of {} gameLineUps", count);
        LOGGER.info(".....\tclearing cache");
        gameLineUpService.clear();
    }

    private void treatGameEvent()
    {
        LOGGER.info("----------------------- Starting persistence from GameEventDTO -----------------------");
        LOGGER.info(".....\tcaching existing data");
        gameEventService.loadExisting();
        LOGGER.info(".....\tinserting");
        AtomicInteger count = new AtomicInteger();
        runInTransaction(() ->
        {
            for (GameEventDTO dto : gameEventDTOList)
            {
                Player playerMain = playerService.findForGameEvent(dto);
                Game game = gameService.findForGameEvent(dto);

                if (playerMain != null && game != null)
                {
                    GameEvent gameEvent = gameEventService.findOrCreate(dto, playerService);
                    gameEvent.setGame(game);
                    gameEvent.setPlayerMain(playerMain);
                    em.persist(gameEvent);
                }
                count.getAndIncrement();
            }
        }, em);
        LOGGER.info("Finished persistence of {} gameLineUps", count);
        LOGGER.info(".....\tclearing cache");
        gameEventService.clear();
        em.clear();
    }

    private void treatClubDTO()
    {
        LOGGER.info("----------------------- Starting persistence from ClubDTO -----------------------");
        LOGGER.info(".....\tcaching existing data");
        clubService.loadExistingClubs();
        stadiumService.loadExistingStadiums();
        urlService.loadExistingClubUrls();
        competitionService.loadAndGroupCompetitionsbyDomesticId();
        countryService.loadCountriesByCompetitions();
        AtomicInteger count = new AtomicInteger();
        LOGGER.info(".....\tinserting");
        runInTransaction(() ->
        {
            for (ClubDTO dto : clubDTOList)
            {
                Club club = clubService.findOrCreateClubFromClubDTO(dto);
                Stadium stadium = stadiumService.findOrCreateStadiumFromClubDTO(dto);
                Url url = urlService.findOrCreateUrlFromClubDTO(dto);
                club.setUrl(url);
                List<Competition> competitionList = competitionService.findFromClubDTO(dto);
                if (club.getCompetitions().isEmpty())
                {
                    club.getCompetitions().addAll(competitionList);
                }
                Country country = countryService.findFromClubDTO(dto);
                if (country != null)
                {
                    club.setCountry(country);
                }
                club.setHomeStadium(stadium);
                em.persist(club);
                count.getAndIncrement();
            }
        }, em);
        LOGGER.info("Finished persistence of {} competitions", count);
        em.clear();
    }

    private void treatCompetitionDTO()
    {
        LOGGER.info("----------------------- Starting persistence from CompetitionDTO -----------------------");
        LOGGER.info(".....\tcaching existing data");
        competitionService.loadExistingCompetitions();
        countryService.loadExistingCountries();
        urlService.loadExistingCompetitionUrls();
        LOGGER.info(".....\tinserting");
        AtomicInteger count = new AtomicInteger();
        runInTransaction(() ->
        {
            for (CompetitionDTO dto : competitionDTOList)
            {
                Competition competition = competitionService.findOrCreateCompetitionFromCompetitionDTO(dto);
                Country country = countryService.findOrCreateCompetitionCountry(dto);
                competition.setCountry(country);
                Url url = urlService.findOrCreateCompetitionUrl(dto);
                competition.setUrl(url);
                em.persist(competition);
                count.getAndIncrement();
            }
        }, em);
        LOGGER.info("Finished persistence of {} competitions", count);
        LOGGER.info(".....\tclearing cache");
        countryService.clearCache();
        competitionService.clearCache();
        urlService.clearCache();
        em.clear();
    }

    private void treatPlayerDTO()
    {
        LOGGER.info("----------------------- Starting persistence from PlayerDTO -----------------------");
        LOGGER.info(".....\tcaching existing data");
        playerService.loadExistingPlayers();
        clubService.loadExistingClubs();
        countryService.loadExistingCountries();
        urlService.loadExistingPlayerUrls();
        LOGGER.info(".....\tinserting");
        AtomicInteger count = new AtomicInteger();
        runInTransaction(() ->
        {
            for (PlayerDTO dto : playerDTOList)
            {

                Club club = clubService.findOrCreateClub(dto);
                Country countryBirth = countryService.findOrCreateCountry(dto, true);
                Country countryCitizenship = countryService.findOrCreateCountry(dto, false);

                Url url = urlService.findOrCreateUrl(dto, false);
                Url imgUrl = urlService.findOrCreateUrl(dto, true);
                Player player = playerService.findOrCreatePlayer(dto);
                player.setCurrentClub(club);
                player.setDataUrl(url);
                player.setPictureUrl(imgUrl);
                player.setCountryOfBirth(countryBirth);
                player.setCountryOfCitizenship(countryCitizenship);
                em.persist(player);
                count.getAndIncrement();
            }
        }, em);
        em.clear();
        LOGGER.info("Finished persistence of {} players", count);
        LOGGER.info(".....\tclearing cache");

        playerService.clearCache();
        clubService.clearCache();
        countryService.clearCache();
        urlService.clearCache();
    }

    private void treatGameDTO()
    {
        LOGGER.info("----------------------- Starting persistence from GameDTO -----------------------");
        LOGGER.info(".....\tcaching existing data");
        gameService.loadExistingGames();
        clubService.loadExistingClubs();
        stadiumService.loadExistingStadiums();
        competitionService.loadExistingCompetitions();
        competitionRoundService.loadExistingCompetitionrounds();
        clubGameService.loadExistingClubGames();
        LOGGER.info(".....\tinserting");
        AtomicInteger count = new AtomicInteger();
        runInTransaction(() ->
        {
            for (GameDTO dto : gameDTOList)
            {
                Game game = gameService.findOrCreateGame(dto);
                Stadium stadium = stadiumService.findOrCreateStadium(dto);
                CompetitionRound round = competitionRoundService.findOrCreateCompetitionRound(dto);
                Competition competition = competitionService.findOrCreateCompetition(dto);
                Club clubHome = clubService.findOrCreateClubFromGame(dto, true);
                Club clubAway = clubService.findOrCreateClubFromGame(dto, false);
                game.setStadium(stadium);
                game.setRound(round);
                competition.getRounds().add(round);
                em.persist(competition);
                round.setCompetition(competition);
                em.persist(game);
                em.persist(clubAway);
                em.persist(clubHome);
                ClubGame clubGameHome = clubGameService.findOrCreateClubGame(dto, true, clubHome, game);
                ClubGame clubGameAway = clubGameService.findOrCreateClubGame(dto, false, clubAway, game);
                game.getClubGames().add(clubGameHome);
                game.getClubGames().add(clubGameAway);
                em.persist(clubGameAway);
                em.persist(clubGameHome);
                em.persist(game);
                count.getAndIncrement();
            }
        }, em);
        LOGGER.info("Finished persistence of {} gameDTO lines", count);
        LOGGER.info(".....\tclearing cache");
        competitionRoundService.clearCache();
        stadiumService.clearCache();
        competitionService.clearCache();
        clubService.clearCache();
        gameService.clearCache();
        clubGameService.clearCache();
        em.clear();
    }

    /**
     *
     */
    private void initializeDtoLists()
    {
        LOGGER.info("Parsing competition.csv");
        this.competitionDTOList = dtoListCreator.createListOfCompetitionDTO("data/1.competitions.csv");

        LOGGER.info("Parsing club.csv");
        this.clubDTOList = dtoListCreator.createListOfClubDTO("data/2.clubs.csv");

        LOGGER.info("Parsing players.csv");
        this.playerDTOList = dtoListCreator.createListOfPlayerDTO("data/3.players.csv");

//        LOGGER.info("Parsing player_valuations.csv");
//        this.playerValuationList = dtoListCreator.createListOfPlayerValuation("data/4.player_valuations.csv");

        LOGGER.info("Parsing games.csv");
        this.gameDTOList = dtoListCreator.createListOfGameDTO("data/5.games.csv");

        LOGGER.info("Parsing game_events.csv");
        this.gameEventDTOList = dtoListCreator.createListOfGameEventDTO("data/6.game_events.csv");

        LOGGER.info("Parsing game_lineups.csv");
        this.gameLineupDTOList = dtoListCreator.createListOfGameLineupDTO("data/7.game_lineups.csv");

        LOGGER.info("Parsing appearances.csv");
        this.appearanceDTOList = dtoListCreator.createListOfAppearanceDTO("data/8.appearances.csv");
    }

    /**
     *
     */
    private void limitListSize()
    {
        int size = 1000;
        competitionDTOList = competitionDTOList.stream().limit(size).toList();
        clubDTOList = clubDTOList.stream().limit(size).toList();
        playerDTOList = playerDTOList.stream().limit(size).toList();
        //playerValuationList = playerValuationList.stream().limit(1000).toList();
        gameDTOList = gameDTOList.stream().limit(size).toList();
        gameEventDTOList = gameEventDTOList.stream().limit(size).toList();
        gameLineupDTOList = gameLineupDTOList.stream().limit(size).toList();
        appearanceDTOList = appearanceDTOList.stream().limit(size).toList();
    }

    /**
     * @param action
     * @param em
     */
    private void runInTransaction(Runnable action, EntityManager em)
    {
        EntityTransaction transaction = em.getTransaction();
        try
        {
            if (!transaction.isActive()) transaction.begin();
            action.run();
            transaction.commit();
            System.out.println("Transaction commited successfully");
        } catch (Exception e)
        {
            if (transaction.isActive()) transaction.rollback();
            LOGGER.error("Transaction Error : {}", e.getMessage());
        }
    }

}