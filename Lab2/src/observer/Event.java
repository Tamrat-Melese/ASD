package observer;

public class Event<T> {
	
	private T source;
	private Operation operation;
	
	public Event(T source, Operation operation) {
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
