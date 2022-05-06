package horserace.rest;

import horserace.exception.CustomNotFoundException;
import horserace.exception.ErrorMessage;
import horserace.rest.mapper.Mapper;
import horserace.rest.mapper.ResultsDto;
import horserace.service.ResultsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(value = "https://horseapp-64755.web.app/", allowedHeaders = "*")
@RestController
@AllArgsConstructor
@RequestMapping("api/result")
public class ResultsController extends BaseController {
    private final Mapper mapper;
    private final ResultsService resultsService;

    @GetMapping
    public ResponseEntity<List<ResultsDto>> getAll(){
        return ResponseEntity.ok(resultsService.findAll().stream().map(mapper::map).collect(Collectors.toList()));
    }

    @DeleteMapping("/delete/{resultsId}")
    public ResponseEntity<Void> deleteRace(@PathVariable Integer resultsId){
        resultsService.deleteResults(resultsId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ErrorMessage handleNotFound(CustomNotFoundException e) {
        return super.handleNotFound(e);
    }
}
