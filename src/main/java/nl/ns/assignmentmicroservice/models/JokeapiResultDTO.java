package nl.ns.assignmentmicroservice.models;

import lombok.Value;

import java.util.List;

@Value
public class JokeapiResultDTO {
    Boolean error;
    Integer amount;
    List<Joke> jokes;
}
