package framework.command;

public interface Command {
	public void execute();
	default void undo() {}
}
