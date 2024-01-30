package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class MultiLogAspect {
    @Before("com.example.aopdemo.aspect.AopExpressions.includePackageExcludeGetterSetter()")
    public void checkMultiple()
    {
        System.out.println("\n-------Multiple logging------>>");
    }
}
