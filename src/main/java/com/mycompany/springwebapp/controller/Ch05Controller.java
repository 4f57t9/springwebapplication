package com.mycompany.springwebapp.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch05")
public class Ch05Controller {
	
	@RequestMapping("/content")
	public String content() {
		return "ch05/content";
	}
	
	// 요청 헤더값 얻기
	@GetMapping("/getHeaderValue")
	public String getHeaderValue(@RequestHeader("User-Agent") String userAgent,
								HttpServletRequest request) {
		log.info("실행");
		log.info("User-Agent: " + userAgent);
		log.info("Client IP: " + request.getRemoteAddr());
		return "redirect:/ch05/content";
	}
	
	// 쿠키 생성
	// 단순한 정보를 저장했다가 서버가 사용하기 위해 생성
	@RequestMapping(value="/createCookie", method=RequestMethod.GET)
	public String createCookie(HttpServletResponse response) {
		log.info("실행");
		
		Cookie cookie = new Cookie("usermail", "summer@mycompany.com");
		cookie.setDomain("com.mycompany");	// 쿠키를 재전송할 서버를 지정
		cookie.setPath("/");				// 쿠키를 재전송할 경로를 지정
		cookie.setMaxAge(30*60);			// 쿠키의 저장 기간(단위 초), 시간을 지정안할 경우: 브라우저 메모리 저장
		cookie.setHttpOnly(false);			// true : 서버만 이용, false : JavaScirpt에서 접근 허용
		cookie.setSecure(false);			// false : http, https 모두 쿠키를 사용, true : https만 사용
		response.addCookie(cookie);			// 응답에 쿠키 설정
		
		return "redirect:/ch05/content";
	}
	
	// 쿠키 얻기
	@RequestMapping(value="/getCookie", method=RequestMethod.GET)
	public String getCookie(@CookieValue("usermail") String userEmail) {
		log.info("실행");
		log.info("usermail: " + userEmail);
		return "redirect:/ch05/content";
	}
}
