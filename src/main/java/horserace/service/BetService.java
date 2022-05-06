package horserace.service;

import horserace.exception.CustomBadRequestException;
import horserace.exception.ErrorMessage;
import horserace.persistence.BetRepository;
import horserace.persistence.entity.Bet;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BetService {
    private final BetRepository betRepository;

    public List<Bet> findAll(){return new ArrayList<>(betRepository.findAll());}

    public Bet findById(Integer id){
        Optional<Bet> bet = betRepository.findById(id);
        return bet.orElse(null);
    }

    public Bet newBet(Bet bet){
        try {
            return betRepository.save(bet);
        } catch (ConstraintViolationException e){
            ErrorMessage errorMessage = new ErrorMessage(
                    "Invalid request", 400, "One of the required fields is empty or invalid"
            );
            throw new CustomBadRequestException(errorMessage);
        }
    }

    public void serveBet(Bet bet, Integer winningHorseId){
        if (Objects.equals(winningHorseId, bet.getBetHorseId())){
            bet.setDidWin(true);
        }
        else {bet.setDidWin(false);}
        betRepository.save(bet);
    }
}
