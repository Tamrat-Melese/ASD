package dataaccess;

import java.util.Collection;

import entity.Account;

public interface AccountDAO {
	
	public void saveAccount(Account account);
	
	public void updateAccount(Account account);
	
	public Account loadAccount(String accountNumber);
	
	public Collection<Account> getAccounts();
}
