package com.weather.spring.rest.services;

import com.weather.spring.rest.configuration.Config;
import com.weather.spring.rest.entity.City;
import com.weather.spring.rest.entity.Weather;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@PropertySource("classpath:restURL.properties")
@ContextConfiguration(classes = Config.class)
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
class WeatherServiceTest {

    WeatherService weatherService;

    @Autowired
    public WeatherServiceTest(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Test
    void getWeather() {
        City city = new City("Минск");
        Weather weather = weatherService.getWeather(city);
        assertNotNull(weather);
    }
}