package nl.ns.assignmentmicroservice.services;

import lombok.extern.slf4j.Slf4j;
import nl.ns.assignmentmicroservice.mappers.JokeMapper;
import nl.ns.assignmentmicroservice.models.Joke;
import nl.ns.assignmentmicroservice.models.JokeControllerResultDTO;
import nl.ns.assignmentmicroservice.models.JokeapiResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class JokeServiceImpl implements JokeService {
    //TODO: add unit testing

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Joke getRandomJoke() {
        //TODO: Externalize api configs
        //TODO: Filter for shortest joke (query param)
        //TODO: Filter safe jokes (query param) not sexist or explicit.
        JokeapiResultDTO result = restTemplate.getForObject("https://v2.jokeapi.dev/joke/Any?type=single&amount=16", JokeapiResultDTO.class);
        log.debug("Result from joke api : " + result);
        if (result!= null && !result.getJokes().isEmpty()) {
            log.debug("Mapping first result");
            return result.getJokes().get(0);
        }
        return null;
    }
}
