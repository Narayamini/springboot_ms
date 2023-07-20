package com.example.springdemo.commom;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
@Component
//@Lazy - lazy annotation for lazy loading
public class BaseBallCoach implements Coach{

    public BaseBallCoach()
    {
        System.out.println("in constructor  " +getClass().getSimpleName());
    }

        @Override
        public String getDaily()
        {
            return "mycoach :BaseBall !!!";
        }
    }


