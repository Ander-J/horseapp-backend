package horserace.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Results {

    @Id
    private Integer id;
    @ManyToMany     //since all races have unique generated id-s, this shouldn't run into issues
    private List<Horse> finishListing;

    private String track;

    private String date;

}
