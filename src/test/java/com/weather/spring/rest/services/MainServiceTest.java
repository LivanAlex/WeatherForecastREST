package com.weather.spring.rest.services;

import com.weather.spring.rest.dto.PhoneNumberDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@Disabled
class MainServiceTest {

    @InjectMocks
    private MainService mainService;
    @Mock
    private CityService cityService;
    @Mock
    private NumberValidationService numberValidationService;
    @Mock
    private SmsService smsService;
    @Mock
    private WeatherService weatherService;

    @Test
    void someTest(){
        //when
        String number = " 79681635788";
        mainService.doJob(number);
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(numberValidationService).validateNumber(stringArgumentCaptor.capture());
        String capturedString = stringArgumentCaptor.getValue();
        assertEquals(number, capturedString);
        PhoneNumberDto phoneNumber = new PhoneNumberDto("+79681635788");
        Mockito.when(numberValidationService.validateNumber(number)).thenReturn(phoneNumber);
    }



}