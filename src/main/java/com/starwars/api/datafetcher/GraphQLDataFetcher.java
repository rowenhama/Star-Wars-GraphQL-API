package com.starwars.api.datafetcher;

import com.starwars.api.models.Person;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class GraphQLDataFetcher {

    //fetch data from our already existing REST API (8080 is default port)
    private final String REST_URL = "http://localhost:8080/api/";

    @Autowired
    private RestTemplate restTemplate;

    public graphql.schema.DataFetcher getPersonList() {
        return dataFetchingEnvironment -> {
            return restTemplate
                    .exchange(REST_URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Person>>() {
                    }).getBody();
        };
    }

    public DataFetcher getPersonByName() {
        return dataFetchingEnvironment -> {
            String name = dataFetchingEnvironment.getArgument("name");
            return restTemplate.getForObject(REST_URL + "/" + name, Person.class);
        };
    }
}
