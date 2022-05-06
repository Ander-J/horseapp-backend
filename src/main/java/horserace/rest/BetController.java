package horserace.rest;

import horserace.exception.CustomBadRequestException;
import horserace.exception.ErrorMessage;
import horserace.persistence.entity.Bet;
import horserace.persistence.entity.Horse;
import horserace.rest.mapper.BetDto;
import horserace.rest.mapper.HorseDto;
import horserace.rest.mapper.Mapper;
import horserace.service.BetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(value = "https://horseapp-64755.web.app/", allowedHeaders = "*")
@RestController
@AllArgsConstructor
@RequestMapping("api/bet")
public class BetController extends BaseController {

    private final Mapper mapper;
    private final BetService betService;

    @GetMapping()
    public ResponseEntity<List<BetDto>> getAll(){
        return ResponseEntity.ok(betService.findAll().stream().map(mapper::map).collect(Collectors.toList()));
    }

    @PostMapping("/new")
    public ResponseEntity<BetDto> createBet(@RequestBody Bet bet){
        Bet newBet = betService.newBet(bet);

        return new ResponseEntity<>(mapper.map(newBet), HttpStatus.CREATED);
    }

    @Override
    public ErrorMessage handleBadRequest(CustomBadRequestException e) {
        return super.handleBadRequest(e);
    }
}
