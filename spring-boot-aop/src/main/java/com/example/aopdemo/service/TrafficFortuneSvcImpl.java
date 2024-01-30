package com.example.aopdemo.service;

import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneSvcImpl implements TrafficFortuneService {
    @Override
    public String getFortune() {

        //simulate a delay
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //return fortune;
        return "Expecting heavy traffic this morning";
    }

    @Override
    public String getFortune(boolean trip) {
        if(trip)
        {
            throw new RuntimeException("Highway is closed");
        }
        return getFortune();

    }
}
