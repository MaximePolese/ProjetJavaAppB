package com.example.applicationb;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Repository
public class HeroRepoImpl implements Repo {
    private final RestTemplate restTemplate;

    public HeroRepoImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public ArrayList<Hero> findAll() {
        ArrayList<Hero> result = restTemplate.getForObject("http://localhost:8081/personnages", ArrayList.class);
        return result;
    }

    @Override
    public Hero findById(int id) {
        for (Hero hero : heros) {
            if (hero.getId() == id) {
                return hero;
            }
        }
        return null;
    }

    @Override
    public Hero save(Hero hero) {
        return null;
    }

    @Override
    public void update(Hero hero, int id) {

    }

    @Override
    public void delete(int id) {

    }
}
