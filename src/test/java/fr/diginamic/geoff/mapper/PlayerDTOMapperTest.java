package fr.diginamic.geoff.mapper;

import fr.diginamic.geoff.dto.PlayerDTO;
import fr.diginamic.geoff.entity.Player;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerDTOMapperTest
{

    @Test
    void testMapToPlayer()
    {
        PlayerDTO dto = new PlayerDTO();
        dto.setAgentName("AgentX");
        dto.setCityOfBirth("Paris");
        dto.setPlayerId(42L);
        dto.setFirstName("Kylian");
        dto.setLastName("Mbappé");
        dto.setPlayerCode("KM7");
        dto.setDateOfBirth(LocalDate.of(1998, 12, 20));
        dto.setFoot("Right");
        dto.setHeightInCm(178);
        dto.setPosition("Forward");
        dto.setContractExpirationDate(LocalDateTime.of(2025, 6, 30, 0, 0));

        Player player = new Player();

        PlayerDTOMapper mapper = new PlayerDTOMapper(dto);
        Player mapped = mapper.mapToPlayer(player);

        assertEquals("AgentX", mapped.getAgentName());
        assertEquals("Paris", mapped.getCityOfBirth());
        assertEquals(42L, mapped.getSourceId());
        assertEquals("Kylian", mapped.getFirstName());
        assertEquals("Mbappé", mapped.getLastName());
        assertEquals("KM7", mapped.getPlayerCode());
        assertEquals(LocalDate.of(1998, 12, 20), mapped.getDateOfBirth());
        assertEquals("Right", mapped.getShootingFoot());
        assertEquals(178, mapped.getHeight());
        assertEquals("Forward", mapped.getPositionFavored());
        assertEquals(LocalDateTime.of(2025, 6, 30, 0, 0), mapped.getContractExpirationDate());
    }
}