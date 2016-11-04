package service;

import entity.Account;
import observer.AccountChangedObserver;
import observer.AccountCreatedObserver;
import observer.Event;

public class SMSSenderImpl implements AccountChangedObserver, AccountCreatedObserver {

	public SMSSenderImpl() {
		super();
	}

	public void sendSMS() {
		System.out.println("send SMS Account changed");
	}

	@Override
	public void accountCreated(Event event) {
		if (event.getSource() instanceof Account){			
			sendSMS();
		}
	}

	@Override
	public void accountChanged(Event event) {
		if (event.getSource() instanceof Account){			
			sendSMS();
		}
	}

}
