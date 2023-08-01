package com.mycompany.springwebapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.springwebapp.dto.Ch15Account;

@Mapper
public interface Ch15AccountDao {
	public List<Ch15Account> selectAll();
	public Ch15Account selectByAno(int ano);
	public int updateBalance(Ch15Account account);
}
