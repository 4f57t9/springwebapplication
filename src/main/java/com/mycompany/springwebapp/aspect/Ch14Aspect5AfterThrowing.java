package com.mycompany.springwebapp.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class Ch14Aspect5AfterThrowing {
	// controller의 afterThrowing메소드를 실행하다가 예외가 발생한다면 실행된다
	@AfterThrowing(
			pointcut="execution(public * com.mycompany.springwebapp.controller.Ch14Controller.afterThrowing*(..))",
			throwing="e"
	)
	public void method(Throwable e) {
		log.info("실행");
		log.info("예외 메세지: " + e.getMessage());
	}
}
