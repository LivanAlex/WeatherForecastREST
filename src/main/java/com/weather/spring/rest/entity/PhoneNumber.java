package com.weather.spring.rest.entity;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class PhoneNumber {
    private String number;

    public PhoneNumber(String number) {
        this.number = number;
    }
}