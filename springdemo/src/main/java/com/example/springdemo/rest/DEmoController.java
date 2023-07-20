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
    private Coach mycoach;

//    private Coach anotherCoach;

    //using configuration
    @Autowired
    private DEmoController(@Qualifier("swimCoachyam") Coach coach)
    {
        System.out.println("in constructor  " +getClass().getSimpleName());
        mycoach=coach;
//        anotherCoach=anotherCoach1;

    }

    //Field injection which is not recommended due to unit test case issues, circular dependency problems, null pointer exception can also occur
//    @Autowired
//    private Coach mycoach;


    //constructor injection : highly recommended for all dependencies
//    @Autowired
//    private DEmoController(Coach coach)
//    {
//        mycoach=coach;
//    }



//using qualifier

//    @Autowired
//    private DEmoController(@Qualifier("tennisCoach") Coach coach)
//    {
//        mycoach=coach;
//    }



//using primary- provide primary annotation in one of the implementation class


//example for scope

//    @Autowired
//    private DEmoController(@Qualifier("cricketCoach") Coach coach,
//                           @Qualifier("cricketCoach") Coach anotherCoach1)
//    {
//        System.out.println("in constructor  " +getClass().getSimpleName());
//        mycoach=coach;
//        anotherCoach=anotherCoach1;
//
//    }


//setter injection : recommended if there are optional dependencies and default methods can be provided

//    @Autowired
//    private void setMycoach(CricketCoach coach)
//    {
//        mycoach=coach;
//    }



//to verify scope

//    @GetMapping("/check")
//    public String checking()
//    {
//        return "Companing "+ (mycoach==anotherCoach);
//    }

}

