package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.GameAppearanceDao;
import fr.diginamic.geoff.dto.AppearanceDTO;
import fr.diginamic.geoff.entity.Game;
import fr.diginamic.geoff.entity.GameAppearance;
import fr.diginamic.geoff.entity.Player;
import fr.diginamic.geoff.utils.JpaEntityFactory;

import java.util.Optional;

public class GameAppearanceService
{
    private final GameAppearanceDao gameAppearanceDao;
    private final JpaEntityFactory factory;


    public GameAppearanceService(GameAppearanceDao gameAppearanceDao, JpaEntityFactory factory)
    {
        this.gameAppearanceDao = gameAppearanceDao;
        this.factory = factory;
    }

    public GameAppearance findOrCreate(AppearanceDTO dto, Game game, Player player)
    {
        Optional<GameAppearance> gameAppearanceOptional = gameAppearanceDao.findBySourceId(dto.getAppearanceId());
        if (gameAppearanceOptional.isPresent())
        {
            return gameAppearanceOptional.get();
        }
        GameAppearance gameAppearance = factory.createGameAppearance(dto, game, player);

        return gameAppearance;
    }
}