package entity;

import java.time.LocalDate;
import java.util.List;

public class Account {

	private String accountNumber;
	
	private Customer customer;
	
	private Double balance;

	private List<AccountEntry> accountEntries;

	private Interest interest;
	
	
	public Account() {
	}

	public void setInterest(Interest interest) {
		this.interest = interest;
	}
	
	public void deposit(Double amount){
		setBalance(balance + amount);
		
		AccountEntry newAccountEntry = new AccountEntry(
				LocalDate.now(), 
				balance, 
				"description", 
				"fromAccountNumber", 
				"fromPersonName"
		);
		accountEntries.add(newAccountEntry);
	}
	
	public void addInterest(){
		interest.addInterest(this);
	}
	
	
	/* 
	 * getters and setters
	 */

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	public List<AccountEntry> getAccountEntries() {
		return accountEntries;
	}

	public void setAccountEntries(List<AccountEntry> accountEntries) {
		this.accountEntries = accountEntries;
	}
}
