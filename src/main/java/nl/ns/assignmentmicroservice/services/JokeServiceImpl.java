package nl.ns.assignmentmicroservice.services;

import lombok.extern.slf4j.Slf4j;
import nl.ns.assignmentmicroservice.models.Joke;
import nl.ns.assignmentmicroservice.models.JokeapiResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Comparator;
import java.util.Optional;

@Slf4j
@Service
public class JokeServiceImpl implements JokeService {
    @Autowired
    RestTemplate restTemplate;

    @Override
    public Joke getRandomJoke() {
        //TODO: Externalize api configs
        JokeapiResultDTO result = restTemplate.getForObject("https://v2.jokeapi.dev/joke/Any?type=single&amount=16&safe-mode", JokeapiResultDTO.class);
        log.debug("Result from joke api : " + result);

        if (result != null && !result.getJokes().isEmpty()) {
            log.debug("Mapping Shortest joke result");
            Optional<Joke> shortestJoke = result.getJokes().stream().min(Comparator.comparing(Joke::getJoke));
            return shortestJoke.orElse(null);
        }
        return null;
    }
}
