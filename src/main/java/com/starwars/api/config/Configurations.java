package com.starwars.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@org.springframework.context.annotation.Configuration
public class Configurations {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
