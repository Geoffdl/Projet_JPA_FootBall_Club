package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.CountryDao;
import fr.diginamic.geoff.dto.CompetitionDTO;
import fr.diginamic.geoff.dto.PlayerDTO;
import fr.diginamic.geoff.entity.Country;
import fr.diginamic.geoff.utils.JpaEntityFactory;

import java.util.Optional;

public class CountryService
{
    private final CountryDao countryDao;
    private final JpaEntityFactory factory;

    public CountryService(CountryDao countryDao, JpaEntityFactory factory)
    {
        this.countryDao = countryDao;
        this.factory = factory;
    }

    public Country findOrCreateBirthCountry(PlayerDTO dto)
    {
        if (dto.getCountryOfBirth() == null)
        {
            return null;
        }

        Optional<Country> countryOptional = countryDao.findByNom(dto.getCountryOfBirth());

        if (countryOptional.isPresent())
        {
            return countryOptional.get();
        }

        Country country = factory.createCountryBirth(dto);
        countryDao.save(country);
        return country;
    }

    public Country findOrCreateCitizenshipCountry(PlayerDTO dto)
    {
        if (dto.getCountryOfCitizenship() == null)
        {
            return null;
        }

        Optional<Country> countryOptional = countryDao.findByNom(dto.getCountryOfCitizenship());

        if (countryOptional.isPresent())
        {
            return countryOptional.get();
        }

        Country country = factory.createCountryCitizenship(dto);
        countryDao.save(country);
        return country;
    }

    public Country findOrCreateCompetitionCountry(CompetitionDTO dto) {}
}