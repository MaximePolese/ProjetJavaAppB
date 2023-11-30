package com.example.applicationb;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class HeroRepoImpl implements Repo {

    private RestTemplate restTemplate;

    public HeroRepoImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public String getRandomName() {
        String result = restTemplate.getForEntity("https://random-word-api.herokuapp.com/word", String.class).getBody();
        return result.replace("[", "").replace("]", "");
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
