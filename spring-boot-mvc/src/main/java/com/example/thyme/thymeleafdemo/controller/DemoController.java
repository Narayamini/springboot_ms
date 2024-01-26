package com.example.thyme.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    //create a mapping for /hello
    @GetMapping("/hello")
    public String myHello(Model model)
    {
        model.addAttribute("theDate",new java.util.Date());
        //we pass the name: theData as attribute and pass the value new java.util.Date()
        return "helloworld";

        //here theDate attribute that is added here will be mapped to the theDate attribute that we have added in thymeleaf template

    }
}
