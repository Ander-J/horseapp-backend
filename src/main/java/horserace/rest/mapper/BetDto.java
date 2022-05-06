package horserace.rest.mapper;

import lombok.Data;

@Data
public class BetDto {

    private Integer raceId;
    private Integer betSize;
    private Integer betHorseId;
    private boolean didWin;
}
