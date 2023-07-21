package com.mycompany.springwebapp.dto;


import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch04Form2Validator implements Validator{
	
    @Override
    public boolean supports(Class<?> clazz) {
       log.info("실행");
       boolean check = Ch04Form2.class.isAssignableFrom(clazz);
       return check;
    }
   
    @Override
    public void validate(Object target, Errors errors) {
        log.info("실행");
        Ch04Form2 ch04Form2 = (Ch04Form2) target;
        
        //param1 검사
        String param1 = ch04Form2.getParam1();
        if(param1 == null || param1.equals("")) {
        	errors.rejectValue("param1", "errors.form2.required", "필수 입력");
        } else {
        	String regExp = "^[0-9]{6}-[1234][0-9]{6}$";
            boolean result = Pattern.matches(regExp, param1);
	        if(result == false) {
	           errors.rejectValue("param1", "errors.form2.format", "주민번호 형식에 맞지 않음");
            }
        }
        
        // param2 검사
        String param2 = ch04Form2.getParam2();
        if(param2 == null || param2.equals("")) {
        	errors.rejectValue("param2", "errors.form2.required", "필수 입력");
        } else {
        	String regExp = "^(19[0-9][0-9]|20\\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$";
        	boolean result = Pattern.matches(regExp, param2);
        	if(result == false) {
 	            errors.rejectValue("param2", "errors.form2.format", "형식에 맞지 않음");
            }	
        }
        
        // param3 검사
        String param3 = ch04Form2.getParam3();
        if(param3 == null || param3.equals("")) {
        	errors.rejectValue("param3", "errors.form3.required", "필수 입력");
        } else if(param3.length() < 8) {
           errors.rejectValue("param3", "errors.form3.minlength",new Object[] {8}, "최소 8자 입력"); 
        } else if(param3.length() > 15) {
           errors.rejectValue("param3", "errors.form3.maxlength",new Object[] {15},"최대 15자 입력");
        }
    }
}
























