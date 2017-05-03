package application;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class AccountInvoker {
	
	private Map<AccountOperation, Command> commands = new HashMap<>();
	
	Stack<Command> undoCommands = new Stack<>();
	Stack<Command> redoCommands = new Stack<>();
 
	public AccountInvoker() {
	}
  
	public void setCommand(AccountOperation operation, Command command) {
		commands.put(operation, command);
	}
	 
	public void runCommand(AccountOperation operation) {
		commands.get(operation).execute();
		undoCommands.push(commands.get(operation));
	}
	 
	public void undoCommand() {
		Command undoCommand = undoCommands.pop();
		undoCommand.undo();
		redoCommands.push(undoCommand);
	}
	 
	public void redoCommand() {
		Command redoCommand = redoCommands.pop();
		redoCommand.execute();
		undoCommands.push(redoCommand);
	}

}
