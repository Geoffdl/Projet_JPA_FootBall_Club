package fr.diginamic.geoff.service;

import fr.diginamic.geoff.dao.CityDao;
import fr.diginamic.geoff.dto.PlayerDTO;
import fr.diginamic.geoff.entity.Agent;
import fr.diginamic.geoff.entity.City;
import fr.diginamic.geoff.utils.JpaEntityFactory;

import java.util.Optional;

public class CityService
{
    private final CityDao cityDao;
    private final JpaEntityFactory factory;

    public CityService(CityDao cityDao, JpaEntityFactory factory)
    {
        this.cityDao = cityDao;
        this.factory = factory;
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

        City city = factory.createCity(dto);
        cityDao.save(city);
        return city;
    }
}