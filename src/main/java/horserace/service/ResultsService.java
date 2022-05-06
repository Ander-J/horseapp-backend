package horserace.service;

import horserace.exception.CustomNotFoundException;
import horserace.exception.ErrorMessage;
import horserace.persistence.ResultsRepository;
import horserace.persistence.entity.Results;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ResultsService {
    private final ResultsRepository resultsRepository;

    public List<Results> findAll(){
        return new ArrayList<>(resultsRepository.findAll());
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
