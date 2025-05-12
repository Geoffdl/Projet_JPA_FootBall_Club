package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.CityDao;
import fr.diginamic.geoff.dto.PlayerDTO;
import fr.diginamic.geoff.entity.City;
import fr.diginamic.geoff.utils.JpaEntityFactory;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class CityService
{
    private final CityDao cityDao;

    public CityService(EntityManager em)
    {
        this.cityDao = new CityDao(em);
    }

    public City findOrCreateCity(PlayerDTO dto)
    {
        if (dto.getCityOfBirth() == null || dto.getCityOfBirth().trim().isEmpty())
        {
            return null;
        }

        Optional<City> cityOptional = cityDao.findByName(dto.getCityOfBirth());

        if (cityOptional.isPresent())
        {
            return cityOptional.get();
        }

        City city = JpaEntityFactory.createCity(dto);
        cityDao.save(city);
        return city;
    }
}