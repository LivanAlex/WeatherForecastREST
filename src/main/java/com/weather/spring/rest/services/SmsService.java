package com.weather.spring.rest.services;

import com.weather.spring.rest.entity.Sms;
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

    public boolean sendSms(Sms sms){
        Boolean isSend = restTemplate.postForObject(restSmsURL, sms, Boolean.class);
        if(isSend == null || Boolean.FALSE.equals(isSend)){
            throw new ServiceException("Our service can't send message to this phone number: " + sms.getPhoneNumber());
        }
        return false;
    }
}
