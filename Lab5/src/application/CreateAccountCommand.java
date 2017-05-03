package application;

import entity.Account;
import service.AccountService;

public class CreateAccountCommand implements Command {
	private AccountService accountService;
	private Account account;

	public CreateAccountCommand(AccountService accountService, Account account) {
		this.accountService = accountService;
		this.account = account;
	}
	
	public void execute() {
		accountService.createAccount(account);
	}

	@Override
	public void undo() {
		// delete
		accountService.createAccount(account);
	}
	
}