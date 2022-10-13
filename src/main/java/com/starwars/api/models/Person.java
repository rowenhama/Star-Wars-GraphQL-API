package com.starwars.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {
    private String name;
    private String height;
    private String mass;
    private String gender;
    private String homeworld;
}
