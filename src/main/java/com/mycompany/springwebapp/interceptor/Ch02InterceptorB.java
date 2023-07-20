package com.mycompany.springwebapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mycompany.springwebapp.interceptor.Auth.Role;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch02InterceptorB implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.info("실행");

		//Step1. 요청 처리 메소드에 @Auth가 있는지 확인
		HandlerMethod hm = (HandlerMethod) handler;
		Auth auth = hm.getMethodAnnotation(Auth.class);

		//Step2. Auth 존재 여부 확인
		if(auth == null) {
			//메소드에 @Auth가 없는 경우
			return true;
		} else {
			//메소드에 @Auth가 있는 경우
			if(auth.value() == Role.ADMIN) {
				//Step3. 로그인 사용자가 관리자 권한 보유 여부 검사
				boolean isAdmin = true;

				if(isAdmin) {
					return true;
				} else {
					log.info("관리자 권한 없음");
					response.sendRedirect(request.getContextPath());
				}
			} else {
				return true;
			}
		}

		return true;
	}
}