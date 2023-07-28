package com.mycompany.springwebapp.dao;

import java.util.List;

import com.mycompany.springwebapp.dto.Ch13Board;

public interface Ch13BoardDaoOld {
	public int insert(Ch13Board board);
	public List<Ch13Board> selectAll();
	public Ch13Board selectByBno(int bno);
	public int updateByBno(Ch13Board board);
	public int deleteByBno(int bno);
}