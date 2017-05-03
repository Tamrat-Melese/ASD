package dataaccess;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import entity.Account;

public class AccountDAOImpl implements AccountDAO {
	private Map<String, Account> dataMap = new HashMap<>();
		
	@Override
	public void saveAccount(Account account) {
		dataMap.put(account.getAccountNumber(), account);
	}

	@Override
	public void updateAccount(Account account) {
		dataMap.put(account.getAccountNumber(), account);
	}

	@Override
	public Account loadAccount(String accountNumber) {
		return dataMap.get(accountNumber);
	}

	@Override
	public Collection<Account> getAccounts() {
		return dataMap.values();
	}

}
