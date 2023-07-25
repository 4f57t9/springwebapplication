package com.mycompany.springwebapp.controller;

import java.io.File;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.springwebapp.dto.Ch09FileUpload;
import com.mycompany.springwebapp.dto.Ch11Member;
import com.mycompany.springwebapp.exception.Ch10SoldOutException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch11")
public class Ch11Controller {
	
	@RequestMapping("/content")
	public String content(HttpSession session) {
		return "ch11/content";
	}
	
	@GetMapping("/form1")
	public String form1(@ModelAttribute("member") Ch11Member member) {
		member.setMid("summer");
		member.setMname("홍길동");
		member.setMpassword("123456789");
		member.setMnation("한국");
		return "ch11/form1";
	}
	
	@PostMapping("/form1")
	public String handleForm1(@ModelAttribute("member") Ch11Member member) {
		log.info(member.toString());
		return "redirect:/ch11/content";
	}
	
	
}
