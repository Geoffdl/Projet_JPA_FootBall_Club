package fr.diginamic.geoff.mapper;

import fr.diginamic.geoff.dto.AppearanceDTO;
import fr.diginamic.geoff.entity.Game;
import fr.diginamic.geoff.entity.GameAppearance;
import fr.diginamic.geoff.entity.Player;
import fr.diginamic.geoff.entity.compositeid.GamePlayerId;

public class AppearanceDTOMapper
{
    private final AppearanceDTO dto;

    public AppearanceDTOMapper(AppearanceDTO dto)
    {
        this.dto = dto;
    }

    public GameAppearance mapToGameAppearance(GameAppearance gameAppearance, Game game, Player player)
    {
        //actual composite id
        GamePlayerId id = new GamePlayerId(game.getGameId(), player.getPlayerId());
        gameAppearance.setGameAppearanceId(id);

        //sourceId
        gameAppearance.setSourceId(dto.getAppearanceId());

        gameAppearance.setYellowCards(dto.getYellowCard());
        gameAppearance.setRedCards(dto.getRedCard());
        gameAppearance.setGoals(dto.getGoals());
        gameAppearance.setAssists(dto.getAssists());
        gameAppearance.setMinutesPlayed(dto.getMinutesPlayed());

        gameAppearance.setGame(game);
        gameAppearance.setPlayer(player);

        return gameAppearance;
    }
}