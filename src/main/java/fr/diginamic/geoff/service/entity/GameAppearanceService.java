package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.GameAppearanceDao;
import fr.diginamic.geoff.dto.AppearanceDTO;
import fr.diginamic.geoff.entity.Game;
import fr.diginamic.geoff.entity.GameAppearance;
import fr.diginamic.geoff.entity.Player;
import fr.diginamic.geoff.utils.JpaEntityFactory;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class GameAppearanceService
{
    private final GameAppearanceDao gameAppearanceDao;

    public GameAppearanceService(EntityManager em)
    {
        this.gameAppearanceDao = new GameAppearanceDao(em);

    }

    public GameAppearance findOrCreate(AppearanceDTO dto, Game game, Player player)
    {
        Optional<GameAppearance> gameAppearanceOptional = gameAppearanceDao.findBySourceId(dto.getAppearanceId());
        if (gameAppearanceOptional.isPresent())
        {
            return gameAppearanceOptional.get();
        }
        GameAppearance gameAppearance = JpaEntityFactory.createGameAppearance(dto, game, player);

        return gameAppearance;
    }
}