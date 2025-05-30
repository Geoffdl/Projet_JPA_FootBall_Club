package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.ClubGameDao;
import fr.diginamic.geoff.dto.GameDTO;
import fr.diginamic.geoff.entity.Club;
import fr.diginamic.geoff.entity.ClubGame;
import fr.diginamic.geoff.entity.Game;
import fr.diginamic.geoff.entity.compositeid.ClubGameId;
import fr.diginamic.geoff.utils.JpaEntityFactory;
import jakarta.persistence.EntityManager;

import java.util.HashMap;
import java.util.Map;

/**
 * This class orchestrates dao and mappers to generate entities and persist them in the database
 * It implements a caching method using a sourceId from the data and an instance of the object, either created or fetched from the database if existing
 */
public class ClubGameService
{
    private final ClubGameDao clubGameDao;
    private final Map<ClubGameId, ClubGame> mapOfExistingClubGames = new HashMap<>();

    public ClubGameService(EntityManager em)
    {
        this.clubGameDao = new ClubGameDao(em);
    }

    /**
     * Takes an instance of DTO, compares it to existing entity, if present in base return existing, if not create a new one from the DTO
     *
     * @param dto raw source entity
     * @return jpa entity
     */
    public ClubGame findOrCreateClubGame(GameDTO dto, boolean isHome, Club club, Game game)
    {
        ClubGameId idFromSource = new ClubGameId(club.getClubId(), game.getGameId());
        ClubGame existing = mapOfExistingClubGames.get(idFromSource);
        if (existing != null)
        {
            return existing;
        }
        ClubGame clubGame = JpaEntityFactory.createClubGame(dto, isHome, club, game);
        clubGame.setClub(club);
        clubGameDao.save(clubGame);
        mapOfExistingClubGames.put(clubGame.getClubGameId(), clubGame);
        return clubGame;
    }

    /**
     * loads caching hashmap
     */
    public void loadExistingClubGames()
    {
        for (ClubGame clubGame : clubGameDao.findAll())
        {
            mapOfExistingClubGames.put(clubGame.getClubGameId(), clubGame);
        }
    }

    /**
     * clears cache
     */
    public void clearCache() {mapOfExistingClubGames.clear();}
}