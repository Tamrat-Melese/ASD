package observer;

public class Event {
	
	private Object source;
	private Operation operation;
	
	public Event(Object source, Operation operation) {
		super();
		this.source = source;
		this.operation = operation;
	}

	public Object getSource() {
		return source;
	}

	public Operation getOperation() {
		return operation;
	}
	
}
