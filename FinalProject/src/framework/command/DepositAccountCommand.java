package framework.command;

import framework.service.AccountService;

public class DepositAccountCommand implements Command {
	private AccountService accountService;
	private String accountNumber;
	private Double amount;

	public DepositAccountCommand(AccountService accountService, String accountNumber, Double amount) {
		this.accountService = accountService;
		this.accountNumber = accountNumber;
		this.amount = amount;
	}
	
	@Override
	public void execute() {
		accountService.deposit(accountNumber, amount);
	}

	@Override
	public void undo() {
		accountService.withdraw(accountNumber, amount);
	}
	
}