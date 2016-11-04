package observer;

public interface AccountChangedObserver extends Observer {
	
	/**
     * Invoked when an account changed event occurs.
     */
    public void accountChanged(Event event);

}
