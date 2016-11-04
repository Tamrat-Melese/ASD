package strategy.dataaccess;

import java.util.List;

import strategy.entity.Account;

public interface AccountDAO {
	
	public void saveAccount(Account account);
	
	public void updateAccount(Account account);
	
	public Account loadAccount(String accountNumber);
	
	public List<Account> getAccounts();
}
