package com.weather.spring.rest.services;

import com.weather.spring.rest.entity.City;
import com.weather.spring.rest.entity.PhoneNumber;

import com.weather.spring.rest.exeption_handling.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@PropertySource("classpath:restURL.properties")
public class CityService {

    @Value("${cityURL}")
    private String restCityURL;

    private final RestTemplate restTemplate;
    @Autowired
    public CityService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public City getCity(PhoneNumber phoneNumber){
        City city = restTemplate.postForObject(restCityURL, phoneNumber, City.class);
        if(city == null){
            throw new ServiceException("Our service can't find city by this phone number: " + phoneNumber.getNumber());
        }
        return city;
    }
}
