package horserace.service;

import horserace.exception.CustomBadRequestException;
import horserace.exception.ErrorMessage;
import horserace.persistence.HorseRepository;
import horserace.persistence.entity.Horse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class HorseService {

    private final HorseRepository horseRepository;

    public List<Horse> findAll(){return new ArrayList<>(horseRepository.findAll());}

    public Horse newHorse(Horse horse){
        try {
            Horse newHorse = horseRepository.save(horse);
            return newHorse;
        }catch (ConstraintViolationException e){
            ErrorMessage errorMessage = new ErrorMessage(
                    "Invalid request", 400, "One of the required fields is empty or invalid"
            );
            throw new CustomBadRequestException(errorMessage);
        }
    }

}
