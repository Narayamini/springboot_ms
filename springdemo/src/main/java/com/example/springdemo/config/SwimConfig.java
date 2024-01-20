package com.example.springdemo.config;

import com.example.springdemo.commom.Coach;
import com.example.springdemo.commom.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Configuration class to create a swimcoach bean instead of defining swimcoach as a component
@Configuration
public class SwimConfig {

    @Bean("swimCoachyam") // here we are providing the custom bean id
    public Coach swimCoach()
    {
        return new SwimCoach();
    }


}
