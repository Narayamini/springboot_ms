package com.dev.devdemo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    @Value("${mate.name}")
    public String mate;
    @GetMapping("/hello")
    public String greeting()
    {
        return "Hello " + mate+ " !!";
    }


}
