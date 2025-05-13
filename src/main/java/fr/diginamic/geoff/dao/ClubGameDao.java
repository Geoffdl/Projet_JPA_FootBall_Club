package fr.diginamic.geoff.dao;

import fr.diginamic.geoff.entity.ClubGame;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

/**
 * Handles DB requests for this entity
 */
public class ClubGameDao
{
    private final EntityManager em;

    public ClubGameDao(EntityManager em)
    {
        this.em = em;
    }

    public void save(ClubGame clubGame)
    {
        em.persist(clubGame);
    }

    public Optional<ClubGame> findByGameIdAndClubId(Long gameId, Long clubId)
    {
        TypedQuery<ClubGame> query = em.createQuery("SELECT cg FROM ClubGame cg WHERE cg.game.id = :gameId AND cg.club.id = :clubId", ClubGame.class
        );
        query.setParameter("gameId", gameId);
        query.setParameter("clubId", clubId);

        try
        {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e)
        {
            return Optional.empty();
        }
    }

    public List<ClubGame> findAll()
    {
        TypedQuery<ClubGame> query = em.createQuery("SELECT cg FROM ClubGame cg", ClubGame.class);
        return query.getResultList();
    }
}