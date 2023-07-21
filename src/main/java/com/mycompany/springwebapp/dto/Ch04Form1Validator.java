package com.mycompany.springwebapp.dto;


import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch04Form1Validator implements Validator{
   @Override
   public boolean supports(Class<?> clazz) {
      log.info("실행");
      boolean check = Ch04Form1.class.isAssignableFrom(clazz);
      //clazz : b , Ch04Form1.class. : a 
      // b 가 a 타입에 대입될수 있느냐? 는 것을 조사하는것.
      // 만약 A a = new B();,   A a = new C(); 가 있다면 
      // 위는 true , 만약 b 대신 c가 들어가도 true, 
      // 하지만 만약 전혀 관련없는 d가 들어간다면  A 타입에 대입될수없으므로 false 가 된다. 
      // 유효성 검사할수있는 타입이 정해져있는데 내가 유효성 검사를 하려는게 유효성 검사할수있는 타입인지 먼저 확인하는 작업임!!!
      // 이 결과가 true 일 경우에만 아래의 validate 메소드를 실행할거다! 라는 의미! 
      // 반드시 해당 객체 또는 해당 객체의 자식 객체일경우에만 실행을 시킬거다!
      return check;
   }
   
      @Override
      public void validate(Object target, Errors errors) {
         log.info("실행");
         Ch04Form1 ch04Form1 = (Ch04Form1) target;
     
        //param1 검사
        String param1 = ch04Form1.getParam1();
        if(param1 == null || param1.equals("")) {
        	errors.rejectValue("param1", "errors.form1.required", "필수 입력");
        } else if(param1.length() < 8) {                                 //8 이 properties에 integer 값으로 들어간다.
           errors.rejectValue("param1", "errors.form1.minlength",new Object[] {8}, "최소 8자 입력"); 
        } else if(param1.length() > 15) {
           errors.rejectValue("param1", "errors.form1.maxlength",new Object[] {15},"최대 15자 입력");
        }
        
        //param2 검사
        String param2 = ch04Form1.getParam2();
        if(param2 == null || param2.equals("")) {
       errors.rejectValue("param2", "errors.form1.required", "필수 입력");
        } else {
           String regExp = "^(010|011)-[0-9]{3,4}-[0-9]{4}$";
           boolean result = Pattern.matches(regExp, param2);
       if(result == false) {
          errors.rejectValue("param2", "errors.form1.format", "전화번호 형식에 맞지 않음");
           }
        }
        
        //param3 검사
        String param3 = ch04Form1.getParam3();
        if(param3 == null || param3.equals("")) {
       errors.rejectValue("param3", "errors.form1.required", "필수 입력(D)");
        } else {
           String regExp = "^([\\w-]+(?:\\.[\\w-]+)*)@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$";
       boolean result = Pattern.matches(regExp, param3);
       if(result == false) {
          errors.rejectValue("param3", "errors.form1.format", "이메일 형식에 맞지 않음(D)");
           }
       }
   }
}
























