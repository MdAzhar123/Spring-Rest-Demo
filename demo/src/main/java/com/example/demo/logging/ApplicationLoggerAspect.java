package com.example.demo.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
//Instruction that need to be run before or after or around point cuts

@Aspect
public class ApplicationLoggerAspect {

    private  final Logger logger= LoggerFactory.getLogger(this.getClass());

    //location where we code cross cutting concerns(logging,validation,security)
    @Pointcut("within(com.example.demo.controller..*)")

    public void definePackagePointCuts(){

    }


// joint point object give us the ability to access point during the execution of your program
    @Before("definePackagePointCuts()")
    public void log(JoinPoint joinPoint){
        logger.debug("\n \n \n");
        logger.debug("****************************\n {}.{} () with arguments[s]={}",joinPoint.getSignature().getDeclaringTypeName()
        ,joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));

        logger.debug("..........................................");
    }



}
