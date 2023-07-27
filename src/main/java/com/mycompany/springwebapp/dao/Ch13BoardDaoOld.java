package com.mycompany.springwebapp.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.springwebapp.dto.Ch13Board;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class Ch13BoardDaoOld {
	@Autowired
	private SqlSessionTemplate sst;
	
	// board.xml 의 namespace(해당xml파일을 얻기 위함)
	public void insert(Ch13Board board) {
		sst.insert("com.mycompany.springwebapp.dao.mybatis.Ch13BoardDao.insert", board);
	}
	
	public List<Ch13Board> selectAll() {
		List<Ch13Board> list =  sst.selectList("com.mycompany.springwebapp.dao.mybatis.Ch13BoardDao.selectAll");
		
		for(Ch13Board board : list) {
			log.info(board.toString());
		}
		return list;
	}
	
	public void updateByBno() {
		List<Ch13Board> list = selectAll();
		Ch13Board board = list.get(0);
		board.setBtitle("변경된 제목");
		board.setBcontent("변경된 내용");
		
		sst.update("com.mycompany.springwebapp.dao.mybatis.Ch13BoardDao.updateByBno", board);
	}
	
	public void deleteByBno() {
		int bno = 0;
		sst.delete("com.mycompany.springwebapp.dao.mybatis.Ch13BoardDao.deleteByBno", bno);
	}
}
