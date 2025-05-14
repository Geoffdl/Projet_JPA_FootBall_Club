package fr.diginamic.geoff.mapper;

import fr.diginamic.geoff.dto.PlayerDTO;
import fr.diginamic.geoff.entity.Club;
import fr.diginamic.geoff.entity.Country;
import fr.diginamic.geoff.entity.Player;
import fr.diginamic.geoff.entity.Url;

/**
 * Sets base attributes to new JPA entities from source dto
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
        player.setAgentName(playerDTO.getAgentName());
        player.setCityOfBirth(playerDTO.getCityOfBirth());

        player.setSourceId(playerDTO.getPlayerId());
        player.setFirstName(playerDTO.getFirstName());
        player.setLastName(playerDTO.getLastName());
        player.setPlayerCode(playerDTO.getPlayerCode());
        player.setDateOfBirth(playerDTO.getDateOfBirth());
        player.setShootingFoot(playerDTO.getFoot());
        player.setHeight(playerDTO.getHeightInCm());
        player.setPositionFavored(playerDTO.getPosition());
        player.setContractExpirationDate(playerDTO.getContractExpirationDate());
        return player;
    }

    public Url mapToUrl(Url url, boolean isImage)
    {
        if (isImage)
        {
            url.setUrl(playerDTO.getImageUrl());
        } else
        {
            url.setUrl(playerDTO.getUrl());
        }
        return url;
    }

    public Country mapToCountryBirth(Country country)
    {
        country.setNom(playerDTO.getCountryOfBirth());
        return country;
    }

    public Country mapToCountryCitizenship(Country country)
    {
        country.setNom(playerDTO.getCountryOfCitizenship());
        return country;
    }

    public Club mapToClub(Club club)
    {
        club.setSourceId(playerDTO.getCurrentClubId());
        club.setClubName(playerDTO.getCurrentClubName());

        return club;
    }
}