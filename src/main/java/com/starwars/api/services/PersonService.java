package com.starwars.api.services;

import com.starwars.api.models.Person;

import java.util.List;

public interface PersonService {
    List<Person> getPersons();

    List<Person> searchPersons(String search);
}
