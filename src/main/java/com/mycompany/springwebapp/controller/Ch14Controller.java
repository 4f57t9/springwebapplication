package com.mycompany.springwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch14")
public class Ch14Controller{
	@RequestMapping("/content")
	public String content() {
		log.info("실행");
		return "ch14/content";
	}
	
	@RequestMapping("/before")
	public String before() {
		log.info("실행");
		return "redirect:/ch14/content";
	}
	
	@RequestMapping("/after")
	public String after() {
		log.info("실행");
		return "redirect:/ch14/content";
	}
	
	@RequestMapping("/afterReturning")
	public String afterReturning() {
		log.info("실행");
		return "redirect:/ch14/content";
	}
	
	@RequestMapping("/afterThrowing")
	public String afterThrowing() {
		log.info("실행");
		boolean result = true;
		if(result) {
			throw new RuntimeException("예외가 발생한 이유");
		}
		return "redirect:/ch14/content";
	}
	
	@RequestMapping("/around")
	public String around() {
		log.info("실행");
		return "redirect:/ch14/content";
	}
}
