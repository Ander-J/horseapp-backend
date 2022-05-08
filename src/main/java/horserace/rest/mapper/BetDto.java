package horserace.rest.mapper;

import horserace.persistence.entity.Horse;
import lombok.Data;

@Data
public class BetDto {

    private Integer raceId;
    private Integer betSize;
    private Horse betHorse;
    private boolean didWin;
}
