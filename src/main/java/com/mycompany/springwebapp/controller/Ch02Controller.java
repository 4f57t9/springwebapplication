package com.mycompany.springwebapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.springwebapp.dto.Ch02Dto;
import com.mycompany.springwebapp.dto.Ch02FileInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch02")
public class Ch02Controller {
	
	@RequestMapping("/content")
	public String content() {
		return "ch02/content";
	}
	
	//@GetMapping("/method")
	@RequestMapping(value="/method", method=RequestMethod.GET)
	public String getMethod(String bkind, int bno) {
		log.info("getMethod > bkind : " + bkind + " |  bno : " + bno);
		return "ch02/content";
	}
	
	//@PostMapping("/method")
	@RequestMapping(value="/method", method=RequestMethod.POST)
	public String postMethod(String bkind, int bno) {
		log.info("postMethod > bkind : " + bkind + " |  bno : " + bno);
		return "ch02/content";
	}
	
	
	@RequestMapping(value="/method", method=RequestMethod.PUT)
	//@PutMapping("/method")
	public void putMethod(@RequestBody Ch02Dto dto, HttpServletResponse response) throws IOException {
		log.info("bkind : " + dto.getBkind());
		log.info("bno : " +dto.getBno());
		
		JSONObject root = new JSONObject();
		root.put("result", "success");
		String responseJson = root.toString();
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.print(responseJson);
		pw.flush();
		pw.close();
	}
	
	//@RequestMapping(value="/method", method=RequestMethod.DELETE)
	@DeleteMapping("/method")
	public void deleteMethod(@RequestBody String json, HttpServletResponse response) throws IOException {
		log.info("deleteMethod > " + json);
		
		JSONObject root = new JSONObject();
		root.put("result", "success");
		String responseJson = root.toString();
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.print(responseJson);
		pw.flush();
		pw.close();
	}
	
	
	@GetMapping("/ajax1")
	public String ajax1Method() {
		return "ch02/fragmentHtml";
	}
	
	@GetMapping("/ajax2")
	public void ajax2Method(HttpServletResponse response) throws IOException {
		JSONObject root = new JSONObject();
		root.put("fileName", "photo3.jpg");
		String responseJson = root.toString();
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.print(responseJson);
		pw.flush();
		pw.close();
	}
	
	@GetMapping(value="/ajax3", produces="application/json; charset=UTF-8")
	@ResponseBody	// 리턴 값을 응답 본문에 기입
	public String ajax3Method() {
		return new JSONObject().put("fileName", "photo4.jpg").toString();
	}
	
	@GetMapping(value="/ajax4", produces="application/json; charset=UTF-8")
	@ResponseBody	// 리턴 값을 응답 본문에 기입, jackson-databind 라이브러리 필수
	public Ch02FileInfo ajax4Method() {
		Ch02FileInfo fileinfo = new Ch02FileInfo();
		fileinfo.setFileName("photo5.jpg");
		return fileinfo;
	}
	
	@RequestMapping("/filterAndInterceptor")
	public String adminMethod() {
		log.info("실행");
		return "ch02/content";
	}
	
}
