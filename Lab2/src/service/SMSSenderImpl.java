package service;

import entity.Account;
import observer.Event;
import observer.Observer;

public class SMSSenderImpl implements Observer {

	public SMSSenderImpl() {
		super();
	}

	public void sendSMS() {
		System.out.println("send SMS Account changed");
	}

	@Override
	public void handleEvent(Event<?> event) {
		if (event.getSource() instanceof Account){			
			sendSMS();
		}
	}

}
