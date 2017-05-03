package application;

import static application.AccountOperation.*;

import dataaccess.AccountDAOImpl;
import entity.Account;
import entity.CheckingAccount;
import entity.SavingAccount;
import service.AccountService;
import service.AccountServiceImpl;

public class Application {
	
	private static AccountServiceImpl ACCOUNT_SERVICE_IMPL = new AccountServiceImpl();
	private static AccountService accountService;
	static {
		ACCOUNT_SERVICE_IMPL.setAccountDAO(new AccountDAOImpl());		
		accountService = ACCOUNT_SERVICE_IMPL;
	}
	
	private static AccountInvoker accountInvoker = new AccountInvoker();
	
	public static void main(String[] args) {
		System.out.println("\n create Account -----------------------------");
		Account account1 = new CheckingAccount();
		account1.setBalance(100000D);
		account1.setAccountNumber("C_0012");
		Command command = new CreateAccountCommand(accountService, account1);
		accountInvoker.setCommand(CREATE, command);
		accountInvoker.runCommand(CREATE);
		printAllAccounts();
		
		System.out.println("\n DEPOSIT Account-----------------------------");
		command = new DepositAccountCommand(accountService, account1, 1400D);
		accountInvoker.setCommand(DEPOSIT, command);
		accountInvoker.runCommand(DEPOSIT);
		
		System.out.println("\n undoDEPOSIT Account-----------------------------");
		accountInvoker.undoCommand();
		printAllAccounts();
		
		System.out.println("\n create Account-----------------------------");
		Account account2 = new SavingAccount();
		account2.setBalance(1500D);
		account2.setAccountNumber("S_7289362");
		command = new CreateAccountCommand(accountService, account2);
		accountInvoker.setCommand(CREATE, command);
		accountInvoker.runCommand(CREATE);
		printAllAccounts();
		
		System.out.println("\n DEPOSIT Account-----------------------------");
		command = new DepositAccountCommand(accountService, account2, 1700D);
		accountInvoker.setCommand(DEPOSIT, command);
		accountInvoker.runCommand(DEPOSIT);

		System.out.println("\n undoDEPOSIT Account-----------------------------");
		accountInvoker.undoCommand();
		System.out.println("\n redoDEPOSIT Account-----------------------------");
		accountInvoker.redoCommand();
		printAllAccounts();
		
		System.out.println("\n WITHDRAW Account-----------------------------");
		command = new WithdrawAccountCommand(accountService, account1, 2000D);
		accountInvoker.setCommand(WITHDRAW, command);
		accountInvoker.runCommand(WITHDRAW);
		
		System.out.println("\n undoWITHDRAW Account-----------------------------");
		accountInvoker.undoCommand();
		System.out.println("\n redoWITHDRAW Account-----------------------------");
		accountInvoker.redoCommand();
		printAllAccounts();
		
		System.out.println("\n TRANSFERFUNDS -----------------------------");
		command = new TransferAccountCommand(accountService, account1, account2, 1000D);
		accountInvoker.setCommand(TRANSFERFUNDS, command);
		accountInvoker.runCommand(TRANSFERFUNDS);
		System.out.println("\n undoTRANSFERFUNDS Account-----------------------------");
		accountInvoker.undoCommand();
		System.out.println("\n redoTRANSFERFUNDS Account-----------------------------");
		accountInvoker.redoCommand();
		printAllAccounts();
	}
	
	public static void printAllAccounts(){
		Command command = new GetAllAccountCommand(accountService);
		accountInvoker.setCommand(GET_ALL_ACCOUNTS, command);
		accountInvoker.runCommand(GET_ALL_ACCOUNTS);
	}

}
