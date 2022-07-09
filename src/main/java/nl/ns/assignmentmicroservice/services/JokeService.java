package nl.ns.assignmentmicroservice.services;

import nl.ns.assignmentmicroservice.models.Joke;

public interface JokeService {
    Joke getRandomJoke ();
}
