package com.mycompany.springwebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springwebapp.aspect.Login;
import com.mycompany.springwebapp.aspect.RuntimeCheck;
import com.mycompany.springwebapp.dto.Ch13Board;
import com.mycompany.springwebapp.dto.Ch13Pager;
import com.mycompany.springwebapp.service.Ch13BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch15")
public class Ch15Controller{
	@RequestMapping("/content")
	public String content() {
		log.info("실행");
		return "ch15/content";
	}
}
