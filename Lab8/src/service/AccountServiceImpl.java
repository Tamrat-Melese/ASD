package service;

import java.util.Collection;

import dataaccess.AccountDAO;
import entity.Account;
import entity.CheckingAccount;
import entity.SavingAccount;

public class AccountServiceImpl implements AccountService {
	
	private AccountDAO accountDAO;
	
	public AccountServiceImpl() {
	}

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	@Override
	public void createAccount(Account account) {
		System.out.println("\n createAccount(Account "+ account +")");
		accountDAO.saveAccount(account);
	}

	@Override
	public void deposit(Account account, Double amount) {
		System.out.println("\n deposit(Account "+ account +", amount " + amount +")");
		Account loadAccount = accountDAO.loadAccount(account.getAccountNumber());
		addInterest(loadAccount);
		loadAccount.deposit(amount);
		accountDAO.updateAccount(loadAccount);
	}

	@Override
	public void withdraw(Account account, Double amount) {
		System.out.println("\n withdraw(Account "+ account +", amount " + amount +")");
		Account loadAccount = accountDAO.loadAccount(account.getAccountNumber());
		accountDAO.updateAccount(loadAccount);
	}

	@Override
	public void transferFunds(Account source, Account destination, Double amount) {
		System.out.println("\n transferFunds(Account "+ source +", Account "+ destination +", amount " + amount +")");
		withdraw(source, amount);
		deposit(destination, amount);
	}

	@Override
	public Collection<Account> getAllAccounts() {
		Collection<Account> accounts = accountDAO.getAccounts();
		return accounts;
	}

	@Override
	public Account getAccount(String accountNumber) {
		Account checking = new CheckingAccount("C132326");
		Account savings = new SavingAccount("S43984347");
		
		if("C132326".equals(accountNumber)) {
			return checking;
		}
		else if("S43984347".equals(accountNumber)) {
			return savings;
		}
		else {
			return null;
		}
//		return accountDAO.loadAccount(accountNumber);
	}

	@Override
	public void addInterest(Account account) {
		account.addInterest();
	}

}
