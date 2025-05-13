package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.CityDao;
import fr.diginamic.geoff.dto.PlayerDTO;
import fr.diginamic.geoff.entity.City;
import fr.diginamic.geoff.utils.JpaEntityFactory;

import java.util.HashMap;
import java.util.Map;

public class CityService
{
    private final CityDao cityDao;
    private final JpaEntityFactory factory;

    private final Map<String, City> mapOfExistingCities = new HashMap<>();

    public CityService(CityDao cityDao, JpaEntityFactory factory)
    {
        this.cityDao = cityDao;
        this.factory = factory;
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

        City city = factory.createCity(dto);
        mapOfExistingCities.put(cityName, city);
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