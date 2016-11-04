package service;

import entity.Account;
import observer.AccountCreatedObserver;
import observer.Event;

public class EmailSenderImpl implements AccountCreatedObserver  {

	public EmailSenderImpl() {
		super();
	}
	
	public void sendEmail(){
		System.out.println("send email Account created");
	}

	@Override
	public void accountCreated(Event event) {
		if (event.getSource() instanceof Account){
			sendEmail();
		}
	}

}
