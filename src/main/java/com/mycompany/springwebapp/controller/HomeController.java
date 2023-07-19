package com.mycompany.springwebapp.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController{
	
	public HomeController() {
		log.info("HomeController 생성자 실행");
	}
	
	@PostConstruct
	public void homeMethod1() {
		log.info("homeMethod1() 실행");
	}
	
	@PostConstruct
	public void homeMethod2() {
		log.info("homeMethod2() 실행");
	}
	
	@PreDestroy
	public void homeMethod3() {
		log.info("homeMethod3() 실행");
	}
	
	@RequestMapping("/")	// http://localhost:8080/sptringwebapp/ 요청 시, HomeController.index() 실행 설정
	public String index() {
		return "home";
	}
}
