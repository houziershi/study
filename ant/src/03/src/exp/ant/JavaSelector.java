package exp.ant;

import java.io.File;
import org.apache.tools.ant.types.selectors.FileSelector;

public class JavaSelector implements FileSelector {
	
	public boolean isSelected(File b, String filename, File f) {
		return filename.toLowerCase().endWith(".java");
	}
}
