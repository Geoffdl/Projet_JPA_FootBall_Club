package fr.diginamic.geoff.service.entity;

import fr.diginamic.geoff.dao.PlayerDao;
import fr.diginamic.geoff.dto.PlayerDTO;
import fr.diginamic.geoff.entity.Player;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerServiceTest
{

    private PlayerService playerService;
    private StubPlayerDao stubDao;

    static class StubPlayerDao extends PlayerDao
    {
        private final List<Player> saved = new ArrayList<>();
        private final List<Player> allPlayers = new ArrayList<>();

        public StubPlayerDao(EntityManager em) {super(em);}

        @Override
        public void save(Player player) {saved.add(player);}

        @Override
        public List<Player> findAll() {return allPlayers;}

        public void addExisting(Player player) {allPlayers.add(player);}
    }

    static class StubJpaEntityFactory
    {
        public static Player createPlayer(PlayerDTO dto)
        {
            Player p = new Player();
            p.setSourceId(dto.getPlayerId());
            p.setCityOfBirth(dto.getCityOfBirth());
            return p;
        }
    }

    @BeforeEach
    void setUp()
    {
        EntityManager em = null;
        stubDao = new StubPlayerDao(em);
        playerService = new PlayerService(stubDao);
    }

    @Test
    void testFindOrCreatePlayer_CreatesAndCaches()
    {
        PlayerDTO dto = new PlayerDTO();
        dto.setPlayerId(1L);
        dto.setCityOfBirth("Paris");

        Player found = playerService.findOrCreatePlayer(dto);

        assertNotNull(found);
        assertEquals(1L, found.getSourceId());
        assertEquals("Paris", found.getCityOfBirth());
        assertSame(found, playerService.findOrCreatePlayer(dto));
        assertEquals(1, stubDao.saved.size());
    }

    @Test
    void testFindOrCreatePlayer_UsesCache()
    {
        PlayerDTO dto = new PlayerDTO();
        dto.setPlayerId(2L);
        dto.setCityOfBirth("Lyon");

        Player player1 = StubJpaEntityFactory.createPlayer(dto);
        stubDao.save(player1);

        Player found1 = playerService.findOrCreatePlayer(dto);
        dto.setCityOfBirth("Marseille");
        Player found2 = playerService.findOrCreatePlayer(dto);

        assertSame(found1, found2);
        assertEquals("Marseille", found2.getCityOfBirth());
    }

    @Test
    void testLoadExistingPlayersAndClearCache()
    {
        Player existing = new Player();
        existing.setSourceId(3L);
        existing.setCityOfBirth("Nice");
        stubDao.addExisting(existing);

        playerService.loadExistingPlayers();
        PlayerDTO dummyDto = new PlayerDTO();
        dummyDto.setPlayerId(3L);

        Player found = playerService.findOrCreatePlayer(dummyDto);
        assertSame(existing, found);

        playerService.clearCache();
        PlayerDTO newDto = new PlayerDTO();
        newDto.setPlayerId(4L);
        Player newPlayer = StubJpaEntityFactory.createPlayer(newDto);
        stubDao.save(newPlayer);
        Player foundNew = playerService.findOrCreatePlayer(newDto);
        assertNotNull(foundNew);
        assertNotSame(existing, foundNew);
    }
}