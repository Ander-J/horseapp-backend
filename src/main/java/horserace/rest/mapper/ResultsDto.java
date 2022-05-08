package horserace.rest.mapper;

import horserace.persistence.entity.Horse;
import lombok.Data;

import java.util.List;

@Data
public class ResultsDto {
    private Integer id;
    private List<Horse> finishListing;
    private String track;
    private String date;
}
