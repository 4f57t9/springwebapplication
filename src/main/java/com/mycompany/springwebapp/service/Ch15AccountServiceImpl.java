package com.mycompany.springwebapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.springwebapp.dao.Ch15AccountDao;
import com.mycompany.springwebapp.dto.Ch15Account;
import com.mycompany.springwebapp.exception.Ch15NotFoundAccountException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Ch15AccountServiceImpl implements Ch15AccountService {
	@Autowired
	private Ch15AccountDao accountDao;
	
	@Override
	public List<Ch15Account> getAccounts() {
		List<Ch15Account> list = accountDao.selectAll();
		return list;
	}
	
	@Override
	@Transactional
	public void transfer(int fromAno, int toAno, int amount) {
		// 출금하기
		Ch15Account fromAccount = accountDao.selectByAno(fromAno);
		if(fromAccount == null) {
			throw new Ch15NotFoundAccountException("출금 계좌가 없음");
		} 
		fromAccount.setBalance(fromAccount.getBalance() - amount);
		accountDao.updateBalance(fromAccount); // DML
		
		// 입금하기
		Ch15Account toAccount = accountDao.selectByAno(toAno);
		if(toAccount == null) {
			throw new Ch15NotFoundAccountException("입금 계좌가 없음");
		} 
		toAccount.setBalance(toAccount.getBalance() + amount);
		accountDao.updateBalance(toAccount);
	}
}
