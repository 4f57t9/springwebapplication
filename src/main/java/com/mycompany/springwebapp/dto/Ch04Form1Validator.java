package com.mycompany.springwebapp.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch04Form1Validator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		log.info("실행");
		// clazz가 Ch04Form1 클래스에 대입될 수 있는가를 조사
		boolean check = Ch04Form1.class.isAssignableFrom(clazz);
		return check;
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		log.info("실행");

		// 유효성 검사 코드 작성
		Ch04Form1 ch04Form1 = (Ch04Form1) target;
		
		// param1 검사
		if(ch04Form1.getParam1() == null || ch04Form1.getParam1().equals("")) {
			
		}
	}
}
