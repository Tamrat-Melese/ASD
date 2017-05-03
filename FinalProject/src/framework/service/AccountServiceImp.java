package framework.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import framework.dao.AccountDAO;
import framework.entity.Account;
import framework.entity.AccountEntry;
import framework.visitor.MinimumPaymentVisitor;

public class AccountServiceImp implements AccountService {
	
	private AccountDAO accountDAO;
	
	public AccountServiceImp() {
	}

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	@Override
	public void createAccount(Account account) {
		accountDAO.saveAccount(account);
	}

	@Override
	public void deposit(String accountNumber, Double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.deposit(amount);
		accountDAO.updateAccount(account);
	}

	@Override
	public void withdraw(String accountNumber, Double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.withdraw(amount);
		accountDAO.updateAccount(account);
	}

	@Override
	public void transferFunds(Account source, Account destination, Double amount) {
		withdraw(source.getAccountNumber(), amount);
		deposit(destination.getAccountNumber(), amount);
	}

	@Override
	public Iterator<Account> accountIterator() {
		Collection<Account> accounts = accountDAO.getAccounts();
		return accounts.iterator();
	}

	@Override
	public Account getAccount(String accountNumber) {
		return accountDAO.loadAccount(accountNumber);
	}

	@Override
	public void addInterest() {
		Iterator<Account> accounts = accountIterator();
		while (accounts.hasNext()) {
			Account account = accounts.next();
			account.addInterest();
			accountDAO.updateAccount(account);
		}
		
	}

	@Override
	public List<String> getMonthlyBillingReport() {
		List<String> reports = new ArrayList<String>();
		LocalDate now = LocalDate.now();
		int year = now.minusMonths(1).getYear();
		int previousMonth = now.minusMonths(1).getMonthValue();
		
		Iterator<Account> accounts = accountIterator();
		while (accounts.hasNext()) {
			Account account = accounts.next();
			Double previousBalance = 0.0;
			Double totalCharges = 0.0;
			Double totalCredits = 0.0;
			Double newBalance = 0.0;
			Double minimumPayment = 0.0;
			Double monthlyInterest = 1.0;
			String ccType = "";
			for (AccountEntry accountEntry : account.getAccountEntries()) {
				if (accountEntry.getDate().getMonthValue() <= previousMonth
						&& accountEntry.getDate().getYear() <= year) {
					previousBalance += accountEntry.getAmount();
				}
				if (accountEntry.getDate().getMonthValue() == previousMonth + 1
						&& accountEntry.getDate().getYear() == year) {
					if (accountEntry.getAmount() < 0) {
						totalCharges += accountEntry.getAmount();
					} else {
						totalCredits += accountEntry.getAmount();
					}
				}
			}
			
			MinimumPaymentVisitor mpVisitor = new MinimumPaymentVisitor();
			minimumPayment = mpVisitor.visit(account);

			account.addInterest();
			monthlyInterest = account.getBalance();

			newBalance = previousBalance - totalCredits + totalCharges
					+ monthlyInterest * (previousBalance - totalCredits);

			StringBuilder report = new StringBuilder();
			report.append("Name = " + account.getCustomer().getName() + "\n");
			report.append("Address = " + account.getCustomer().getAddress() + "\n");
			report.append("Account number = " + account.getAccountNumber() + "\n");
			report.append("Type = " + ccType + "\n");
			report.append("Previous Balance = $" + previousBalance + "\n");
			report.append("Total Credits = $" + totalCredits + "\n");
			report.append("Total Charges = $" + totalCharges + "\n");
			report.append("New balance = $" + newBalance + "\n");
			report.append("Total amount due = $" + minimumPayment * newBalance + "\n");
			report.append("\n\n\n");
			
			reports.add(report.toString());

		}
		return reports;
	}

}
