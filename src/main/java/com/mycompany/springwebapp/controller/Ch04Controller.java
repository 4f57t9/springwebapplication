package com.mycompany.springwebapp.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springwebapp.dto.Ch04Form1;
import com.mycompany.springwebapp.dto.Ch04Form1Validator;
import com.mycompany.springwebapp.dto.Ch04Form2;
import com.mycompany.springwebapp.dto.Ch04Form2Validator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch04")
public class Ch04Controller {
	
	@RequestMapping("/content")
	public String content() {
		return "ch04/content";
	}
	
	// 데이터를 받을 때 여기 설정되어있는데로 사용
	@InitBinder("ch04Form1")
	public void ch04Form1Validator(WebDataBinder binder) {
		binder.setValidator(new Ch04Form1Validator());
	}
	
	// 데이터를 받을 때 여기 설정되어있는데로 사용
	@InitBinder("ch04Form2")
	public void ch04Form2Validator(WebDataBinder binder) {
		binder.setValidator(new Ch04Form2Validator());
	}
	
	@PostMapping("/method1")
	// pom.xml에 validation-api 라이브러리 의존 설정 필요
	// request.setAttribute("ch04Form1", form1); 로 자동 저장
	public String method1(@Valid Ch04Form1 form1, Errors errors) {
		// errors.rejectValue(...)가 한번이라도 호출되었다면 hasErrors()는 true를 리턴
		if(errors.hasErrors()) {
			return "ch04/content";
		}
		
		// 요청 처리 코드
		log.info("param1: " + form1.getParam1());
		log.info("param2: " + form1.getParam2());
		log.info("param3: " + form1.getParam3());
		log.info("param4: " + form1.isParam4());
		log.info("param5: " + form1.getParam5());
		return "redirect:/";
	}
	
	@PostMapping("/method2")
	public String method2(@Valid Ch04Form2 form2, Errors errors) {
		if(errors.hasErrors()) {
			return "ch04/content";
		}

		log.info("param1: " + form2.getParam1());
		
		return "redirect:/";
	}
}
