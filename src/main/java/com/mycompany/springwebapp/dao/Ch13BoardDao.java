package com.mycompany.springwebapp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mycompany.springwebapp.dto.Ch13Board;
import com.mycompany.springwebapp.dto.Ch13Pager;

@Mapper
public interface Ch13BoardDao {
	// 추상 메소드 선언
	// 메소드 이름이 board.xml의 mapper > insert id랑 같아야 한다
	public int insert(Ch13Board board);
	public List<Ch13Board> selectByPage(Ch13Pager pager);
	public Ch13Board selectByBno(int bno);
	public int updateByBno(Ch13Board board);
	public int deleteByBno(int bno);
	public int count();
}
