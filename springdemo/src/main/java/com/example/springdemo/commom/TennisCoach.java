package com.example.springdemo.commom;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    public TennisCoach()
    {
        System.out.println("in constructor  " +getClass().getSimpleName());
    }

    @Override
        public String getDaily()
        {
            return "mycoach :Tennis !!!";
        }
    }
