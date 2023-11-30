package com.example.applicationb;

public interface Repo {
    String getRandomName();

    Hero[] findAll();

    Hero save(Hero hero);
}
