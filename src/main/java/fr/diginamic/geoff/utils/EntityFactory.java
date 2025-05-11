package fr.diginamic.geoff.utils;

import fr.diginamic.geoff.dto.PlayerDTO;
import fr.diginamic.geoff.entity.*;
import fr.diginamic.geoff.mapper.PlayerDTOMapper;

public class EntityFactory
{
    PlayerDTO playerDTO;
    PlayerDTOMapper playerDTOMapper;

    public EntityFactory(PlayerDTO playerDTO)
    {
        this.playerDTO = playerDTO;
        PlayerDTOMapper playerDTOMapper = new PlayerDTOMapper(playerDTO);
    }

    public Player createPlayer()
    {
        Player player = new Player();
        return playerDTOMapper.mapToPlayer(player);
    }

    public Agent createAgent()
    {
        Agent agent = new Agent();
        return playerDTOMapper.mapToAgent(agent);
    }

    public City createCity()
    {
        City city = new City();
        return playerDTOMapper.mapToCity(city);
    }

    public Url createUrl()
    {
        Url url = new Url();
        return playerDTOMapper.mapToUrl(url);
    }

    public Club createClub()
    {
        Club club = new Club();
        return playerDTOMapper.mapToClub(club);
    }
}