package com.weather.spring.rest.controllers;

import com.weather.spring.rest.entity.DataObject;
import com.weather.spring.rest.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
public class MainController {

    private final MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping(value = "/weather", produces = MediaType.APPLICATION_JSON_VALUE)
    public DataObject weather(@RequestParam String number) {
        return mainService.doJob(number);
    }
}
