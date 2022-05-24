package com.weather.spring.rest.services;

import com.weather.spring.rest.configuration.Config;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = Config.class)
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
class SmsServiceTest {

    private SmsService smsService;

    @Autowired
    public SmsServiceTest(SmsService smsService) {
        this.smsService = smsService;
    }

}