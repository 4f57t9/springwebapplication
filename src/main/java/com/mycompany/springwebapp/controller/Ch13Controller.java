package com.mycompany.springwebapp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springwebapp.dto.Ch13Board;
import com.mycompany.springwebapp.dto.Ch13Pager;
import com.mycompany.springwebapp.service.Ch13BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch13")
public class Ch13Controller {
	@Resource
	private Ch13BoardService boardService;
	
	@RequestMapping("/content")
	public String content() {
		return "ch13/content";
	}
	
	@GetMapping("/insertBoard")
	public String insertBoard() {
		log.info("실행");
		
		Ch13Board board = new Ch13Board();
		board.setBtitle("제목");
		board.setBcontent("내용");
		board.setMid("user");
		
		// boardDaoOld.insert(board);
		boardService.write(board);
		
		// 실제로 저장된bno
		log.info("저장된 bno: " + board.getBno());
		return "redirect:/ch13/content";
	}
	
	@GetMapping("/getBoardList")
	public String getBoardList() {
		int totalBoardNum = boardService.getTotalBoardNum();
		Ch13Pager pager = new Ch13Pager(10, 5, totalBoardNum, 1);
		
		List<Ch13Board> list = boardService.getList(pager);
		for(Ch13Board board : list) {
			log.info(board.toString());			
		}
		
		return "redirect:/ch13/content";
	}
	
	@GetMapping("/updateBoard")
	public String updateBoard() {
		Ch13Board board = boardService.getBoard(10001);
		board.setBtitle("ㄹㅇ");
		board.setBcontent("ㅋㅋ");
		
		boardService.modify(board);
		return "redirect:/ch13/content";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard() {
		int bno = 10001;
		boardService.remove(bno);
		return "redirect:/ch13/content";
	}
	
}
