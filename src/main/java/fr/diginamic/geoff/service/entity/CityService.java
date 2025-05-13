package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.CityDao;
import fr.diginamic.geoff.dto.PlayerDTO;
import fr.diginamic.geoff.entity.City;
import fr.diginamic.geoff.utils.JpaEntityFactory;
import jakarta.persistence.EntityManager;

import java.util.HashMap;
import java.util.Map;

public class CityService
{
    private final CityDao cityDao;


    private final Map<String, City> mapOfExistingCities = new HashMap<>();


    public CityService(EntityManager em)
    {
        this.cityDao = new CityDao(em);
    }

    public City findOrCreateCity(PlayerDTO dto)
    {

        String cityName = dto.getCityOfBirth();
        if (cityName == null || cityName.trim().isEmpty())
        {
            return null;
        }
        City existing = mapOfExistingCities.get(cityName);
        if (existing != null)
        {
            return existing;
        }

        mapOfExistingCities.put(cityName, city);

        City city = JpaEntityFactory.createCity(dto);

        cityDao.save(city);
        return city;
    }

    public void loadExistingCities()
    {
        mapOfExistingCities.clear();
        for (City city : cityDao.findAll())
        {
            mapOfExistingCities.put(city.getName(), city);
        }
    }

    public void clearCache()
    {
        mapOfExistingCities.clear();
    }
}