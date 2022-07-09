package nl.ns.assignmentmicroservice.mappers;

import nl.ns.assignmentmicroservice.models.Joke;
import nl.ns.assignmentmicroservice.models.JokeControllerResultDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface JokeMapper {

    @Mapping(target = "randomJoke", source = "joke")
    JokeControllerResultDTO map(Joke joke);
}
