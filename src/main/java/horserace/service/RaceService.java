package horserace.service;

import horserace.exception.CustomBadRequestException;
import horserace.exception.CustomNotFoundException;
import horserace.exception.ErrorMessage;
import horserace.persistence.RaceRepository;
import horserace.persistence.ResultsRepository;
import horserace.persistence.entity.Bet;
import horserace.persistence.entity.Horse;
import horserace.persistence.entity.Race;
import horserace.persistence.entity.Results;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RaceService {
    private final RaceRepository raceRepository;
    private final BetService betService;
    private final ResultsRepository resultsRepository;

    public List<Race> findAll(){return new ArrayList<>(raceRepository.findAll());}

    public Race findById(Integer id){
        Optional<Race> race = raceRepository.findById(id);
        return race.orElse(null);
    }

    public Race newRace(Race race){
        try {
            return raceRepository.save(race);
        } catch (ConstraintViolationException e){
            ErrorMessage errorMessage = new ErrorMessage(
                    "Invalid request", 400, "One of the required fields is empty or invalid"
            );
            throw new CustomBadRequestException(errorMessage);
        }

    }

    public void cancelRace(Integer raceId){
        try{
            raceRepository.deleteById(raceId);
        } catch (IllegalArgumentException e){
            ErrorMessage errorMessage = new ErrorMessage(
                    "Not found error", 404, "Race not found"
            );
            throw new CustomNotFoundException(errorMessage);
        }
    }

    public Results runRace(Integer raceId){
        Race race = findById(raceId);
        if (race == null){
            ErrorMessage errorMessage = new ErrorMessage(
                    "Not Found", 404, "Race cant be found"
            );
            throw new CustomNotFoundException(errorMessage);
        }
        List<Integer> raceResult = race.getParticipantIds();
        Collections.shuffle(raceResult);
        Results results = new Results(race.getId(), raceResult, race.getTrack(), race.getDate());
        Bet bet = betService.findById(raceId);
        if (bet != null){
            betService.serveBet(bet, raceResult.get(0));
        }
        raceRepository.deleteById(raceId); //race is run and turns into results
        return resultsRepository.save(results);
    }
}
