package application;

import entity.Account;
import service.AccountService;

public class WithdrawAccountCommand implements Command {
	private AccountService accountService;
	private Account account;
	private Double amount;

	public WithdrawAccountCommand(AccountService accountService, Account account, Double amount) {
		this.accountService = accountService;
		this.account = account;
		this.amount = amount;
	}
	
	public void execute() {
		accountService.withdraw(account, amount);
	}

	@Override
	public void undo() {
		accountService.deposit(account, amount);
	}
	
}