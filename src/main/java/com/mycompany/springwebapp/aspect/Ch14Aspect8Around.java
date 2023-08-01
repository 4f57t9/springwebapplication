package com.mycompany.springwebapp.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.mycompany.springwebapp.dto.Ch13Member;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class Ch14Aspect8Around {
			// Pointcut 표현식
	@Around("@annotation(com.mycompany.springwebapp.aspect.Login)")
	public Object runtimeCheckAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		// 전처리 공통코드
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = sra.getRequest();
		HttpSession session = request.getSession();
		
		Ch13Member member = (Ch13Member) session.getAttribute("ch13Login");
		
		if(member == null) {
			return "redirect:/ch13/login";
		} else {
			Object result = joinPoint.proceed();
			return result;
		}
	}
}
