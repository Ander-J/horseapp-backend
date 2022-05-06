package horserace.persistence;

import horserace.persistence.entity.Results;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultsRepository extends CrudRepository<Results, Integer> {
    List<Results> findAll();
}
