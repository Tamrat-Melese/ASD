package framework.service;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import framework.command.Command;
import framework.command.DepositAccountCommand;
import framework.command.TransferAccountCommand;
import framework.command.WithdrawAccountCommand;
import framework.entity.Account;

public class AccountServiceInvoker implements AccountService {
	
	private AccountService accountService;
	private Stack<Command> undoCommands = new Stack<>();
	private Stack<Command> redoCommands = new Stack<>();
	
	public AccountServiceInvoker(AccountService accountService) {
		this.accountService = accountService;
	}
	  
	public void setCommand(Command command) {
		//commands.put(operation, command);
	}
	 
	public void runCommand(Command command) {
		command.execute();
		undoCommands.push(command);
	}
	 
	public void undoCommand() {
		Command undoCommand = undoCommands.pop();
		undoCommand.undo();
		redoCommands.push(undoCommand);
	}

	@Override
	public void createAccount(Account account) {
		accountService.createAccount(account);
	}

	@Override
	public void deposit(String accountNumber, Double amount) {
		Command command = new DepositAccountCommand(accountService, accountNumber, amount);
		runCommand(command);
	}

	@Override
	public void withdraw(String accountNumber, Double amount) {
		Command command = new WithdrawAccountCommand(accountService, accountNumber, amount);
		runCommand(command);
	}

	@Override
	public void transferFunds(Account source, Account destination, Double amount) {
		Command command = new TransferAccountCommand(accountService, source, destination, amount);
		runCommand(command);
	}

	@Override
	public Iterator<Account> accountIterator() {
		return accountService.accountIterator();
	}

	@Override
	public Account getAccount(String accountNumber) {
		return accountService.getAccount(accountNumber);
	}

	@Override
	public void addInterest() {
		accountService.addInterest();
	}
	
	@Override
	public List<String> getMonthlyBillingReport() {
		return accountService.getMonthlyBillingReport();
	}

}
