package nl.ns.assignmentmicroservice.controllers;

import com.google.gson.Gson;
import nl.ns.assignmentmicroservice.mappers.JokeMapper;
import nl.ns.assignmentmicroservice.models.Joke;
import nl.ns.assignmentmicroservice.services.JokeServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JokeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    JokeController jokeController;

    @Mock
    JokeServiceImpl jokeService;

    @Mock
    JokeMapper mapper;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(jokeController)
                .build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getHighestFrequency() throws Exception {
        Joke joke = new Joke(123, "Joke here");
        when(jokeService.getRandomJoke()).thenReturn(joke);

        mockMvc.perform(get("/").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}