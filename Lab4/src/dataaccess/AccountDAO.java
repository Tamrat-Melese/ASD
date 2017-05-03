package dataaccess;

import java.util.List;

import entity.Account;

public interface AccountDAO {
	
	public void saveAccount(Account account);
	
	public void updateAccount(Account account);
	
	public Account loadAccount(String accountNumber);
	
	public List<Account> getAccounts();
}
