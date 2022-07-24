package com.weather.spring.rest.services;

import com.weather.spring.rest.dto.MessageDto;
import com.weather.spring.rest.exeption_handling.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@PropertySource("classpath:restURL.properties")
public class SmsService {

    @Value("${smsURL}")
    private String restSmsURL;

    private final RestTemplate restTemplate;

    @Autowired
    public SmsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean sendSms(MessageDto message){
        Boolean isSend = restTemplate.postForObject(restSmsURL, message, Boolean.class);
        if(isSend == null || Boolean.FALSE.equals(isSend)){
            throw new ServiceException("Our service can't send message to this phone number: " + message.getNumber());
        }
        return false;
    }
}
