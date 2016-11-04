package service;

import entity.Account;
import observer.Event;
import observer.Observer;
import observer.Operation;

public class EmailSenderImpl implements Observer {

	public EmailSenderImpl() {
		super();
	}
	
	public void sendEmail(){
		System.out.println("send email Account created");
	}

	@Override
	public void handleEvent(Event<?> event) {
		if (	event.getSource() instanceof Account &&
				event.getOperation() == Operation.CREATE
		){
			sendEmail();
		}
	}

}
