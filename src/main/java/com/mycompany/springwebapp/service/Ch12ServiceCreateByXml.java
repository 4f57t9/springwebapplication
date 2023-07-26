package com.mycompany.springwebapp.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch12ServiceCreateByXml {
	public Ch12ServiceCreateByXml() {
		// 출력이 되면 기본생성자를 통해 객체가 만들어진 것이다.
		log.info("실행");
	}
	
	public static Ch12ServiceCreateByXml getInstance() {
		log.info("실행");
		return new Ch12ServiceCreateByXml();
	}
	
	public Ch12ServiceCreateByXml getSelfObject() {
		log.info("실행");
		return new Ch12ServiceCreateByXml();
	}
	
	public void method() {
		log.info("실행");
	}
}
