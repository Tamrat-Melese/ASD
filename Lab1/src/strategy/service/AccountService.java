package strategy.service;

import java.util.List;

import strategy.entity.Account;

public interface AccountService {
	
	public void createAccount(Account account);
	
	public void deposit(Account account, Double amount);
	
	public void withdraw(Account account, Double amount);
	
	public List<Account> getAllAccounts();
	
	public Account getAccount(String accountNumber);
	
	public void addInterest(Account account);
}
