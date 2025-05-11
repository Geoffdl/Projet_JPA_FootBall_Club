package fr.diginamic.geoff.mapper;

import fr.diginamic.geoff.dto.PlayerDTO;
import fr.diginamic.geoff.entity.*;

/**
 *
 */
public class PlayerDTOMapper
{
    private final PlayerDTO playerDTO;

    public PlayerDTOMapper(PlayerDTO playerDTO)
    {
        this.playerDTO = playerDTO;
    }

    public Player mapToPlayer(Player player)
    {
        player.setFirstName(playerDTO.getFirstName());
        player.setLastName(playerDTO.getLastName());
        player.setPlayerCode(playerDTO.getPlayerCode());
        player.setDateOfBirth(playerDTO.getDateOfBirth());
        player.setShooting_foot(playerDTO.getFoot());
        player.setHeight(playerDTO.getHeightInCm());
        player.setPositionFavored(playerDTO.getPosition());
        player.setContractExpirationDate(playerDTO.getContractExpirationDate());
        return player;
    }

    public Agent mapToAgent(Agent agent)
    {

        agent.setName(playerDTO.getAgentName());
        return agent;
    }

    public City mapToCity(City city)
    {
        city.setName(playerDTO.getCityOfBirth());
        return city;
    }

    public Url mapToUrl(Url url)
    {
        url.setUrl(playerDTO.getUrl());
        return url;
    }

    public Club mapToClub(Club club)
    {
        club.setClubName(playerDTO.getCurrentClubName());
        return club;
    }
}