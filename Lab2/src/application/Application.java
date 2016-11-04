package application;

import dataaccess.AccountDAOImpl;
import entity.Account;
import entity.CheckingAccount;
import entity.SavingAccount;
import service.AccountService;
import service.AccountServiceImpl;
import service.EmailSenderImpl;
import service.LoggerImpl;
import service.SMSSenderImpl;

public class Application {
	
	private static LoggerImpl logger = new LoggerImpl();
	private static SMSSenderImpl smsSender = new SMSSenderImpl();
	private static EmailSenderImpl emailSender = new EmailSenderImpl();
	
	private static AccountServiceImpl ACCOUNT_SERVICE_IMPL = new AccountServiceImpl();
	
	public static void main(String[] args) {
		ACCOUNT_SERVICE_IMPL.registerObserver(logger);
		ACCOUNT_SERVICE_IMPL.registerObserver(smsSender);
		ACCOUNT_SERVICE_IMPL.registerObserver(emailSender);
		
		
		ACCOUNT_SERVICE_IMPL.setAccountDAO(new AccountDAOImpl());
		AccountService accountService = ACCOUNT_SERVICE_IMPL;
		
		Account account = new CheckingAccount();
		account.setBalance(100000D);
		System.out.println("\nAccount created-----------------------------");
		accountService.createAccount(account);
		
		System.out.println("\nAccount updated-----------------------------");
		accountService.withdraw(account, 2000D);
//		accountService.deposit(account, 2000D);
		
		System.out.println("\nAccount updated-----------------------------");
		accountService.withdraw(account, 2000D);
		
		account = new CheckingAccount();
		account.setBalance(100500D);
		System.out.println("\nAccount created-----------------------------");
		accountService.createAccount(account);
		
		System.out.println("\nAccount updated-----------------------------");
		accountService.withdraw(account, 1700D);
		
		account = new SavingAccount();
		account.setBalance(800D);
		System.out.println("\nAccount created-----------------------------");
		accountService.createAccount(account);
		
		System.out.println("\nAccount updated-----------------------------");
		accountService.withdraw(account, 100D);
	}

}
