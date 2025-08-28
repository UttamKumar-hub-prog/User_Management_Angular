package com.springboot.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect // we are to spring this extra logic iam writing

@Component // a spring take care of this c;ass (object creation
@Slf4j
public class LoggingAspect {
	
	@Before("execution(* com.springboot.example.controlller.UserController.addUser(..))")
	public  void logBefore(JoinPoint joinPoint)  {
		
		log.error("loging someone before addNewUser Endpoint");
		log.warn("Which method we are callong! {}", joinPoint.getSignature().getName());

		log.error("loging someone before addNewUser Endpoint");

	}

	

}
