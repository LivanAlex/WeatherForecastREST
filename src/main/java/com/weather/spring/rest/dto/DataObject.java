package com.weather.spring.rest.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DataObject {
    private String number;
    private String city;
    private String temperature;
    private String message;
}
