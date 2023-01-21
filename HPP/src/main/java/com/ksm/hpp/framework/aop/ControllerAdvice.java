package com.ksm.hpp.framework.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
* @파일명: ControllerAdvice.java
* @패키지: com.ksm.hpp.framework.aop
* @작성자: KimSangMin
* @생성일: 2023. 1. 20. 오후 2:46:47
* @설명: 컨트롤러 관련 aop
 */
@Component//자동으로 Bean 등록
@Aspect
public class ControllerAdvice {
	
	@Around("execution(* com.ksm.hpp.controller..*Controller.*(..))")
	public Object around(ProceedingJoinPoint joinpoint) throws Throwable {
		long start = System.currentTimeMillis();
		try {
			return joinpoint.proceed();//타겟메서드 실행
		} finally {
			long result = System.currentTimeMillis() - start;
			System.out.println("########################## running time is " + result);
		}
	}
}
