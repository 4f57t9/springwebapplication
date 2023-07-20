package com.mycompany.springwebapp.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface Auth {
	public enum Role {USER, ADMIN};
	public Role value() default Role.USER;
}

/*
 @Retention 어노테이션을 언제 실행 시킬 것인가 RUNTIME 이므로 웹앱프로그램이 실행 중일 때 실행
 @Target 어노테이션 적용범위 설정 TYPE은 클래스이고, METHOD 메소드이다.  
 * */