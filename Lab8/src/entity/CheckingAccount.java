package entity;

public class CheckingAccount extends Account {

	public CheckingAccount(String string) {
		setInterest(new CheckingInterest());
	}

}
