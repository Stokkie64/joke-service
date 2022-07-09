package nl.ns.assignmentmicroservice.models;

import lombok.Value;

@Value
public class JokeControllerResultDTO {
    Integer id;
    String randomJoke;
}
