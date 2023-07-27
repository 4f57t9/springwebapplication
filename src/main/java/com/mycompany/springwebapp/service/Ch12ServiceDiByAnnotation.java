package com.mycompany.springwebapp.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mycompany.springwebapp.dao.Ch12DaoByAnnotation1;
import com.mycompany.springwebapp.dao.Ch12DaoByAnnotation2;
import com.mycompany.springwebapp.dao.Ch12DaoByAnnotation3;
import com.mycompany.springwebapp.dao.Ch12DaoByXml1;
import com.mycompany.springwebapp.dao.Ch12DaoI;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Ch12ServiceDiByAnnotation {
	// 필드
	@Autowired	
	//@Resource
	private Ch12DaoByAnnotation1 daoAnnotation1;
	
	private Ch12DaoByAnnotation2 daoAnnotation2;
	private Ch12DaoByAnnotation3 daoAnnotation3;
	
	//@Resource(name="ch12DaoImpl1")
	@Autowired @Qualifier("ch12DaoImpl1")
	private Ch12DaoI ch12Dao;
	
	// 생성자
	// 어노테이션으로 객체를 생성할 때는 기본생성자가 있어야 한다.(매개변수가 있는 생성자 X)
	public Ch12ServiceDiByAnnotation() {
		log.info("실행1");
	}
		
	@Autowired
	public Ch12ServiceDiByAnnotation(Ch12DaoByAnnotation1 daoByAnnotation1) {
		log.info("실행2");
		this.daoAnnotation1 = daoByAnnotation1;
	}
	
	// Setter
	public void setCh12DaoByAnnotation1(Ch12DaoByAnnotation1 daoByAnnotation1) {
		log.info("실행");
		this.daoAnnotation1 = daoByAnnotation1;
	}
	
	@Autowired	
	//@Resource
	public void setCh12DaoByAnnotation2(Ch12DaoByAnnotation2 daoByAnnotation2) {
		log.info("실행");
		this.daoAnnotation2 = daoByAnnotation2;
	}
	
	@Autowired	
	//@Resource
	public void setCh12DaoByAnnotation3(Ch12DaoByAnnotation3 daoByAnnotation3) {
		log.info("실행");
		this.daoAnnotation3 = daoByAnnotation3;
	}
	
	// 인스턴스 메소드
	public void method() {
		daoAnnotation1.method();
		daoAnnotation2.method();
		daoAnnotation3.method();
		ch12Dao.method();
	}
}
