package com.example.applicationb;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class HeroRepoImpl implements Repo {

    public List<Hero> heros = new ArrayList<>();


    @Override
    public List<Hero> findAll() {
        return null;
    }

    @Override
    public Hero findById(int id) {
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
