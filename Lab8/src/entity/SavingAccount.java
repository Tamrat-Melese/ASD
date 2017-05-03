package entity;

public class SavingAccount extends Account {

	public SavingAccount(String string) {
		setInterest(new SavingInterest());
	}

}
