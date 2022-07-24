package com.weather.spring.rest.services;

import com.weather.spring.rest.configuration.Config;
import com.weather.spring.rest.dto.CityDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.weather.spring.rest.dto.PhoneNumberDto;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@PropertySource("classpath:restURL.properties")
@ContextConfiguration(classes = Config.class)
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
class CityServiceTest {

    CityService cityService;

    @Autowired
    public CityServiceTest(CityService cityService) {
        this.cityService = cityService;
    }

    @Test
    void getCity() {
        PhoneNumberDto phoneNumber = new PhoneNumberDto();
        phoneNumber.setNumber("+79681635788");
        CityDto city = cityService.getCity(phoneNumber);
        assertNotNull(city);
        assertEquals("Москва", city.getRegion());
    }

}