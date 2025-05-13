package fr.diginamic.geoff.builder;

import fr.diginamic.geoff.exception.CsvFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public interface DTOBuilder<T>
{
    static final Logger LOGGER = LoggerFactory.getLogger(DTOBuilder.class);

    /**
     * creates a list of dto entitys
     *
     * @param lines
     * @return
     */
    default List<T> buildDTOList(List<String> lines)
    {
        if (lines == null)
        {
            return List.of();
        }

        return lines.stream().skip(1)
                .map(l ->
                {

                    T entityDTO = createInstance();
                    try
                    {
                        setAttributes(entityDTO, l);
                        return entityDTO;
                    } catch (CsvFormatException e)
                    {
                        LOGGER.debug("skipping line {} : {}", l, e.getMessage());
                        return null;
                    }
                })
                .toList();
    }


    /**
     * creates DTO entities from each csv line
     *
     * @param entity current entity
     * @param line   csv line
     * @throws CsvFormatException in case the line doesn't match expectations
     */
    void setAttributes(T entity, String line) throws CsvFormatException;

    /**
     * instantiate empty dto entity
     *
     * @return
     */
    T createInstance();
}