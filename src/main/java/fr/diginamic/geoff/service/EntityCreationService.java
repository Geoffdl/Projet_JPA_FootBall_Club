package fr.diginamic.geoff.service;

import fr.diginamic.geoff.dao.*;
import fr.diginamic.geoff.dto.*;
import fr.diginamic.geoff.entity.*;
import fr.diginamic.geoff.service.entity.*;
import fr.diginamic.geoff.utils.DTOListCreator;
import fr.diginamic.geoff.utils.JpaEntityFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class EntityCreationService
{

    private static final Logger LOGGER = LoggerFactory.getLogger(EntityCreationService.class);

    private final EntityManager em;
    // data initializer
    private final DTOListCreator dtoListCreator;
    //services
    private final AgentService agentService;
    private final PlayerService playerService;
    private final CityService cityService;
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
        AgentDao agentDao = new AgentDao(em);
        PlayerDao playerDao = new PlayerDao(em);
        CityDao cityDao = new CityDao(em);
        CountryDao countryDao = new CountryDao(em);
        UrlDao urlDao = new UrlDao(em);
        ClubDao clubDao = new ClubDao(em);
        ClubGameDao clubGameDao = new ClubGameDao(em);
        CompetitionDao competitionDao = new CompetitionDao(em);
        CompetitionRoundDao competitionRoundDao = new CompetitionRoundDao(em);
        GameDao gameDao = new GameDao(em);
        GameAppearanceDao gameAppearanceDao = new GameAppearanceDao(em);
        GameEventDao gameEventDao = new GameEventDao(em);
        GameLineupDao gameLineupDao = new GameLineupDao(em);
        StadiumDao stadiumDao = new StadiumDao(em);
        PlayerValuationDao playerValuationDao = new PlayerValuationDao(em);

        JpaEntityFactory factory = new JpaEntityFactory();
        this.cityService = new CityService(cityDao, factory);
        this.countryService = new CountryService(countryDao, factory);
        this.urlService = new UrlService(urlDao, factory);
        this.clubService = new ClubService(clubDao, factory);
        this.clubGameService = new ClubGameService(clubGameDao, factory);
        this.agentService = new AgentService(agentDao, factory);
        this.playerService = new PlayerService(playerDao, factory);
        this.competitionService = new CompetitionService(competitionDao, factory);
        this.competitionRoundService = new CompetitionRoundService(competitionRoundDao, factory);
        this.gameService = new GameService(gameDao, factory);
        this.gameAppearanceService = new GameAppearanceService(gameAppearanceDao, factory);
        this.gameLineUpService = new GameLineupService(gameLineupDao, factory);
        this.gameEventService = new GameEventService(gameEventDao, factory);
        this.stadiumService = new StadiumService(stadiumDao, factory);
        this.playerValuationService = new PlayerValuationService(playerValuationDao, factory);
    }

    public void createEntities()
    {
        // get data from dump
        initializeDtoLists();

        //for testing purposes
        limitListSize();

        //creating sequence
        treatPlayerDTO();
        treatGameDTO();
        treatCompetitionDTO();
        treatClubDTO();
        treatGameEvent();

    }

    private void treatGameEvent() {}

    private void treatClubDTO()
    {
        for (ClubDTO dto : clubDTOList)
        {
            runInTransaction(() ->
            {
                Club club = clubService.findOrCreateClubFromClubDTO(dto);
                Stadium stadium = stadiumService.findOrCreateStadiumFromClubDTO(dto);
                Url url = urlService.findOrCreateUrlFromClubDTO(dto);

                club.setUrl(url);

                //not enough data to create here
                List<Competition> competitionList = competitionService.findFromClubDTO(dto);
                for (Competition competition : competitionList)
                {
                    club.getCompetitions().add(competition);

                }
                Country country = countryService.findFromClubDTO(dto);
                if (country != null)
                {
                    club.setCountry(country);
                }
                club.setHomeStadium(stadium);
                em.persist(club);
            }, em);
        }
        em.clear();
    }

    private void treatCompetitionDTO()
    {
        for (CompetitionDTO dto : competitionDTOList)
        {
            runInTransaction(() ->
            {
                Competition competition = competitionService.findOrCreateCompetitionFromCompetitionDTO(dto);
                if (dto.getCountryId() != -1)
                {
                    Country country = countryService.findOrCreateCompetitionCountry(dto);
                    competition.setCountry(country);
                }

                Url url = urlService.findOrCreateCompetitionUrl(dto);

                competition.setUrl(url);

                em.persist(competition);

            }, em);
        }
        em.clear();
    }


    private void treatPlayerDTO()
    {
        for (PlayerDTO dto : playerDTOList)
        {
            runInTransaction(() ->
            {
                City city = cityService.findOrCreateCity(dto);
                Country countryBirth = countryService.findOrCreateBirthCountry(dto);
                Country countryCitizenship = countryService.findOrCreateCitizenshipCountry(dto);
                Url url = urlService.findOrCreateUrl(dto, false);
                Url imgUrl = urlService.findOrCreateUrl(dto, true);
                Club club = clubService.findOrCreateClub(dto);
                Agent agent = agentService.findOrCreateAgent(dto);
                Player player = playerService.findOrCreatePlayer(dto);

                player.setAgent(agent);
                player.setCurrentClub(club);
                player.setDataUrl(url);
                player.setPictureUrl(imgUrl);
                player.setCityOfBirth(city);
                player.setCountryOfBirth(countryBirth);
                player.setCountryOfCitizenship(countryCitizenship);
                em.persist(player);

            }, em);

        }
        em.clear();
    }

    private void treatGameDTO()
    {

        for (GameDTO dto : gameDTOList)
        {
            runInTransaction(() ->
            {
                Game game = gameService.findOrCreateGame(dto);
                Stadium stadium = stadiumService.findOrCreateStadium(dto);
                CompetitionRound round = competitionRoundService.findOrCreateCompetitionRound(dto);
                Competition competition = competitionService.findOrCreateCompetition(dto);
                Club clubHome = clubService.findOrCreateClubFromHomeGame(dto, true);
                Club clubAway = clubService.findOrCreateClubFromHomeGame(dto, false);


                game.setStadium(stadium);
                game.setRound(round);
                competition.getRounds().add(round);

                em.persist(competition);

                round.setCompetition(competition);

                em.persist(game);
                em.persist(clubAway);
                em.persist(clubHome);

                ClubGame clubGameHome = clubGameService.findOrCreateClubGame(dto, true, clubService, game);
                ClubGame clubGameAway = clubGameService.findOrCreateClubGame(dto, false, clubService, game);
                game.getClubGames().add(clubGameHome);
                game.getClubGames().add(clubGameAway);
                em.persist(clubGameAway);
                em.persist(clubGameHome);
                em.persist(game);

            }, em);

        }

        em.clear();
    }


    /**
     *
     */
    private void initializeDtoLists()
    {
        this.competitionDTOList = dtoListCreator.createListOfCompetitionDTO("data/1.competitions.csv");
        this.clubDTOList = dtoListCreator.createListOfClubDTO("data/2.clubs.csv");
        this.playerDTOList = dtoListCreator.createListOfPlayerDTO("data/3.players.csv");
//        this.playerValuationList = dtoListCreator.createListOfPlayerValuation("data/4.player_valuations.csv");
        this.gameDTOList = dtoListCreator.createListOfGameDTO("data/5.games.csv");
//        this.gameEventDTOList = dtoListCreator.createListOfGameEventDTO("data/6.game_events.csv");
//        this.gameLineupDTOList = dtoListCreator.createListOfGameLineupDTO("data/7.game_lineups.csv");
//        this.appearanceDTOList = dtoListCreator.createListOfAppearanceDTO("data/8.appearances.csv");
    }

    /**
     *
     */
    private void limitListSize()
    {
        int size = 300;

        competitionDTOList = competitionDTOList.stream().limit(size).toList();
        clubDTOList = clubDTOList.stream().limit(size).toList();
        playerDTOList = playerDTOList.stream().limit(size).toList();
//        playerValuationList = playerValuationList.stream().limit(1000).toList();
        gameDTOList = gameDTOList.stream().limit(size).toList();
//        gameEventDTOList = gameEventDTOList.stream().limit(1000).toList();
//        gameLineupDTOList = gameLineupDTOList.stream().limit(1000).toList();
//        appearanceDTOList = appearanceDTOList.stream().limit(1000).toList();
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