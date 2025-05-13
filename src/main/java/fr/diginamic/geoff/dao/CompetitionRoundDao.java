package fr.diginamic.geoff.dao;

/**
 * Handles DB requests for this entity
 */
public class CompetitionRoundDao
{
//    private final EntityManager em;
//
//    public CompetitionRoundDao(EntityManager em)
//    {
//        this.em = em;
//    }
//
//    public void save(CompetitionRound competitionRound) {em.persist(competitionRound);}
//
//    public Optional<CompetitionRound> findByRound(String round)
//    {
//        if (round == null)
//        {
//            return Optional.empty();
//        }
//
//        TypedQuery<CompetitionRound> query = em.createQuery(
//                "SELECT cr FROM CompetitionRound cr WHERE cr.round = :round", CompetitionRound.class);
//        query.setParameter("round", round);
//
//        List<CompetitionRound> list = query.getResultList();
//        if (!list.isEmpty())
//        {
//            return Optional.of(list.getFirst());
//        }
//        return Optional.empty();
//    }
//
//    public List<CompetitionRound> findAll()
//    {
//        TypedQuery<CompetitionRound> query = em.createQuery("SELECT cr FROM CompetitionRound  cr", CompetitionRound.class);
//        return query.getResultList();
//    }
}