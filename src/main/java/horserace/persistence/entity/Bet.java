package horserace.persistence.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Accessors(chain = true)
public class Bet {
    @Id
    private Integer raceId;
    @NotNull
    private Integer betSize;
    @NotNull
    private Integer betHorseId;
    private boolean didWin;
}
