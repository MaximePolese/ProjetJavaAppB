package com.example.applicationb;

import java.util.List;

public interface Repo {
    Hero[] findAll();

    Hero save(Hero hero);
}
