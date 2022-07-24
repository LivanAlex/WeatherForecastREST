package com.weather.spring.rest.services;

import com.weather.spring.rest.configuration.Config;
import com.weather.spring.rest.dto.PhoneNumberDto;
import com.weather.spring.rest.exeption_handling.PhoneValidationException;
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
class NumberValidationServiceTest {

    NumberValidationService numberValidationService;

    @Autowired
    public NumberValidationServiceTest(NumberValidationService numberValidationService) {
        this.numberValidationService = numberValidationService;
    }

    @Test
    void itShouldReplaceSpaseByPlus(){
        // given
        String numberWithSpase = " 79681635788";
        // when
        PhoneNumberDto phoneNumber = numberValidationService.validateNumber(numberWithSpase);
        // then
        assertEquals("+79681635788", phoneNumber.getNumber());
    }

    @Test
    void itShouldNotChangeNumber(){
        // given
        String validNumber = "+79681635788";
        // when
        PhoneNumberDto phoneNumber = numberValidationService.validateNumber(validNumber);
        // then
        assertEquals("+79681635788", phoneNumber.getNumber());
    }

    @Test
    void itShouldThrowException(){
        // given
        String notValidNumber = "+796816357888";
        PhoneValidationException thrown = assertThrows(
                PhoneValidationException.class, () -> {
                    numberValidationService.validateNumber(notValidNumber);
                }

        );
        assertEquals("Number you entered isn't valid", thrown.getMessage());

    }



}