package fr.diginamic.geoff.utils;

import fr.diginamic.geoff.dto.PlayerDTO;
import fr.diginamic.geoff.entity.*;
import fr.diginamic.geoff.mapper.PlayerDTOMapper;

public class JpaEntityFactory
{

    public Player createPlayer(PlayerDTO playerDTO)
    {
        Player player = new Player();
        PlayerDTOMapper mapper = new PlayerDTOMapper(playerDTO);
        return mapper.mapToPlayer(player);
    }

    public Agent createAgent(PlayerDTO playerDTO)
    {
        Agent agent = new Agent();
        PlayerDTOMapper mapper = new PlayerDTOMapper(playerDTO);
        return mapper.mapToAgent(agent);
    }

    public City createCity(PlayerDTO playerDTO)
    {
        City city = new City();
        PlayerDTOMapper mapper = new PlayerDTOMapper(playerDTO);
        return mapper.mapToCity(city);
    }

    public Url createUrl(PlayerDTO playerDTO)
    {
        Url url = new Url();
        PlayerDTOMapper mapper = new PlayerDTOMapper(playerDTO);
        return mapper.mapToUrl(url);
    }

    public Club createClub(PlayerDTO playerDTO)
    {
        Club club = new Club();
        PlayerDTOMapper mapper = new PlayerDTOMapper(playerDTO);
        return mapper.mapToClub(club);
    }

    public Country createCountryBirth(PlayerDTO dto)
    {
        Country country = new Country();
        PlayerDTOMapper mapper = new PlayerDTOMapper(dto);
        return mapper.mapToCountryBirth(country);
    }

    public Country createCountryCitizenship(PlayerDTO dto)
    {
        Country country = new Country();
        PlayerDTOMapper mapper = new PlayerDTOMapper(dto);
        return mapper.mapToCountryCitizenship(country);
    }
}