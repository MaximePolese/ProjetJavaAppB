package com.example.applicationb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class AppBController {
    private Repo repo;
    private int maxId;
    private int lastLength;

    public AppBController(Repo repo) {
        this.repo = repo;
        this.maxId = 0;
        this.lastLength = 0;
    }

    @GetMapping(value = "/random-name")
    public String createName() {
        return repo.getRandomName();
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
        String randomName = this.createName();
        int id = this.getMaxId();
        Hero newHero = new Hero(id, randomName, "Avengers", 99);
        System.out.println(newHero);
        return repo.save(newHero);
    }
}
