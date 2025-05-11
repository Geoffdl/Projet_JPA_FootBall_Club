package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.ClubGameDao;
import fr.diginamic.geoff.dto.GameDTO;
import fr.diginamic.geoff.entity.Club;
import fr.diginamic.geoff.entity.ClubGame;
import fr.diginamic.geoff.entity.Game;
import fr.diginamic.geoff.utils.JpaEntityFactory;

import java.util.Optional;

public class ClubGameService
{
    private final ClubGameDao clubGameDao;
    private final JpaEntityFactory factory;


    public ClubGameService(ClubGameDao clubGameDao, JpaEntityFactory factory)
    {
        this.clubGameDao = clubGameDao;
        this.factory = factory;
    }

    public ClubGame findOrCreateClubGame(GameDTO dto, boolean isHome, ClubService clubService, Game game)
    {
        Long gameId = dto.getGameId();
        Long clubId = dto.getAwayClubId();
        if (isHome)
        {
            clubId = dto.getHomeClubId();
        }

        Optional<ClubGame> clubGameOptional = clubGameDao.findByGameIdAndClubId(gameId, clubId);
        if (clubGameOptional.isPresent())
        {
            return clubGameOptional.get();
        }
        Club club = clubService.findOrCreateClubFromHomeGame(dto, isHome);
        ClubGame clubGame = factory.createClubGame(dto, isHome, club, game);
        clubGame.setClub(club);
        clubGameDao.save(clubGame);

        return clubGame;

    }

}