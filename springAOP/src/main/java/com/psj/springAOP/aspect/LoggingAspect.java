package com.psj.springAOP.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Logger;

@Aspect
@Component
public class LoggingAspect {
	
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(LoggingAspect.class);
	
	@Around("execution(* com.example.aop.service.UserService.*(..))")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		Object proceed = joinPoint.proceed();
		long executionTime = System.currentTimeMillis() - start;
		logger.info("Method {} executed in {} ms", joinPoint.getSignature(), executionTime);
		return proceed;
	}
	
	

}
