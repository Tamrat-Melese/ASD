package strategy.entity;

public class SavingAccount extends Account {

	public SavingAccount() {
		setInterest(new SavingInterest());
	}

}
