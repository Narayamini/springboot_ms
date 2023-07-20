package com.example.springdemo.commom;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//for scope prototype
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//by default beans with scope prototype are lazy loaded and destruction callbacks are not executed for them
public class CricketCoach implements Coach {
    public CricketCoach()
    {
        System.out.println("in constructor  " +getClass().getSimpleName());
    }
//the following gets executed during creation of bean
//    @PostConstruct
//    public void preStuff()
//    {
//        System.out.println("preStuff");
//    }
//
//    //the following gets executed during destruction of bean, when application is stopped
//    @PreDestroy
//    public void postStuff()
//    {
//        System.out.println("postStuff");
//    }


    @Override
    public String getDaily()
    {
        return "mycoach !!!";
    }
}
