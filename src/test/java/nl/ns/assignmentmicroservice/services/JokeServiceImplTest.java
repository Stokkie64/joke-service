package nl.ns.assignmentmicroservice.services;

import lombok.extern.slf4j.Slf4j;
import nl.ns.assignmentmicroservice.models.Joke;
import nl.ns.assignmentmicroservice.models.JokeapiResultDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@Slf4j
@SpringBootTest
class JokeServiceImplTest {

    @InjectMocks
    JokeServiceImpl service;

    @Mock
    RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getRandomJoke() {
        Joke joke = new Joke(20, "We messed up the keming again guys.");
        Joke jokeLonger = new Joke(21, "We messed up the keming again guys. slightly longer");

        List<Joke> jokes = new ArrayList<>(2);
        jokes.add(jokeLonger);
        jokes.add(joke);
        JokeapiResultDTO resultDTO = new JokeapiResultDTO(false, 2, jokes);

        when(restTemplate.getForObject("https://v2.jokeapi.dev/joke/Any?type=single&amount=16&safe-mode", JokeapiResultDTO.class))
                .thenReturn(resultDTO);

        log.debug("Random joke is " + service.getRandomJoke());
        assert(service.getRandomJoke().equals(joke));
    }
}