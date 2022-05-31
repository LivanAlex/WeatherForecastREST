package com.weather.spring.rest.entity;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Message {
    private Long id;
    private String text;
    private String number;
    private String sendTime;
    private Boolean status;
}
