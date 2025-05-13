package fr.diginamic.geoff.dao;

import fr.diginamic.geoff.entity.GameEvent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

/**
 * Handles DB requests for this entity
 */
public class GameEventDao
{
    private final EntityManager em;

    public GameEventDao(EntityManager em)
    {
        this.em = em;
    }

    public Optional<GameEvent> findByGameIdAndPlayerId(Long gameId, Long playerId)
    {
        TypedQuery<GameEvent> query = em.createQuery(
                "SELECT ge FROM GameEvent ge WHERE ge.game.id = :gameId AND ge.playerMain.id = :playerId", GameEvent.class
        );
        query.setParameter("gameId", gameId);
        query.setParameter("playerId", playerId);
        try
        {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e)
        {
            return Optional.empty();
        }
    }

    public Optional<GameEvent> findBySourceId(String gameEventId)
    {
        TypedQuery<GameEvent> query = em.createQuery(
                "SELECT ge FROM GameEvent ge WHERE ge.sourceId = :gameEventId", GameEvent.class
        );
        query.setParameter("gameEventId", gameEventId);
        try
        {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e)
        {
            return Optional.empty();
        }
    }

    public void save(GameEvent gameEvent) {em.persist(gameEvent);}

    public List<GameEvent> findAll()
    {
        TypedQuery<GameEvent> query = em.createQuery("SELECT ge FROM GameEvent ge", GameEvent.class);
        return query.getResultList();
    }
}