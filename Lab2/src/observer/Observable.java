package observer;

import java.util.ArrayList;

public class Observable<T> {

	private ArrayList<Observer> observers = new ArrayList<Observer>();
	
	public void registerObserver(Observer observer) {
		if (observers == null)
        throw new NullPointerException();
		
		if (!observers.contains(observer)) {
			observers.add(observer);
		}
	}

	public void removeObserver(Observer observer) {
		int i = observers.indexOf(observer);
		if (i >= 0) {
			observers.remove(i);
		}
	}

	public void notifyObservers(Event<T> event) {
		for (Observer observer : observers) {
			observer.handleEvent(event);
		}
	}
	
	/**
	 *  Notify all Observers when a new Object created
	 */
	public void notifyAccountCreated(T source) {
		Event<T> event = new Event<T>(source, Operation.CREATE);
		notifyObservers(event);
	}
	
	/**
	 * Notify all Observers when this Object value changes
	 */
	public void notifyAccountChanged(T source) {
		Event<T> event = new Event<T>(source, Operation.UPDATE);
		notifyObservers(event);
	}

}
