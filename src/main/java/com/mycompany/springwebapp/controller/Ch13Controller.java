package com.mycompany.springwebapp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springwebapp.dao.Ch13BoardDao;
import com.mycompany.springwebapp.dao.Ch13BoardDaoOld;
import com.mycompany.springwebapp.dao.Ch13BoardDaoOldImpl;
import com.mycompany.springwebapp.dto.Ch13Board;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch13")
public class Ch13Controller {
	@Resource
	private Ch13BoardDaoOld boardDaoOld;
	
	@Autowired
	private Ch13BoardDao boardDao;
	
	@RequestMapping("/content")
	public String content() {
		return "ch13/content";
	}
	
	@GetMapping("/insertBoard")
	public String insertBoard() {
		log.info("실행");
		
		Ch13Board board = new Ch13Board();
		board.setBtitle("아");
		board.setBcontent("피곤하다");
		board.setMid("user");
		
		// boardDaoOld.insert(board);
		boardDao.insert(board);
		
		// 실제로 저장된bno : 
		log.info("");
		return "redirect:/ch13/content";
	}
	
	@GetMapping("/getBoardList")
	public String getBoardList() {
		// List<Ch13Board> list = boardDaoOld.selectAll();
		List<Ch13Board> list = boardDao.selectAll();
		log.info(list.toString());
		return "redirect:/ch13/content";
	}
	
	@GetMapping("/updateBoard")
	public String updateBoard() {
		// Ch13Board board = boardDaoOld.selectByBno(1);
		Ch13Board board = boardDao.selectByBno(1);
		board.setBtitle("ㄹㅇ");
		board.setBcontent("ㅋㅋ");
		
		boardDaoOld.updateByBno(board);
		return "redirect:/ch13/content";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard() {
		int bno = 1;
		// boardDaoOld.deleteByBno(bno);
		boardDao.deleteByBno(bno);
		return "redirect:/ch13/content";
	}
	
}
