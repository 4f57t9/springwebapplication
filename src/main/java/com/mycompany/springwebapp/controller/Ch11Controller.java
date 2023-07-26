package com.mycompany.springwebapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springwebapp.dto.Ch11City;
import com.mycompany.springwebapp.dto.Ch11Member;
import com.mycompany.springwebapp.dto.Ch11Skill;

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
	
	@GetMapping("/form2")
	public String form2(@ModelAttribute("member") Ch11Member member, Model model) {
		// 드롭다운리스트(<select>의 항목을 추가할 목족)
		List<String> typeList = new ArrayList<>();
		typeList.add("일반회원");
		typeList.add("기업회원");
		typeList.add("헤드헌터회원");
		model.addAttribute("typeList", typeList);
		// 기본값을 설정
		member.setMtype("헤드헌터회원");
		
		List<String> jobList = new ArrayList<>();
		jobList.add("학생");
		jobList.add("개발자");
		jobList.add("디자이너");
		model.addAttribute("jobList", jobList);
		
		List<Ch11City> cityList = new ArrayList<>();
		cityList.add(new Ch11City(1, "서울"));
		cityList.add(new Ch11City(2, "부산"));
		cityList.add(new Ch11City(3, "제주"));
		model.addAttribute("cityList", cityList);
		member.setMcity(3);
		
		return "ch11/form2";
	}
	
	
	@PostMapping("/form2") //form을 제공  get과 post는 한쌍이고 경로가 같다 저장 이름이 같고 dto가 같다 
	public String form2(@ModelAttribute("member") Ch11Member member) {
		log.info(member.toString());
		return "ch11/form2";
    }  
	
	@GetMapping("/form3")
	public String form3(@ModelAttribute("member") Ch11Member member, Model model) {
		List<String> languageList = new ArrayList<>();
		languageList.add("C");
		languageList.add("Python");
		languageList.add("Java");
		languageList.add("JavaScript");
		languageList.add("HTML");
		model.addAttribute("languageList", languageList);
		member.setMlanguage(new String[] {"Java", "JavaScript", "HTML"});
		
		List<Ch11Skill> skillList = new ArrayList<>();
		skillList.add(new Ch11Skill(1, "SpringFramework"));
		skillList.add(new Ch11Skill(2, "Bootstrap"));
		skillList.add(new Ch11Skill(3, "MyBatis"));
		model.addAttribute("skillList", skillList);
		member.setMskill(new int[] {1, 2});
		
		return "ch11/form3";
	}
	
	@PostMapping("/form3")
	public String form3(@ModelAttribute("member") Ch11Member member) {
		log.info(member.toString());
		return "redirect:/ch11/content";
    }  
	
	@GetMapping("/form4")
	public String form4(@ModelAttribute("member") Ch11Member member, Model model) {
		List<String> jobList = new ArrayList<>();
		jobList.add("학생");
		jobList.add("개발자");
		jobList.add("디자이너");
		model.addAttribute("jobList", jobList);
		member.setMjob("학생");
		
		List<Ch11City> cityList = new ArrayList<>();
		cityList.add(new Ch11City(1, "서울"));
		cityList.add(new Ch11City(2, "부산"));
		cityList.add(new Ch11City(3, "제주"));
		model.addAttribute("cityList", cityList);
		member.setMcity(1);
		
		return "ch11/form4";
	}
	
	@PostMapping("/form4")
	public String form4(@ModelAttribute("member") Ch11Member member) {
		log.info(member.toString());
		return "redirect:/ch11/content";
    }  
	
	@GetMapping("/form5")
	public String form5(@ModelAttribute("member") Ch11Member member, Model model) {
		return "ch11/form5";
    } 
}
