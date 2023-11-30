package com.example.applicationb;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class HeroRepoImpl implements Repo {

    private final RestTemplate restTemplate;

    public HeroRepoImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String getRandomName() {
        RestTemplate rt = new RestTemplate();
        return rt.getForEntity("https://random-word-api.herokuapp.com/word", Object.class).getBody().toString().replace("[", "").replace("]", "");
    }

    @Override
    public Hero[] findAll() {
        return restTemplate.getForObject("http://projetJava2/personnages", Hero[].class);
    }

    @Override
    public Hero save(Hero hero) {
        return restTemplate.postForObject("http://projetJava2/personnages", hero, Hero.class);
    }
}
