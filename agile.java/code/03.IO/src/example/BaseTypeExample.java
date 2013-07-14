package example;

import java.io.*;
import java.util.*;

public class BaseTypeExample {
	private List<LogRecord> recs = 
		new ArrayList<LogRecord>();

	public void add(LogRecord rec) {
		this.recs.add(rec);
	}

	public List<LogRecord> getRecs() {
		return this.recs;
	}

	public void clearRecs() {
		this.recs.clear();
	}

	public void store(String fileName) throws IOException {
		if(null != this.recs && this.recs.size() > 0) {
			DataOutputStream o = null;
			try{
				o = new DataOutputStream(
						new FileOutputStream(fileName));
				o.writeInt(this.recs.size());
				for(LogRecord r: this.recs) {
					o.writeLong(r.getId());
					o.writeUTF(r.getName());
					o.writeLong(r.getCreateTime().getTime());
				}
			} finally {
				o.close();
			}
		}
	}

	public void load(String fileName) throws IOException {
		this.recs.clear();
		DataInputStream ipt = null;
		try {
			ipt = new DataInputStream(
					new FileInputStream(fileName));
			int recCount = ipt.readInt();
			for(int i=0; i< recCount; i++) {
				LogRecord r = new LogRecord();
				r.setId(ipt.readLong());
				r.setName(ipt.readUTF());
				r.setCreateTime(new Date(ipt.readLong()));
				this.recs.add(r);
			}
		} finally {
			ipt.close();
		}
	}

}
