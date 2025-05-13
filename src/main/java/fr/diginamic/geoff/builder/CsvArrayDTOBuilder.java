package fr.diginamic.geoff.builder;

import fr.diginamic.geoff.exception.CsvFormatException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * OpenCsv implementation
 *
 * @param <T>
 */
public interface CsvArrayDTOBuilder<T> extends DTOBuilder<T>
{
    /**
     * Sets the DTO entity attributes for each line of the CSV file
     *
     * @param entity current entity
     * @param parts  line elements
     * @throws CsvFormatException exception if the line output isn't matching expectations
     */
    void setAttributes(T entity, String[] parts) throws CsvFormatException;

    /**
     * creates a list out of the newly create dto
     *
     * @param rows lines of the csv
     * @return list of dto
     */
    default List<T> buildDTOListFromArray(List<String[]> rows)
    {
        if (rows == null) return List.of();

        return rows.stream().skip(1) // Skip header
                .map(parts ->
                {
                    T dto = createInstance();
                    try
                    {
                        setAttributes(dto, parts);
                        return dto;
                    } catch (CsvFormatException e)
                    {
                        LOGGER.debug("Skipping malformed line {}: {}", Arrays.toString(parts), e.getMessage());
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .toList();
    }
}