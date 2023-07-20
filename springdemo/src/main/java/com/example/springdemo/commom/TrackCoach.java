package com.example.springdemo.commom;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary //incase @primary feature is being used
public class TrackCoach implements Coach{

    public TrackCoach()
    {
        System.out.println("in constructor  " +getClass().getSimpleName());
    }
        @Override
        public String getDaily()
        {
            return "mycoach :Track !!!";
        }
    }
