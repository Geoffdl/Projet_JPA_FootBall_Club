package fr.diginamic.geoff.builder;

import fr.diginamic.geoff.dto.PlayerDTO;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DTOBuilderTest
{

    @Test
    void testBuildDTOList()
    {
        // Header + 1 data line
        List<String> lines = List.of(
                "playerId,firstName,lastName,name,lastSeason,currentClubId,playerCode,countryOfBirth,cityOfBirth,countryOfCitizenship,dateOfBirth,subPosition,position,foot,heightInCm,marketValueInEur,highestMarketValue,contractExpirationDate,agentName,imageUrl,url,currentClubDomesticCompetitionId,currentClubName",
                "1,John,Doe,John Doe,2023,10,JD123,USA,New York,USA,1990-01-01,Midfielder,CM,Right,180,1000000,2000000,2025-06-30 00:00:00,AgentX,http://image.url,http://player.url,MLS,New York FC"
        );

        PlayerDTOBuilder builder = new PlayerDTOBuilder();
        List<PlayerDTO> dtos = builder.buildDTOList(lines);

        assertEquals(1, dtos.size());
        PlayerDTO dto = dtos.getFirst();

        assertEquals(1L, dto.getPlayerId());
        assertEquals("John", dto.getFirstName());
        assertEquals("Doe", dto.getLastName());
        assertEquals("John Doe", dto.getName());
        assertEquals(Year.of(2023), dto.getLastSeason());
        assertEquals(10L, dto.getCurrentClubId());
        assertEquals("JD123", dto.getPlayerCode());
        assertEquals("USA", dto.getCountryOfBirth());
        assertEquals("new york", dto.getCityOfBirth());
        assertEquals("USA", dto.getCountryOfCitizenship());
        assertEquals(LocalDate.parse("1990-01-01"), dto.getDateOfBirth());
        assertEquals("Midfielder", dto.getSubPosition());
        assertEquals("CM", dto.getPosition());
        assertEquals("Right", dto.getFoot());
        assertEquals(180, dto.getHeightInCm());
        assertEquals(1000000, dto.getMarketValueInEur());
        assertEquals(2000000, dto.getHighestMarketValue());
        assertEquals(LocalDateTime.parse("2025-06-30T00:00"), dto.getContractExpirationDate());
        assertEquals("AgentX", dto.getAgentName());
        assertEquals("http://image.url", dto.getImageUrl());
        assertEquals("http://player.url", dto.getUrl());
        assertEquals("MLS", dto.getCurrentClubDomesticCompetitionId());
        assertEquals("New York FC", dto.getCurrentClubName());
    }
}