package horserace.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Results {

    @Id
    private Integer id;     //ID of a race and its results will be the same
    @ElementCollection      //since all races have unique generated id-s, this shouldn't run into issues
    private List<Integer> finishListing;

    private String track;

    private String date;

}
