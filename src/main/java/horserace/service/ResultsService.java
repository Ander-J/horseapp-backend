package horserace.service;

import horserace.exception.CustomNotFoundException;
import horserace.exception.ErrorMessage;
import horserace.persistence.ResultsRepository;
import horserace.persistence.entity.Race;
import horserace.persistence.entity.Results;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ResultsService {
    private final ResultsRepository resultsRepository;

    public List<Results> findAll(){
        return new ArrayList<>(resultsRepository.findAll());
    }

    public Results findById(Integer id){
        Optional<Results> results = resultsRepository.findById(id);
        return results.orElse(null);
    }

    public void deleteResults(Integer resultsId){
        try{
            resultsRepository.deleteById(resultsId);
        } catch (IllegalArgumentException e){
            ErrorMessage errorMessage = new ErrorMessage(
                    "Not found error", 404, "Race not found"
            );
            throw new CustomNotFoundException(errorMessage);
        }
    }
}
