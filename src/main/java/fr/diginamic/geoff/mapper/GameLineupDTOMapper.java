package fr.diginamic.geoff.mapper;

import fr.diginamic.geoff.dto.GameLineupDTO;
import fr.diginamic.geoff.entity.Game;
import fr.diginamic.geoff.entity.GameLineup;
import fr.diginamic.geoff.entity.Player;
import fr.diginamic.geoff.entity.compositeid.GamePlayerId;
import fr.diginamic.geoff.entity.lookup.Lineup;
import fr.diginamic.geoff.entity.lookup.Position;

/**
 * Sets base attributes to new JPA entities from source dto
 */
public class GameLineupDTOMapper
{
    private final GameLineupDTO dto;

    public GameLineupDTOMapper(GameLineupDTO dto)
    {
        this.dto = dto;
    }

    public GameLineup mapToGameLineup(GameLineup gameLineup, Game game, Player player)
    {

        //actual composite id
        GamePlayerId id = new GamePlayerId(game.getGameId(), player.getPlayerId());
        gameLineup.setGameLineupId(id);

        //sourceId
        gameLineup.setSourceId(dto.getGameLineUpsId());

        gameLineup.setStartingLineup(Lineup.fromCsvValue(dto.getType()));
        gameLineup.setPosition(Position.fromCsvValue(dto.getPosition()));
        gameLineup.setTeamCaptain(dto.isTeamCaptain());
        gameLineup.setPlayerNumber(dto.getNumber());

        gameLineup.setGame(game);
        gameLineup.setPlayer(player);

        return gameLineup;
    }
}