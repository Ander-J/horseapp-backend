package horserace.persistence;

import horserace.persistence.entity.Horse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorseRepository extends CrudRepository<Horse, Integer> {
    List<Horse> findAll();
}
