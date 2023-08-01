package com.mycompany.springwebapp.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class Ch14Aspect7Around {
			// Pointcut 표현식
	@Around("@annotation(com.mycompany.springwebapp.aspect.RuntimeCheck)")
	public Object runtimeCheckAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		// 전처리 공통코드
		long start = System.nanoTime();
		
		Object result = joinPoint.proceed();	// 핵심 로직(비즈니스 메소드) : around*(..) 메소드 호출
		
		// 후처리 공통코드
		long end = System.nanoTime();
		long runTime = end - start;
		
		// @RuntimeCheck가 붙어있는 메소드 이름 얻기
		String methodName = joinPoint.getSignature().toShortString();
		log.info(methodName + "실행시간: " + runTime + "ns");
		
		// 실행 시간을 세션에 저장
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = sra.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("methodName", methodName);
		session.setAttribute("runTime", runTime);
		
		return result;
	}
}
