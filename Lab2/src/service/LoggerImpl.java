package service;

import entity.Account;
import observer.Event;
import observer.Observer;

public class LoggerImpl implements Observer {

	public LoggerImpl() {
		super();
	}

	public void log() {
		System.out.println("Logger log Account changed");
	}

	@Override
	public void handleEvent(Event<?> event) {
		if (event.getSource() instanceof Account){			
			log();
		}
	}

}
