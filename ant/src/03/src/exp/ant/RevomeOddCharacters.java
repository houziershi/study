package exp.ant;

// ... other packages
import org.apache.tools.ant.types.filters.ChainableReader;

public class RevomeOddCharacters implements ChainableReader{
	
	public Reader chain(Reader reader) {
		return new BaseFilterReader(reader) {
			int count = 0;
			public int read() throws IOException{
				// other
			}
		}
	}

}
