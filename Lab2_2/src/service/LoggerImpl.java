package service;

import entity.Account;
import observer.AccountChangedObserver;
import observer.AccountCreatedObserver;
import observer.Event;

public class LoggerImpl implements AccountChangedObserver, AccountCreatedObserver {

	public LoggerImpl() {
		super();
	}

	public void log() {
		System.out.println("Logger log Account changed");
	}

	@Override
	public void accountCreated(Event event) {
		if (event.getSource() instanceof Account){			
			log();
		}
	}

	@Override
	public void accountChanged(Event event) {
		if (event.getSource() instanceof Account){			
			log();
		}
	}

}
