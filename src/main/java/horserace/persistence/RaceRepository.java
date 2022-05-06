package horserace.persistence;

import horserace.persistence.entity.Race;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RaceRepository extends CrudRepository<Race, Integer> {
    List<Race> findAll();
}
