package application;

public interface Command {
	public void execute();
	default void undo() {}
}
