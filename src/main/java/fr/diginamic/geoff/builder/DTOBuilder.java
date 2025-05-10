package fr.diginamic.geoff.builder;

import fr.diginamic.geoff.dto.CompetitionDTO;
import fr.diginamic.geoff.exception.CsvFormatException;

import java.util.List;

public interface DTOBuilder<T>
{

    /**
     * @param lines
     * @return
     */
    default List<T> buildDTOList(List<String> lines)
    {
        lines.removeFirst();
        return lines.stream()
                .map(l ->
                {
                    T entityDTO = createInstance();
                    setAttributes(entityDTO, l);
                    return entityDTO;
                })
                .toList();
    }

    ;

    /**
     * @param entity
     * @param line
     * @throws CsvFormatException
     */
    void setAttributes(T entity, String line) throws CsvFormatException;

    /**
     * @return
     */
    T createInstance();
}