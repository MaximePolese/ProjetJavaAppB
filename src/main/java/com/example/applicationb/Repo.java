package com.example.applicationb;

import java.util.List;

public interface Repo {
    List<Hero> findAll();

    Hero findById(int id);

    Hero save(Hero hero);

    void update(Hero hero, int id);

    void delete(int id);
}
