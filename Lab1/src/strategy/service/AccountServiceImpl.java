package strategy.service;

import java.util.List;

import strategy.dataaccess.AccountDAO;
import strategy.entity.Account;

public class AccountServiceImpl implements AccountService {

	private AccountDAO accountDAO;
	
	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	@Override
	public void createAccount(Account account) {
		accountDAO.saveAccount(account);
	}

	@Override
	public void deposit(Account account, Double amount) {
		Account loadAccount = accountDAO.loadAccount(account.getAccountNumber());
		loadAccount.deposit(amount);
		addInterest(loadAccount);
		accountDAO.updateAccount(loadAccount);
	}

	@Override
	public void withdraw(Account account, Double amount) {
		Account loadAccount = accountDAO.loadAccount(account.getAccountNumber());
		// TODO : withdraw
		accountDAO.updateAccount(account);
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
