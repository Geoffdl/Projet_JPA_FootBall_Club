package fr.diginamic.geoff.builder;

import fr.diginamic.geoff.exception.CsvFormatException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public interface CsvArrayDTOBuilder<T> extends DTOBuilder<T>
{
    void setAttributes(T entity, String[] parts) throws CsvFormatException;

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