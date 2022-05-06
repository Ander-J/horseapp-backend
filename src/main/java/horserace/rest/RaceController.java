package horserace.rest;

import horserace.exception.CustomBadRequestException;
import horserace.exception.CustomNotFoundException;
import horserace.exception.ErrorMessage;
import horserace.persistence.entity.Race;
import horserace.persistence.entity.Results;
import horserace.rest.mapper.Mapper;
import horserace.rest.mapper.RaceDto;
import horserace.rest.mapper.ResultsDto;
import horserace.service.RaceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(value = "https://horseapp-64755.web.app/", allowedHeaders = "*")
@RestController
@AllArgsConstructor
@RequestMapping("api/race")
public class RaceController extends BaseController {
    private final Mapper mapper;
    private final RaceService raceService;

    @GetMapping
    public ResponseEntity<List<RaceDto>> getAll(){
        return ResponseEntity.ok(raceService.findAll().stream().map(mapper::map).collect(Collectors.toList()));
    }

    @GetMapping("/{raceId}")
    public ResponseEntity<RaceDto> getById(@PathVariable Integer raceId){
        return new ResponseEntity<>(mapper.map(raceService.findById(raceId)), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<RaceDto> createRace(@RequestBody Race race){
        Race newRace = raceService.newRace(race);
        System.out.println(newRace);
        return new ResponseEntity<>(mapper.map(newRace), HttpStatus.CREATED);
    }

    @GetMapping("/run/{raceId}")
    public ResponseEntity<ResultsDto> runRace(@PathVariable Integer raceId){
        Results results = raceService.runRace(raceId);
        System.out.println(results);
        return new ResponseEntity<>(mapper.map(results), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{raceId}")
    public ResponseEntity<Void> deleteRace(@PathVariable Integer raceId){
        raceService.cancelRace(raceId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ErrorMessage handleNotFound(CustomNotFoundException e) {
        return super.handleNotFound(e);
    }

    @Override
    public ErrorMessage handleBadRequest(CustomBadRequestException e) {
        return super.handleBadRequest(e);
    }
}
