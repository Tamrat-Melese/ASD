package service;

import java.util.List;

import dataaccess.AccountDAO;
import entity.Account;
import observer.Observable;

public class AccountServiceImpl extends Observable<Account> implements AccountService {
	
	private AccountDAO accountDAO;
	
	public AccountServiceImpl() {
	}

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	@Override
	public void createAccount(Account account) {
		accountDAO.saveAccount(account);
		notifyAccountCreated(account);
	}

	@Override
	public void deposit(Account account, Double amount) {
		Account loadAccount = accountDAO.loadAccount(account.getAccountNumber());
		addInterest(loadAccount);
		loadAccount.deposit(amount);
		accountDAO.updateAccount(loadAccount);
		notifyAccountChanged(account);
	}

	@Override
	public void withdraw(Account account, Double amount) {
		Account loadAccount = accountDAO.loadAccount(account.getAccountNumber());
		// TODO : withdraw
		accountDAO.updateAccount(loadAccount);
		notifyAccountChanged(account);
	}

	@Override
	public List<Account> getAllAccounts() {
		List<Account> accounts = accountDAO.getAccounts();
		return accounts;
	}

	@Override
	public Account getAccount(String accountNumber) {
		return accountDAO.loadAccount(accountNumber);
	}

	@Override
	public void addInterest(Account account) {
		account.addInterest();
	}

}
