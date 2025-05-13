package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.UrlDao;
import fr.diginamic.geoff.dto.ClubDTO;
import fr.diginamic.geoff.dto.CompetitionDTO;
import fr.diginamic.geoff.dto.PlayerDTO;
import fr.diginamic.geoff.entity.Url;
import fr.diginamic.geoff.entity.lookup.EntityType;
import fr.diginamic.geoff.utils.JpaEntityFactory;
import jakarta.persistence.EntityManager;

import java.util.HashMap;
import java.util.Map;

public class UrlService
{
    private final UrlDao urlDao;

    private final Map<String, Url> mapOfExistingPlayerUrl = new HashMap<>();
    private final Map<String, Url> mapOfExistingCompetitionUrls = new HashMap<>();
    private final Map<String, Url> mapOfExistingClubUrls = new HashMap<>();

    public UrlService(EntityManager em)
    {
        this.urlDao = new UrlDao(em);

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

        Url existing = mapOfExistingPlayerUrl.get(urlString);
        if (existing != null)
        {
            return existing;
        }

        Url url = JpaEntityFactory.createUrl(dto, isImage);
        url.setEntityType(EntityType.PLAYER);
        mapOfExistingPlayerUrl.put(urlString, url);
        urlDao.save(url);

        return url;
    }


    public Url findOrCreateCompetitionUrl(CompetitionDTO dto)
    {
        String urlString = dto.getUrl();

        Url existing = mapOfExistingCompetitionUrls.get(urlString);
        if (existing != null)
        {
            return existing;
        }

        Url url = JpaEntityFactory.createUrlFromCompetition(dto);
        urlDao.save(url);
        mapOfExistingCompetitionUrls.put(urlString, url);
        return url;
    }

    public Url findOrCreateUrlFromClubDTO(ClubDTO dto)
    {
        String urlString = dto.getUrl();
        Url existing = mapOfExistingClubUrls.get(urlString);
        if (existing != null)
        {
            return existing;
        }
        Url url = JpaEntityFactory.createUrlFromClub(dto);
        urlDao.save(url);
        mapOfExistingClubUrls.put(urlString, url);
        return url;
    }

    public void loadExistingPlayerUrls()
    {
        mapOfExistingPlayerUrl.clear();
        for (Url url : urlDao.findAll())
        {
            mapOfExistingPlayerUrl.put(url.getUrl(), url);
        }
    }

    public void loadExistingCompetitionUrls()
    {
        mapOfExistingCompetitionUrls.clear();
        for (Url url : urlDao.findAllCompetitionUrls())
        {
            mapOfExistingCompetitionUrls.put(url.getUrl(), url);
        }
    }

    public void clearCache()
    {
        mapOfExistingPlayerUrl.clear();

    }

    public void loadExistingClubUrls()
    {
        mapOfExistingClubUrls.clear();
        for (Url url : urlDao.findAllClubUrls())
        {
            mapOfExistingClubUrls.put(url.getUrl(), url);
        }
    }
}