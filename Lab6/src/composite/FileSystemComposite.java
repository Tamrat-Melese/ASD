package composite;

import java.util.ArrayList;
import java.util.Collection;

public abstract class FileSystemComposite extends FileSystemComponent {
	
	protected Collection<FileSystemComponent> fileSystemList = new ArrayList<FileSystemComponent>();

	public FileSystemComposite(ComponentType type, String name) {
		super(type, name);
	}

	public void addFile(File file) {
		fileSystemList.add(file);
	}

	public void addDir(Directory directory) {
		fileSystemList.add(directory);
	}
	
	@Override
	public void print() {
		for (FileSystemComponent fileSystem : fileSystemList) {
			fileSystem.print();
		}
	}

	@Override
	public int computeSize() {
		int sizeInBytes = 0;
		for (FileSystemComponent dir : fileSystemList) {
			sizeInBytes += dir.computeSize();
		}
		return sizeInBytes;
	}

}
