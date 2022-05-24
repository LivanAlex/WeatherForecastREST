package com.weather.spring.rest.services;

import com.weather.spring.rest.entity.*;
import com.weather.spring.rest.entity.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {

    private static final String LOW = "low temperature";
    private static final String HIGH = "high temperature";
    private final WeatherService weatherService;
    private final SmsService smsService;
    private final CityService cityService;
    private final NumberValidationService numberValidationService;

    @Autowired
    public MainService(WeatherService weatherService,
                       SmsService smsService,
                       CityService cityService,
                       NumberValidationService numberValidationService) {
        this.weatherService = weatherService;
        this.smsService = smsService;
        this.cityService = cityService;
        this.numberValidationService = numberValidationService;
    }

    public DataObject doJob(String number) {

        PhoneNumber phoneNumber = numberValidationService.validateNumber(number);

        City city = cityService.getCity(phoneNumber);

        Weather weather = weatherService.getWeather(city);

        double temperature = Double.parseDouble(weather.getTemp());
        String message = temperature <= 15.0 ? LOW : HIGH;

        Sms sms = new Sms(number, message);

//        smsService.sendSms(sms);

        DataObject dataObject = new DataObject();
        dataObject.setNumber(phoneNumber.getNumber());
        dataObject.setMessage(message);
        dataObject.setCity(city.getRegion());
        dataObject.setWeather(weather.getTemp());
        return dataObject;
    }




}
