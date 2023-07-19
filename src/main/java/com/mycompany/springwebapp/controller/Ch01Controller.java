package com.mycompany.springwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch01")
public class Ch01Controller {
	@RequestMapping("/content")
	public String content() {
		log.info("실행1");
		return "ch01/content";
	}
	
	@RequestMapping("/button1")
	public String button1() {
		log.info("실행1");
		return "ch01/content";
	}
	
	@RequestMapping("/button2")
	public String button2() {
		log.info("실행1");
		return "redirect:/ch01/content";
	}
}
