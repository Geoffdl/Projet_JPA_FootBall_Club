package fr.diginamic.geoff.builder;

import fr.diginamic.geoff.dto.PlayerDTO;
import fr.diginamic.geoff.exception.CsvFormatException;
import fr.diginamic.geoff.parser.CsvDataParser;
import fr.diginamic.geoff.utils.Deserializer;

import java.io.IOException;
import java.time.Year;
import java.util.List;

import static java.lang.Integer.parseInt;

public class PlayerDTOBuilder
{

    private final String dataSource;

    public PlayerDTOBuilder(String dataSource)
    {
        this.dataSource = dataSource;
    }

    /**
     * @return
     */
    public List<PlayerDTO> createPlayerDTO()
    {

        List<String> lines = CsvDataParser.readFile(dataSource);
        lines.removeFirst();


        return lines.stream()
                .map(l ->
                {
                    PlayerDTO playerDTO = new PlayerDTO();
                    setAttributes(playerDTO, l);
                    return playerDTO;
                })
                .toList();
    }

    private void setAttributes(PlayerDTO playerDTO, String l)
    {
        l = l.trim();
        String[] parts = l.split(",");
        if (parts.length != 23)
        {
            throw new CsvFormatException(String.format("Attribute mismatch expected size %d, actual %d", 21, parts.length));

        }

        playerDTO.setPlayerId(Deserializer.stringToInt(parts[0]));
        playerDTO.setFirstName(parts[1]);
        playerDTO.setLastName(parts[2]);
        playerDTO.setName(parts[3]);
        playerDTO.setLastSeason(Year.of(parseInt(parts[4])));
        playerDTO.setCurrentClubId(Deserializer.stringToInt(parts[5]));
        playerDTO.setPlayerCode(parts[6]);
        playerDTO.setCountryOfBirth(parts[7]);
        playerDTO.setCityOfBirth(parts[8]);
        playerDTO.setCountryOfCitizenship(parts[9]);
        playerDTO.setDateOfBirth(Deserializer.stringToLocalDate(parts[10]));
        playerDTO.setSubPosition(parts[11]);
        playerDTO.setPosition(parts[12]);
        playerDTO.setFoot(parts[13]);
        playerDTO.setHeightInCm(Deserializer.stringToInt(parts[14]));
        playerDTO.setMarketValueInEur(Deserializer.stringToInt(parts[15]));
        playerDTO.setHighestMaketValue(Deserializer.stringToInt(parts[16]));
        playerDTO.setContractExpirationDate(Deserializer.stringToLocalDateTime(parts[17]));
        playerDTO.setAgentName(parts[18]);
        playerDTO.setImageUrl(parts[19]);
        playerDTO.setUrl(parts[20]);
        playerDTO.setCurrentClubDomesticCompetitionId(parts[21]);
        playerDTO.setCurrentClubName(parts[22]);
    }


}