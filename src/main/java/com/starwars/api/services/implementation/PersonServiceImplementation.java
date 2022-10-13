package com.starwars.api.services.implementation;

import com.starwars.api.models.Person;
import com.starwars.api.models.PersonList;
import com.starwars.api.services.PersonService;
import com.starwars.api.utils.StarWarsConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PersonServiceImplementation implements PersonService {
    private static final Logger log = LoggerFactory.getLogger(PersonServiceImplementation.class);

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Person> getPersons() {
        log.info("get all people: {}");
        PersonList response = null;
        try {
            response = restTemplate.getForObject(StarWarsConstants.url_all_people, PersonList.class);
            if(response!=null) {
                return response.getResults();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Person> searchPersons(String search) {
        log.info("get 1 person: {}", search);
        PersonList response = null;
        String url = StarWarsConstants.url_search + search;
        try {
            RestTemplate restTemplate = new RestTemplate();
            response = restTemplate.getForObject(url, PersonList.class);
            if(response!= null) {
                return response.getResults();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
