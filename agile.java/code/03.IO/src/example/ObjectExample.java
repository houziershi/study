package example;

import java.io.*;
import java.util.*;

public class ObjectExample {
	private List<LogRecSe> recs = 
		new ArrayList<LogRecSe>();

	public void add(LogRecSe rec) {
		this.recs.add(rec);
	}

	public List<LogRecSe> getRecs() {
		return this.recs;
	}

	public void clearRecs() {
		this.recs.clear();
	}

	public void store(String fileName) throws IOException {
		if(null != this.recs && this.recs.size() > 0) {
			ObjectOutputStream o = null;
			try{
				o = new ObjectOutputStream(
						new FileOutputStream(fileName));
				o.writeObject(recs);
			} finally {
				o.close();
			}
		}
	}

	public void load(String fileName) throws IOException, 
			ClassNotFoundException 
	{
		this.recs.clear();
		ObjectInputStream ipt = null;
		try {
			ipt = new ObjectInputStream(
					new FileInputStream(fileName));
			int recCount = ipt.readInt();
			this.recs = (List<LogRecSe>) ipt.readObject();
		} finally {
			ipt.close();
		}
	}

}
