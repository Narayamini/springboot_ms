package com.example.springdemo.rest;

import com.example.springdemo.commom.Coach;
import com.example.springdemo.commom.CricketCoach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DEmoController {
     //    @Autowired
    //defining a private field for dependency injection
    private Coach mycoach;

    //defining a constructor for constructor injection
    //Dependency Injection

    //----------------Constructor Injection---------------------------------
    @Autowired
    private DEmoController(@Qualifier("swimCoachyam") Coach coach)
    {
        System.out.println("in constructor  " +getClass().getSimpleName());
        mycoach=coach;

    }
    /*
---------------------------Setter Injection---------------------------------
setter injection : recommended if there are optional dependencies and default methods can be provided

    @Autowired
    private void setMycoach(Coach coach)
    {
        mycoach=coach;
    }
----------------------------Field Injection----------------------------------
    Field injection which is not recommended due to unit test case issues, circular dependency problems, null pointer exception can also occur
    @Autowired
    private Coach mycoach;

----------------------------Constructor Injection------------------------------
    constructor injection : highly recommended for all dependencies
    @Autowired
    private DEmoController(Coach coach)
    {
        mycoach=coach;
    }

-----------------------------USING QUALIFIER-----------------------------------
    @Autowired
    private DEmoController(@Qualifier("tennisCoach") Coach coach)
    {
        mycoach=coach;
    }


----------------------------- PRIMARY  -----------------------------------
using primary- provide primary annotation in one of the implementation class

---------------------------- EXAMPLE FOR BEAN SCOPE ----------------------------------------------------

    Bean Scope: SINGLETON
    private Coach mycoach;
    private Coach anotherCoach; //using configuration
    private DEmoController(@Qualifier("swimCoachyam") Coach coach,@Qualifier("swimCoachyam") Coach anotherCoach)
    {
        System.out.println("in constructor  " +getClass().getSimpleName());
        mycoach=coach;
        anotherCoach=anotherCoachh;
        here both mycoach and anotherCoach refer to same SwimCoach instance in container as by default scope of bean is singleton
    }

    Bean Scope: PROTOTYPE

    @Autowired
    private DEmoController(@Qualifier("cricketCoach") Coach coach,
                           @Qualifier("cricketCoach") Coach anotherCoach1)
    {
        System.out.println("in constructor  " +getClass().getSimpleName());
        mycoach=coach;
        anotherCoach=anotherCoach1;
        here both mycoach and anotherCoach refer to different cricketcoach instance in container

    }

--------------------------To verify scope------------------------------------

    @GetMapping("/check")
    public String checking()
    {
        return "Companing "+ (mycoach==anotherCoach);
    }

     */

}

