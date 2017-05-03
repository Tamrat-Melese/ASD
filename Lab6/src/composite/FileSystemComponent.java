package composite;

public abstract class FileSystemComponent {

	protected ComponentType type;
	protected String name;

	public FileSystemComponent(ComponentType type, String name) {
		super();
		this.type = type;
		this.name = name;
	}

	public abstract void print();
	public abstract int computeSize();

}
