package com.weather.spring.rest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.weather.spring.rest")
@EnableWebMvc
public class Config {

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
