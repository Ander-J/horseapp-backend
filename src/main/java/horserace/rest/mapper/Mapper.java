package horserace.rest.mapper;

import horserace.persistence.entity.Bet;
import horserace.persistence.entity.Horse;
import horserace.persistence.entity.Race;
import horserace.persistence.entity.Results;

@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {
    HorseDto map(Horse horse);
    Horse map (HorseDto horseDto);

    RaceDto map(Race race);
    Race map(RaceDto raceDto);

    ResultsDto map(Results results);
    Results map(ResultsDto resultsDto);

    BetDto map(Bet bet);
    Bet map(BetDto betDto);
}
