package observer;

public interface Observer {
	
	public void handleEvent(Event<?> event);
}
