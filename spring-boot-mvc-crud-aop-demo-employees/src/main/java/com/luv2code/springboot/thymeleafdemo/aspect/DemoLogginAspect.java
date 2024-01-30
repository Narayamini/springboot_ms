package com.luv2code.springboot.thymeleafdemo.aspect;

import com.mysql.cj.log.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLogginAspect {

    //setup logger
    private Logger logger= Logger.getLogger(getClass().getName());

    //setup pointcut declarations
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void fordaoPackage(){}

    @Pointcut("forControllerPackage() || forServicePackage() || fordaoPackage()")
    private void forAppflow(){}

    @Before("forAppflow()")
    public void before(JoinPoint joinPoint)
    {
        //display method we are calling
        String method = joinPoint.getSignature().toShortString();
        logger.info("-----Method @ Before Advise "+method);
        //display args to themethod
        Object[] args=joinPoint.getArgs();
        for(Object temp : args)
        {
            logger.info("argument "+temp);
        }
    }

    @AfterReturning(pointcut = "forAppflow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result)
    {
        //display method we are calling
        String method = joinPoint.getSignature().toShortString();
        logger.info("-----Method @ After Returning "+method);
        //display args to themethod
        logger.info("result===> "+ result);
    }



}
