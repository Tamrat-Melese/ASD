package proxy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import entity.Account;
import service.AccountService;

public class AccountServiceImpCachigProxy implements AccountService {
	private AccountService accountService;
	private Map<String, Account> accountCachingMap = new HashMap<String, Account>();

	public AccountServiceImpCachigProxy(AccountService accountService) {
		super();
		this.accountService = accountService;
	}

	public Account getAccount(String accountNumber) {
		String key = "getAccount" + accountNumber;
		if(accountCachingMap.containsKey(key)) {
			return accountCachingMap.get(key);
		}
		else {
			Account account =  accountService.getAccount(accountNumber);
			accountCachingMap.put(key, account);
			return account;
		}
	}

	@Override
	public void createAccount(Account account) {
		accountService.createAccount(account);
	}

	@Override
	public void deposit(Account account, Double amount) {
		accountService.deposit(account, amount);
	}

	@Override
	public void withdraw(Account account, Double amount) {
		accountService.withdraw(account, amount);
	}

	@Override
	public void transferFunds(Account source, Account destination, Double amount) {
		accountService.transferFunds(source, destination, amount);
	}

	@Override
	public Collection<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addInterest(Account account) {
		accountService.addInterest(account);
	}

}
