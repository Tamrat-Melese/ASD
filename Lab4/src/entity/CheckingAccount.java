package entity;

public class CheckingAccount extends Account {

	public CheckingAccount() {
		setInterest(new CheckingInterest());
	}

}
