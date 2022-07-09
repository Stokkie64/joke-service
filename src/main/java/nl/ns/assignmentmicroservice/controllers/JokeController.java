package nl.ns.assignmentmicroservice.controllers;

import lombok.extern.slf4j.Slf4j;
import nl.ns.assignmentmicroservice.exceptions.ValidationException;
import nl.ns.assignmentmicroservice.mappers.JokeMapper;
import nl.ns.assignmentmicroservice.models.Joke;
import nl.ns.assignmentmicroservice.models.JokeControllerResultDTO;
import nl.ns.assignmentmicroservice.models.JokeapiResultDTO;
import nl.ns.assignmentmicroservice.services.JokeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class JokeController {
    //TODO: Add integration testing

    @Autowired
    JokeServiceImpl service;

    @Autowired
    JokeMapper mapper;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    JokeControllerResultDTO getHighestFrequency() {
        Joke randomJoke = service.getRandomJoke();
        log.debug("Random joke result : " + randomJoke);
        return mapper.map(randomJoke);
    }
}
