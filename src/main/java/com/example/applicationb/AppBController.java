package com.example.applicationb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class AppBController {

    private final RestTemplate restTemplate;
    private final Repo repo;
    private int maxId;
    private int lastLength;

    public AppBController(Repo repo) {
        this.restTemplate = new RestTemplate();
        this.repo = repo;
        this.maxId = 0;
        this.lastLength = 0;
    }

    @GetMapping(value = "/random-name")
    public String getRandomName() {
        return restTemplate.getForEntity("https://random-word-api.herokuapp.com/word", Object.class).getBody().toString().replace("[", "").replace("]", "");
    }

    @GetMapping(value = "/random")
    public Hero getRandomHero() {
        Hero[] heroes = repo.findAll();
        System.out.println(Arrays.toString(heroes));
        int randomIndex = (int) Math.floor(Math.random() * heroes.length);
        System.out.println(randomIndex);
        return heroes[randomIndex];
    }

    public int getMaxId() {
        Hero[] heroes = repo.findAll();
        if (heroes.length > lastLength) {
            lastLength = heroes.length;
            maxId = heroes.length + 1;
        } else {
            maxId = maxId + 1;
        }
        return maxId;
    }

    @PostMapping(value = "/random")
    public Hero createRandomHero() {
        String randomName = this.getRandomName();
        int id = this.getMaxId();
        Hero newHero = new Hero(id, randomName, "Avengers", 99);
        System.out.println(newHero);
        return repo.save(newHero);
    }
}
