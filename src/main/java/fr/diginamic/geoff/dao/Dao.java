package fr.diginamic.geoff.dao;

import java.util.List;

/**
 * generic interface for db interactions
 *
 * @param <T>
 */
public interface Dao<T>
{
    /**
     * @return a list of all elements
     */
    List<T> findAll();

    /**
     * calls persist in the database
     *
     * @param entity type
     */
    void save(T entity);

    /**
     * find by criteria
     *
     * @param id long sourceId
     * @return all elements matching
     */
    List<T> findAllById(Long id);

    /**
     * find by criteria
     *
     * @param id string sourceId
     * @return all elements matching
     */
    List<T> findAllByIdString(String id);
}