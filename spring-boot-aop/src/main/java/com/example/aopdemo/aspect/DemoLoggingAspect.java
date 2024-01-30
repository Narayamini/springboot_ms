package com.example.aopdemo.aspect;

import com.example.aopdemo.Account;
import com.example.aopdemo.dao.AccountDAO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(3)
public class DemoLoggingAspect {

    //to rethrow the exception to the calling service
    @Around("execution(* com.example.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint)throws  Throwable{
        //print out which method we are advising on
        String method=proceedingJoinPoint.getSignature().toShortString();
        System.out.println("Demo of Around advise of method "+method);
        //get begin timestamp
        long begin = System.currentTimeMillis();
        Object result=null;
        try {
            //executing the method on target method
            result = proceedingJoinPoint.proceed();
        }
        catch(Exception exc)
        {
            System.out.println(exc.getMessage());
            throw exc;
        }
        //get end timestamp
        long end = System.currentTimeMillis();
        //duration
        System.out.println((end-begin)/1000.0 +" is the time taken to execute the program");

        return result;
    }

//    //to handle the exception without passing back the exception to the calling service
//    @Around("execution(* com.example.aopdemo.service.*.getFortune(..))")
//    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint)throws  Throwable{
//        //print out which method we are advising on
//        String method=proceedingJoinPoint.getSignature().toShortString();
//        System.out.println("Demo of Around advise of method "+method);
//        //get begin timestamp
//        long begin = System.currentTimeMillis();
//        Object result=null;
//        try {
//            //executing the method on target method
//            result = proceedingJoinPoint.proceed();
//        }
//        catch(Exception exc)
//        {
//            System.out.println(exc.getMessage());
//            result="Major accident but stay strong";
//        }
//        //get end timestamp
//        long end = System.currentTimeMillis();
//        //duration
//        System.out.println((end-begin)/1000.0 +" is the time taken to execute the program");
//
//        return result;
//    }

//    @Around("execution(* com.example.aopdemo.service.*.getFortune(..))")
//    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint)throws  Throwable{
//        //print out which method we are advising on
//        String method=proceedingJoinPoint.getSignature().toShortString();
//        System.out.println("Demo of Around advise of method "+method);
//        //get begin timestamp
//        long begin = System.currentTimeMillis();
//        //executing the method on target method
//        Object result = proceedingJoinPoint.proceed();
//        //get end timestamp
//        long end = System.currentTimeMillis();
//        //duration
//        System.out.println((end-begin)/1000.0 +" is the time taken to execute the program");
//
//        return result;
//    }

//    @Before("execution(public void addAccount())")
//    public void beforeAddAccount()
//    {
//        System.out.println("\n------------->>");
//    }
//declaring pointcut at once and using it for all
//    @Pointcut("execution(* com.example.aopdemo.dao.*.*(..))")
//    private void daoMethod(){}
//    @Pointcut("execution(* com.example.aopdemo.dao.*.get*(..))")
//    private void getter(){}
//
//    @Pointcut("execution(* com.example.aopdemo.dao.*.set*(..))")
//    private void setter(){}
//
//    @Pointcut("daoMethod() && !(getter() || setter())")
//    private void includePackageExcludeGetterSetter(){}

   @Before("com.example.aopdemo.aspect.AopExpressions.includePackageExcludeGetterSetter()")
    public void beforeAddAccount(JoinPoint theJoinPoint) {
       System.out.println("\n------------->>");

       //display the method signature
       MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
       System.out.println("Method sig " + methodSignature);
       //display method args
       ///get args
       Object[] args = theJoinPoint.getArgs();
       //print args
       for (Object tempArg : args) {
           System.out.println(tempArg);
           if (tempArg instanceof AccountDAO) {
               //downcast and print account stuff
               AccountDAO accountDAO = (AccountDAO) tempArg;
               System.out.println("acct name " + accountDAO.getName());
           }
       }
   }
        //Here the returned result of the method will be stored in result variable
        @AfterReturning(
                pointcut = "execution(* com.example.aopdemo.dao.AccountDAO.findAccounts(..))",
        returning="result")
        public void afterReturningAccount(JoinPoint theJoinPoint, List<Account> result)
        {
            System.out.println("\n------------->>");

            //display the method signature
            MethodSignature methodSignature =  (MethodSignature) theJoinPoint.getSignature();
            System.out.println("Method sig of after returning "+methodSignature);
            String method=theJoinPoint.getSignature().toShortString();
            System.out.println("Method name "+method);
            System.out.println("Result "+result);
            convertAccountNametoUppercase(result);
            System.out.println("Modified result "+result);
            }

            public void convertAccountNametoUppercase(List<Account> accountList)
            {
                for(Account acct: accountList)
                {
                    String x =acct.getName().toUpperCase();
                    acct.setName(x);
                }
            }

    @AfterThrowing(
            pointcut = "execution(* com.example.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing="exc")
    public void afterReturningThrowingAccount(JoinPoint theJoinPoint, Throwable exc)
    {
        System.out.println("\n------------->>");

        //print which method we are advising on
        String method=theJoinPoint.getSignature().toShortString();
        System.out.println("Exec after throwing exception "+method);

        //log the exception
        System.out.println("Exception is "+exc);

    }
    @After("execution(* com.example.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyAccount(JoinPoint theJoinPoint)
    {
        System.out.println("\n------------->>");

        //print which method we are advising on
        String method=theJoinPoint.getSignature().toShortString();
        System.out.println("Exec after finally throwing exception "+method);

    }
//    @Before("includePackageExcludeGetterSetter()")
//    public void checkMultiple()
//    {
//        System.out.println("\n-------Multiple logging------>>");
//    }


}
