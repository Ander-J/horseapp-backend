package horserace.persistence;

import horserace.persistence.entity.Bet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface BetRepository extends CrudRepository<Bet, Integer> {
    List<Bet> findAll();
}
