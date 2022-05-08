package horserace.rest;

import horserace.exception.CustomBadRequestException;
import horserace.exception.ErrorMessage;
import horserace.persistence.entity.Horse;
import horserace.rest.mapper.HorseDto;
import horserace.rest.mapper.Mapper;
import horserace.rest.mapper.RaceDto;
import horserace.service.HorseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(value = "https://horseapp-64755.web.app/", allowedHeaders = "*")
@RestController
@AllArgsConstructor
@RequestMapping("api/horse")
public class HorseController extends BaseController {

    private final Mapper mapper;
    private final HorseService horseService;

    @GetMapping
    public ResponseEntity<List<HorseDto>> getAll(){
        return ResponseEntity.ok(horseService.findAll().stream().map(mapper::map).collect(Collectors.toList()));
    }

    @GetMapping("/{horseId}")
    public ResponseEntity<HorseDto> getById(@PathVariable Integer horseId){
        return new ResponseEntity<>(mapper.map(horseService.findById(horseId)), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<HorseDto> createHorse(@RequestBody Horse horse){
        Horse newHorse = horseService.newHorse(horse);

        return new ResponseEntity<>(mapper.map(newHorse), HttpStatus.CREATED);
    }

    @Override
    public ErrorMessage handleBadRequest(CustomBadRequestException e) {
        return super.handleBadRequest(e);
    }
}
