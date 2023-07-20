package com.example.springdemo.commom;

import org.springframework.beans.factory.annotation.Configurable;


public class SwimCoach  implements Coach{

    public SwimCoach()
    {
        System.out.println("swim class" + getClass().getSimpleName());
    }
    public String getDaily()
    {
        return " swim";
    }

}
