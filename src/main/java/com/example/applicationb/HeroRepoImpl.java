package com.example.applicationb;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class HeroRepoImpl implements Repo {
    private final RestTemplate restTemplate;

    public HeroRepoImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public Hero[] findAll() {
        return restTemplate.getForObject("http://localhost:8081/personnages", Hero[].class);
    }

    @Override
    public Hero save(Hero hero) {
        return restTemplate.postForObject("http://localhost:8081/personnages", hero, Hero.class);
    }
}
