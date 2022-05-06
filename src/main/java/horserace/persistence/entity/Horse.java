package horserace.persistence.entity;

import horserace.exception.CustomBadRequestException;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Entity
@Accessors(chain = true)
public class Horse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String name;

    private String color;
    @ElementCollection
    private List<Integer> competitions;
    @ElementCollection
    private List<Integer> results;

}
