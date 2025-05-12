package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.UrlDao;
import fr.diginamic.geoff.dto.ClubDTO;
import fr.diginamic.geoff.dto.CompetitionDTO;
import fr.diginamic.geoff.dto.PlayerDTO;
import fr.diginamic.geoff.entity.Url;
import fr.diginamic.geoff.entity.lookup.EntityType;
import fr.diginamic.geoff.utils.JpaEntityFactory;

import java.util.Optional;

public class UrlService
{
    private final UrlDao urlDao;
    private final JpaEntityFactory factory;

    public UrlService(UrlDao urlDao, JpaEntityFactory factory)
    {
        this.urlDao = urlDao;
        this.factory = factory;
    }

    public Url findOrCreateUrl(PlayerDTO dto, boolean isImage)
    {
        String urlString;
        if (isImage)
        {
            urlString = dto.getImageUrl();
        } else
        {
            urlString = dto.getUrl();
        }
        Optional<Url> urlOptional = urlDao.findByCode(urlString);
        if (urlOptional.isPresent())
        {
            return urlOptional.get();
        }

        Url url = factory.createUrl(dto, isImage);
        url.setEntityType(EntityType.PLAYER);
        urlDao.save(url);
        return url;
    }


    public Url findOrCreateCompetitionUrl(CompetitionDTO dto)
    {
        if (dto.getUrl() == null)
        {
            return null;
        }
        Optional<Url> urlOptional = urlDao.findByCode(dto.getUrl());
        if (urlOptional.isPresent())
        {
            return urlOptional.get();
        }
        Url url = factory.createUrlFromCompetition(dto);
        urlDao.save(url);
        return url;
    }

    public Url findOrCreateUrlFromClubDTO(ClubDTO dto)
    {
        if (dto.getUrl() == null)
        {
            return null;
        }
        Optional<Url> urlOptional = urlDao.findByCode(dto.getUrl());
        if (urlOptional.isPresent())
        {
            return urlOptional.get();
        }
        Url url = factory.createUrlFromClub(dto);
        urlDao.save(url);
        return url;
    }
}