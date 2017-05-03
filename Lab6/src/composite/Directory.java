package composite;

public class Directory extends FileSystemComposite {

	public Directory(String name) {
		super(ComponentType.DIRECTORY, name);
	}

	public void print() {
		System.out.println("-- dir " + name + " size=" + computeSize() + " bytes");
		super.print();
	}
}
