package com.weather.spring.rest.services;

import com.weather.spring.rest.entity.City;
import com.weather.spring.rest.entity.Weather;
import com.weather.spring.rest.exeption_handling.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@PropertySource("classpath:restURL.properties")
public class WeatherService {

    private final RestTemplate restTemplate;

    @Value("${weatherURL}")
    private String restWeatherURL;


    @Autowired
    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Weather getWeather(City city) {
        Weather weather = restTemplate.postForObject(restWeatherURL, city, Weather.class);
        if (weather == null) {
            throw new ServiceException("Our service can't find weather by city: " + city.getRegion());
        }
        return weather;
    }
}
