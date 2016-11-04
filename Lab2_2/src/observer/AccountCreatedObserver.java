package observer;

public interface AccountCreatedObserver extends Observer{
	
	/**
     * Invoked when an account created event occurs.
     */
    public void accountCreated(Event event);

}
