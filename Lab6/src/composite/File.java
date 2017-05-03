package composite;

public class File extends FileSystemComponent {
	
	private int sizeInBytes;

	public File(String name, int sizeInBytes) {
		super(ComponentType.FILE, name);
		
		this.sizeInBytes = sizeInBytes;
	}

	public int getSizeInBytes() {
		return sizeInBytes;
	}

	@Override
	public void print() {
		System.out.println("--- file " + name + " size=" + getSizeInBytes() + "bytes");
	}

	@Override
	public int computeSize() {
		return getSizeInBytes();
	}
}
