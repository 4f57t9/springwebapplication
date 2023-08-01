package com.mycompany.springwebapp.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class Ch14Aspect4AfterReturning {
	// controller의 afterThrowing메소드를 실행한 리턴값을 returnValue에 해당되는 매개변수에 넣어 사용한다
	@AfterReturning(
			pointcut="execution(public * com.mycompany.springwebapp.controller.Ch14Controller.afterReturning*(..))",
			returning="returnValue"
	)
	public void method(String returnValue) {
		log.info("실행");
		log.info("리턴값: " + returnValue);
	}
}
