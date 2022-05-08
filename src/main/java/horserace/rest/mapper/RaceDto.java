package horserace.rest.mapper;

import horserace.persistence.entity.Horse;
import lombok.Data;

import java.util.List;

@Data
public class RaceDto {
    private Integer id;
    private List<Horse> participants;
    private String track;
    private String date;
}
