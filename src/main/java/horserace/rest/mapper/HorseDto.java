package horserace.rest.mapper;

import lombok.Data;

import java.util.List;

@Data
public class HorseDto {
    private Integer id;
    private String name;
    private String color;
    private List<Integer> competitions;
    private List<Integer> results;
}
