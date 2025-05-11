package fr.diginamic.geoff.service;

import fr.diginamic.geoff.Main;
import fr.diginamic.geoff.builder.GameDTOBuilder;
import fr.diginamic.geoff.dao.*;
import fr.diginamic.geoff.dto.*;
import fr.diginamic.geoff.entity.*;
import fr.diginamic.geoff.utils.JpaEntityFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class EntityCreationService
{

    private static final Logger LOGGER = LoggerFactory.getLogger(EntityCreationService.class);

    private final EntityManager em;
    private final DTOCreationService dtoCreationService;
    private final AgentService agentService;
    private final PlayerService playerService;
    private final CityService cityService;
    private final CountryService countryService;
    private final UrlService urlService;
    private final ClubService clubService;
    private List<PlayerDTO> playerDTOList;
    private List<GameDTO> gameDTOList;
    //other services..


    public EntityCreationService(EntityManager em, DTOCreationService dtoCreationService)
    {
        this.em = em;
        this.dtoCreationService = dtoCreationService;
        AgentDao agentDao = new AgentDao(em);
        PlayerDao playerDao = new PlayerDao(em);
        CityDao cityDao = new CityDao(em);
        CountryDao countryDao = new CountryDao(em);
        UrlDao urlDao = new UrlDao(em);
        ClubDao clubDao = new ClubDao(em);
        JpaEntityFactory factory = new JpaEntityFactory();
        this.cityService = new CityService(cityDao, factory);
        this.countryService = new CountryService(countryDao, factory);
        this.urlService = new UrlService(urlDao, factory);
        this.clubService = new ClubService(clubDao, factory);
        this.agentService = new AgentService(agentDao, factory);
        this.playerService = new PlayerService(playerDao, agentDao, factory, em, agentService);
    }

    public void createEntities()
    {
        // get data from dump
        initializeDtoLists();

        for (PlayerDTO dto : playerDTOList)
        {
            runInTransaction(() ->
            {
                City city = cityService.findOrCreateCity(dto);
                Country countryBirth = countryService.findOrCreateBirthCountry(dto);
                Country countryCitizenship = countryService.findOrCreateCitizenshipCountry(dto);
                Url url = urlService.findOrCreateUrl(dto);
                Url imgUrl = urlService.findOrCreateImageUrl(dto);
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

    }


    private List<Agent> createAgentList(List<PlayerDTO> playerDTOList)
    {

        List<Agent> agentList = new ArrayList<>();
        Agent foundOrNewAgent = null;
        for (PlayerDTO playerDTO : playerDTOList)
        {
            foundOrNewAgent = agentService.findOrCreateAgent(playerDTO);
            agentList.add(foundOrNewAgent);
        }
        return agentList;
    }

    private List<Player> createPlayerList(List<PlayerDTO> playerDTOList)
    {
        List<Player> playerList = new ArrayList<>();
        Player foundOrNewPlayer = null;
        for (PlayerDTO playerDTO : playerDTOList)
        {
            foundOrNewPlayer = playerService.findOrCreatePlayer(playerDTO);
            playerList.add(foundOrNewPlayer);
        }
        return playerList;
    }


    private void executeInsideTransaction(Consumer<EntityManager> action)
    {
        EntityTransaction tx = em.getTransaction();
        try
        {
            tx.begin();
            action.accept(em);
            tx.commit();
        } catch (RuntimeException e)
        {
            tx.rollback();
            throw e;
        }
    }

    private void initializeDtoLists()
    {
//        this.competitionDTOList = dtoCreationService.createListOfCompetitionDTO("data/1.competitions.csv");
//        this.clubDTOList = dtoCreationService.createListOfClubDTO("data/2.clubs.csv");
        this.playerDTOList = dtoCreationService.createListOfPlayerDTO("data/3.players.csv");
//        this.playerValuationList = dtoCreationService.createListOfPlayerValuation("data/4.player_valuations.csv");
        this.gameDTOList = dtoCreationService.createListOfGameDTO("data/5.games.csv");
//        this.gameEventDTOList = dtoCreationService.createListOfGameEventDTO("data/6.game_events.csv");
//        this.gameLineupDTOList = dtoCreationService.createListOfGameLineupDTO("data/7.game_lineups.csv");
//        this.appearanceDTOList = dtoCreationService.createListOfAppearanceDTO("data/8.appearances.csv");
    }

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