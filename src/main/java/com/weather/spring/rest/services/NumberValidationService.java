package com.weather.spring.rest.services;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.weather.spring.rest.dto.PhoneNumberDto;
import com.weather.spring.rest.exeption_handling.PhoneValidationException;
import org.springframework.stereotype.Service;

@Service
public class NumberValidationService {

    private static final String REGION = "RU";
    private static final String ERROR_MESSAGE = "Number you entered isn't valid";



    public PhoneNumberDto validateNumber(String number){
        number = number.replace(' ', '+');
        boolean isValid = false;
        try {
            PhoneNumberUtil numberUtil = PhoneNumberUtil.getInstance();
            Phonenumber.PhoneNumber phoneNumber = numberUtil.parse(number, REGION);
            isValid = numberUtil.isValidNumber(phoneNumber);
        } catch (NumberParseException e) {
            throw new PhoneValidationException(ERROR_MESSAGE);
        }
        if(!isValid){
            throw new PhoneValidationException(ERROR_MESSAGE);
        }
        return new PhoneNumberDto(number);
    }
}
