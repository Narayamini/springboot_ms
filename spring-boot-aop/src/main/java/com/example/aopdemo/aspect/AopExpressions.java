package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
//if we only have pointcut expressions in this class then aspect annotation is optional
public class AopExpressions {

    @Pointcut("execution(* com.example.aopdemo.dao.*.*(..))")
    public void daoMethod(){}
    @Pointcut("execution(* com.example.aopdemo.dao.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* com.example.aopdemo.dao.*.set*(..))")
    public void setter(){}

    @Pointcut("daoMethod() && !(getter() || setter())")
    public void includePackageExcludeGetterSetter(){}
}
