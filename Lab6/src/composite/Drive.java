package composite;

public class Drive extends FileSystemComposite {

	public Drive(String name) {
		super(ComponentType.DRIVE, name);
	}

	public void print() {
		System.out.println("- drive " + name);
		super.print();
	}
}
