package framework.observer;

import java.util.ArrayList;

public class Observable {

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

	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}

}
