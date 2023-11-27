package com.example.applicationb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AppBController {

    private final RestTemplate restTemplate;
    private final Repo repo;

    public AppBController(Repo repo) {
        this.restTemplate = new RestTemplate();
        this.repo = repo;
    }

    @GetMapping(value = "/random-name")
    public String getRandomName() {
        return restTemplate.getForEntity("https://random-word-api.herokuapp.com/word", Object.class).getBody().toString();
    }

    @GetMapping(value = "/random")
    public Hero getRandomHero() {
        List<Hero> heros = repo.findAll();
        int randomId = (int) Math.floor(Math.random() * (2 - 1 + 1) + 1);
        Hero ramdomHero = heros.findById(randomId);
        return ramdomHero;
    }

    @PostMapping(value = "/random")
    public String createRandomPerso() {
        this.getRandomName();
        return restTemplate.getForObject(" http://localhost:8081/personnages", String.class);
    }
}
