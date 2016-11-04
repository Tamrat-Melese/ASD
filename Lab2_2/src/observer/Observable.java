package observer;

import java.util.ArrayList;

public class Observable {

	private ArrayList<Observer> observers = new ArrayList<Observer>();
	
	public void registerAccountCreatedObserver(AccountCreatedObserver observer) {
		if (observers == null)
        throw new NullPointerException();
		
		if (!observers.contains(observer)) {
			observers.add(observer);
		}
	}

	public void removeAccountCreatedObserver(AccountCreatedObserver observer) {
		int i = observers.indexOf(observer);
		if (i >= 0) {
			observers.remove(i);
		}
	}
	
	public void registerAccountChangedObserver(AccountChangedObserver observer) {
		if (observers == null)
        throw new NullPointerException();
		
		if (!observers.contains(observer)) {
			observers.add(observer);
		}
	}

	public void removeAccountChangedObserver(AccountChangedObserver observer) {
		int i = observers.indexOf(observer);
		if (i >= 0) {
			observers.remove(i);
		}
	}
	
	/**
	 * Notify all Observers when a new Object created
	 */
	public void notifyAccountCreated(Object object) {
		Event event = new Event(object, Operation.CREATE);
		for (Observer observer : observers) {
			 if (observer instanceof AccountCreatedObserver ) {
				 AccountCreatedObserver createdObserver = (AccountCreatedObserver) observer;
				 createdObserver.accountCreated(event);
			 }
		}
	}
	
	/**
	 * Notify all Observers when this Object value changes
	 */
	public void notifyAccountChanged(Object object) {
		Event event = new Event(object, Operation.UPDATE);
		for (Observer observer : observers) {
			 if (observer instanceof AccountChangedObserver ) {
				 AccountChangedObserver changedObserver = (AccountChangedObserver) observer;
				 changedObserver.accountChanged(event);
			 }
		}
	}

}
