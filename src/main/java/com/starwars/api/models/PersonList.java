package com.starwars.api.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PersonList {
    private List<Person> results = new ArrayList<Person>(); //copy person to results
}
