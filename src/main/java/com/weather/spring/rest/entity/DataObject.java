package com.weather.spring.rest.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DataObject {
    private String number;
    private String city;
    private String weather;
    private String message;
}
