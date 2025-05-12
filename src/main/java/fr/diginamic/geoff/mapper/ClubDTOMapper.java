package fr.diginamic.geoff.mapper;

import fr.diginamic.geoff.dto.ClubDTO;
import fr.diginamic.geoff.entity.Club;
import fr.diginamic.geoff.entity.Stadium;
import fr.diginamic.geoff.entity.Url;
import fr.diginamic.geoff.entity.lookup.EntityType;

public class ClubDTOMapper
{
    private final ClubDTO dto;

    public ClubDTOMapper(ClubDTO dto)
    {
        this.dto = dto;
    }

    public Club mapToClub(Club club)
    {
        club.setSourceId(dto.getClubId());
        club.setClubCode(dto.getClubCode());
        club.setClubName(dto.getName());
        club.setTransferRecord(dto.getNetTransferRecord());
        return club;
    }

    public Stadium mapToStadium(Stadium stadium)
    {
        stadium.setName(dto.getStadiumName());
        stadium.setSeats(dto.getStadiumSeats());

        return stadium;
    }

    public Url mapToUrl(Url url)
    {
        url.setEntityType(EntityType.CLUB);
        url.setUrl(dto.getUrl());
        return url;
    }

}