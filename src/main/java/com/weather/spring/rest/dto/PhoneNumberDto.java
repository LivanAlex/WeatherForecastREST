package com.weather.spring.rest.dto;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class PhoneNumberDto {
    private String number;

    public PhoneNumberDto(String number) {
        this.number = number;
    }
}