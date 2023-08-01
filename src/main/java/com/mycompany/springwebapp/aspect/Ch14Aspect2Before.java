package com.mycompany.springwebapp.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Order(1)
@Slf4j
public class Ch14Aspect2Before {
	@Before("execution(public *  com.mycompany.springwebapp.controller.Ch14Controller.before*(..))")
	public void method() {
		log.info("실행");
	}
}
