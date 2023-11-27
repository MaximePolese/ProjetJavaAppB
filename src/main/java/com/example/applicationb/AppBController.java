package com.example.applicationb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AppBController {

    private final RestTemplate restTemplate;

    public AppBController() {
        this.restTemplate = new RestTemplate();
    }

    @GetMapping(value = "/random-name")
    public String getRandomName() {
        return restTemplate.getForEntity("https://random-word-api.herokuapp.com/word", Object.class).getBody().toString();
    }

    @GetMapping(value = "/random")
    public list<Hero> getRandomPerso() {
        int randomId = (int) Math.floor(Math.random() * (2 - 1 + 1) + 1);
         = restTemplate.getForObject(" http://localhost:8081/personnages/{" + randomId + "}", Hero.class);
        return null;
    }

    @PostMapping(value = "/random")
    public String createRandomPerso() {
        this.getRandomName();
        return restTemplate.getForObject(" http://localhost:8081/personnages", String.class);
    }
}
