package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.UrlDao;
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

    public Url findOrCreateUrl(PlayerDTO dto)
    {
        if (dto.getUrl() == null)
        {
            return null;
        }

        Optional<Url> urlOptional = urlDao.findByCode(dto.getUrl());

        if (urlOptional.isPresent())
        {
            urlOptional.get().setEntityType(EntityType.PLAYER);
            return urlOptional.get();
        }

        Url url = factory.createUrl(dto);
        url.setEntityType(EntityType.PLAYER);
        urlDao.save(url);
        return url;
    }

    public Url findOrCreateImageUrl(PlayerDTO dto)
    {
        if (dto.getImageUrl() == null)
        {
            return null;
        }

        Optional<Url> urlOptional = urlDao.findByCode(dto.getImageUrl());

        if (urlOptional.isPresent())
        {
            urlOptional.get().setEntityType(EntityType.PLAYER);
            return urlOptional.get();
        }

        Url url = factory.createUrl(dto);
        url.setEntityType(EntityType.PLAYER);
        urlDao.save(url);
        return url;
    }

}