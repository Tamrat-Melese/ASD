package application;

import entity.Account;
import service.AccountService;

public class DepositAccountCommand implements Command {
	private AccountService accountService;
	private Account account;
	private Double amount;

	public DepositAccountCommand(AccountService accountService, Account account, Double amount) {
		this.accountService = accountService;
		this.account = account;
		this.amount = amount;
	}
	
	@Override
	public void execute() {
		accountService.deposit(account, amount);
	}

	@Override
	public void undo() {
		accountService.withdraw(account, amount);
	}
	
}