package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.CountryDao;
import fr.diginamic.geoff.dto.ClubDTO;
import fr.diginamic.geoff.dto.CompetitionDTO;
import fr.diginamic.geoff.dto.PlayerDTO;
import fr.diginamic.geoff.entity.Competition;
import fr.diginamic.geoff.entity.Country;
import fr.diginamic.geoff.utils.JpaEntityFactory;
import jakarta.persistence.EntityManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * This class orchestrates daos and mappers to generate entities and persist them in the database
 * It implements a caching method using a sourceId from the data and an instance of the object, either created or fetched from the database if existing
 */
public class CountryService
{
    private final CountryDao countryDao;
    private final Map<String, Country> mapOfExistingCountries = new HashMap<>();
    private final Map<String, Country> mapOfExistingCountriesByDomesticId = new HashMap<>();

    public CountryService(EntityManager em)
    {
        this.countryDao = new CountryDao(em);

    }


    public Country findOrCreateCompetitionCountry(CompetitionDTO dto)
    {
        String sourceName = dto.getCountryName();
        Country existing = mapOfExistingCountries.get(sourceName);
        if (existing != null)
        {
            if (dto.getCountryId() != -1 && !Objects.equals(existing.getCountryId(), dto.getCountryId()))
            {
                existing.setSourceId(dto.getCountryId());
                countryDao.save(existing);
            }
            return existing;
        }

        Country country = JpaEntityFactory.createCountryFromCompetition(dto);
        countryDao.save(country);
        mapOfExistingCountries.put(sourceName, country);
        return country;
    }

    public Country findFromClubDTO(ClubDTO dto)
    {
        String sourceId = dto.getDomesticCompetitionId();
        return mapOfExistingCountriesByDomesticId.get(sourceId);

    }


    public Country findOrCreateCountry(PlayerDTO dto, boolean isBirth)
    {
        String sourceName = null;
        if (isBirth)
        {
            sourceName = dto.getCountryOfBirth();
        } else
        {
            sourceName = dto.getCountryOfCitizenship();
        }
        Country existing = mapOfExistingCountries.get(sourceName);
        if (existing != null)
        {
            return existing;
        }
        Country country = JpaEntityFactory.createCountry(dto, isBirth);
        countryDao.save(country);
        mapOfExistingCountries.put(sourceName, country);
        return country;
    }

    public void loadExistingCountries()
    {
        mapOfExistingCountries.clear();
        for (Country country : countryDao.findAll())
        {
            mapOfExistingCountries.put(country.getNom(), country);
        }
    }

    public void loadCountriesByCompetitions()
    {
        mapOfExistingCountriesByDomesticId.clear();
        for (Country country : countryDao.findAllWithCompetitions())
        {
            for (Competition comp : country.getCompetitions())
            {
                mapOfExistingCountriesByDomesticId.put(comp.getDomesticLeagueCode(), country);
            }
        }
    }

    public void clearCache()
    {
        mapOfExistingCountries.clear();
        mapOfExistingCountriesByDomesticId.clear();
    }
}