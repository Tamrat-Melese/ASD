package application;

import java.util.Collection;

import entity.Account;
import service.AccountService;

public class GetAllAccountCommand implements Command {
	private AccountService accountService;

	public GetAllAccountCommand(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@Override
	public void execute() {
		System.out.println("Account List-----------------------");
		Collection<Account> accounts = accountService.getAllAccounts();
		accounts.stream().forEach(System.out::println);
	}
	
}