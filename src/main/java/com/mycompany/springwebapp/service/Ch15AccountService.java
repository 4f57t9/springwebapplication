package com.mycompany.springwebapp.service;

import java.util.List;

import com.mycompany.springwebapp.dto.Ch15Account;

public interface Ch15AccountService {
	public List<Ch15Account> getAccounts();
	public void transfer(int fromAno, int toAno, int amount);
}
